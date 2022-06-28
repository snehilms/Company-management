//package com.company.springboot.filter;
//
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//
//import org.apache.catalina.connector.Response;
//import org.junit.jupiter.api.Test;
//import org.springframework.mock.web.MockHttpServletRequest;
//
//public class CustomAuthorizationFilterTest {
//    @Test
//    public void testDoFilterInternal() throws IOException, ServletException {
//        CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter();
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        Response response = new Response();
//        FilterChain filterChain = mock(FilterChain.class);
//        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
//        customAuthorizationFilter.doFilterInternal(request, response, filterChain);
//        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
//    }
//}
//
