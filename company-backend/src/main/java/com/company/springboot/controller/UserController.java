package com.company.springboot.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.company.springboot.model.Role;
import com.company.springboot.model.User;
import com.company.springboot.services.IUserService;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/get_users")
	public ResponseEntity<List<User>> getUsers()
	{
		return ResponseEntity.ok().body(userService.getUsers());
	}
	@PostMapping("/save_user")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/save_user").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	@PostMapping("/save_role")
	public ResponseEntity<Role> saveRole(@RequestBody Role role)
	{
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/save_role").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}
	
	@PostMapping("/role_to_user")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form)
	{
		userService.addRoleToUser(form.getUsername(),form.getRoleName());
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException
	{
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer "))
        {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String accessToken = JWT.create().withSubject(user.getUsername())
    					.withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
    					.withIssuer(request.getRequestURL().toString())
    					.withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
    					.sign(algorithm);
 
//    			response.setHeader("access_token", accessToken);
//    			response.setHeader("refresh_token", refreshToken);
    			Map<String,String> tokens = new HashMap<>();
    			tokens.put("access_tokens",accessToken);
    			tokens.put("refresh_token", refreshToken);
    			response.setContentType(APPLICATION_JSON_VALUE);
    			new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    			
            }catch (Exception exception) {
                response.setStatus(FORBIDDEN.value());
                response.setHeader("error",exception.getMessage());
//                response.sendError(FORBIDDEN.value());
                Map<String,String> error = new HashMap<>();
                error.put("error_message",exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
     
            }

        }
        else{
           throw new RuntimeException("Refresh Token is missing");
        }
	}
	

}

@Data
class RoleToUserForm{
	private String username;
	private String roleName;
	
}
