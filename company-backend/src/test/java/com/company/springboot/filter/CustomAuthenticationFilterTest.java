//package com.company.springboot.filter;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//
//public class CustomAuthenticationFilterTest {
//    @Test
//    public void testConstructor() {
//        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<AuthenticationProvider>();
//        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
//        CustomAuthenticationFilter actualCustomAuthenticationFilter = new CustomAuthenticationFilter(
//                new ProviderManager(authenticationProviderList));
//        assertEquals("username", actualCustomAuthenticationFilter.getUsernameParameter());
//        assertTrue(actualCustomAuthenticationFilter
//                .getRememberMeServices() instanceof org.springframework.security.web.authentication.NullRememberMeServices);
//        assertEquals("password", actualCustomAuthenticationFilter.getPasswordParameter());
//    }
//}
//
