package com.company.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class CompanyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyBackendApplication.class, args);
	}
//	@Bean
//	CommandLineRunner run(IUserService userService)
//	{
//		return args-> {
//			userService.saveRole(new Role("USER"));
//			userService.saveRole(new Role("ADMIN"));
//			
//			userService.saveUser(new User("snehilms","1234",new ArrayList<>()));
//			userService.saveUser(new User("prohunter","5678", new ArrayList<>()));
//			
//			userService.addRoleToUser("snehilms", "USER");
//			userService.addRoleToUser("prohunter", "ADMIN");
//		};
//	}
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	

}
