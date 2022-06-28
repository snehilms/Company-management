//package com.company.springboot.controller;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.anyString;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//import com.company.springboot.model.Role;
//import com.company.springboot.model.User;
//import com.company.springboot.services.IUserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//
//import java.util.ArrayList;
//
//import org.apache.catalina.connector.Response;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@ContextConfiguration(classes = {UserController.class})
//@ExtendWith(SpringExtension.class)
//public class UserControllerTest {
//    @MockBean
//    private IUserService iUserService;
//
//    @Autowired
//    private UserController userController;
//
//    @Test
//    public void testGetUsers() throws Exception {
//        when(this.iUserService.getUsers()).thenReturn(new ArrayList<User>());
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/get_users");
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("[]"));
//    }
//
//    @Test
//    public void testGetUsers2() throws Exception {
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(new ArrayList<Role>());
//
//        ArrayList<User> userList = new ArrayList<User>();
//        userList.add(user);
//        when(this.iUserService.getUsers()).thenReturn(userList);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/get_users");
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string("[{\"id\":1,\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":[]}]"));
//    }
//
//    @Test
//    public void testGetUsers3() throws Exception {
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(new ArrayList<Role>());
//
//        User user1 = new User();
//        user1.setPassword("iloveyou");
//        user1.setUsername("janedoe");
//        user1.setId(1);
//        user1.setRoles(new ArrayList<Role>());
//
//        ArrayList<User> userList = new ArrayList<User>();
//        userList.add(user1);
//        userList.add(user);
//        when(this.iUserService.getUsers()).thenReturn(userList);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/get_users");
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "[{\"id\":1,\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":[]},{\"id\":1,\"username\":\"janedoe\",\"password"
//                                        + "\":\"iloveyou\",\"roles\":[]}]"));
//    }
//
//    @Test
//    public void testSaveUser() throws Exception {
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(new ArrayList<Role>());
//        when(this.iUserService.saveUser((User) any())).thenReturn(user);
//
//        User user1 = new User();
//        user1.setPassword("iloveyou");
//        user1.setUsername("janedoe");
//        user1.setId(1);
//        user1.setRoles(new ArrayList<Role>());
//        String content = (new ObjectMapper()).writeValueAsString(user1);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/save_user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string("{\"id\":1,\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":[]}"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/users/save_user"));
//    }
//
//    @Test
//    public void testSaveUser2() throws Exception {
//        Role role = new Role();
//        role.setId(1);
//        role.setName("?");
//
//        ArrayList<Role> roleList = new ArrayList<Role>();
//        roleList.add(role);
//
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(roleList);
//        when(this.iUserService.saveUser((User) any())).thenReturn(user);
//
//        User user1 = new User();
//        user1.setPassword("iloveyou");
//        user1.setUsername("janedoe");
//        user1.setId(1);
//        user1.setRoles(new ArrayList<Role>());
//        String content = (new ObjectMapper()).writeValueAsString(user1);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/save_user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "{\"id\":1,\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":[{\"id\":1,\"name\":\"?\"}]}"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/users/save_user"));
//    }
//
//    @Test
//    public void testSaveUser3() throws Exception {
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(new ArrayList<Role>());
//        when(this.iUserService.saveUser((User) any())).thenReturn(user);
//
//        Role role = new Role();
//        role.setId(1);
//        role.setName("?");
//
//        ArrayList<Role> roleList = new ArrayList<Role>();
//        roleList.add(role);
//
//        User user1 = new User();
//        user1.setPassword("iloveyou");
//        user1.setUsername("janedoe");
//        user1.setId(1);
//        user1.setRoles(roleList);
//        String content = (new ObjectMapper()).writeValueAsString(user1);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/save_user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string("{\"id\":1,\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":[]}"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/users/save_user"));
//    }
//
//    @Test
//    public void testSaveRole() throws Exception {
//        Role role = new Role();
//        role.setId(1);
//        role.setName("Name");
//        when(this.iUserService.saveRole((Role) any())).thenReturn(role);
//
//        Role role1 = new Role();
//        role1.setId(1);
//        role1.setName("Name");
//        String content = (new ObjectMapper()).writeValueAsString(role1);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/save_role")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\"}"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/users/save_role"));
//    }
//
//    @Test
//    public void testAddRoleToUser() throws Exception {
//        doNothing().when(this.iUserService).addRoleToUser(anyString(), anyString());
//
//        RoleToUserForm roleToUserForm = new RoleToUserForm();
//        roleToUserForm.setUsername("janedoe");
//        roleToUserForm.setRoleName("Role Name");
//        String content = (new ObjectMapper()).writeValueAsString(roleToUserForm);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/role_to_user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        MockMvcBuilders.standaloneSetup(this.userController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void testRefreshToken() throws IOException {
//        UserController userController = new UserController();
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        assertThrows(RuntimeException.class, () -> userController.refreshToken(request, new Response()));
//    }
//}
//
