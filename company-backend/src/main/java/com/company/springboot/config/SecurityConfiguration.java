package com.company.springboot.config;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.company.springboot.filter.CustomAuthenticationFilter;
import com.company.springboot.filter.CustomAuthorizationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	public static final String[] PUBLIC_URLS= {"/v3/api-docs","/v2/api-docs","/api/v1/auth/**","/swagger-ui**","/webjars/**","/swagger-resources/**"
			
	};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.authorizeRequests().antMatchers("/login/**","/token/refresh/**").permitAll().antMatchers(PUBLIC_URLS).permitAll();
			http.authorizeRequests().antMatchers(GET,"/users/**").hasAnyAuthority("USER","ADMIN");
			http.authorizeRequests().antMatchers(POST,"/users/save_user/**").hasAnyAuthority("ADMIN");
			http.authorizeRequests().anyRequest().authenticated();
			http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
			http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		
		
    }
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	

}
