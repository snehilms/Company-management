//package com.company.springboot.services;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.anyString;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.company.springboot.model.Role;
//import com.company.springboot.model.User;
//import com.company.springboot.repository.RoleRepository;
//import com.company.springboot.repository.UserRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {UserService.class})
//@ExtendWith(SpringExtension.class)
//public class UserServiceTest {
//    @MockBean
//    private PasswordEncoder passwordEncoder;
//
//    @MockBean
//    private RoleRepository roleRepository;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void testSaveUser() {
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(new ArrayList<Role>());
//        when(this.userRepository.save((User) any())).thenReturn(user);
//        when(this.passwordEncoder.encode((CharSequence) any())).thenReturn("foo");
//
//        User user1 = new User();
//        user1.setPassword("iloveyou");
//        user1.setUsername("janedoe");
//        user1.setId(1);
//        user1.setRoles(new ArrayList<Role>());
//        assertSame(user, this.userService.saveUser(user1));
//        verify(this.userRepository).save((User) any());
//        verify(this.passwordEncoder).encode((CharSequence) any());
//        assertEquals("foo", user1.getPassword());
//        assertTrue(this.userService.getUsers().isEmpty());
//    }
//
//    @Test
//    public void testSaveRole() {
//        Role role = new Role();
//        role.setId(1);
//        role.setName("Name");
//        when(this.roleRepository.save((Role) any())).thenReturn(role);
//
//        Role role1 = new Role();
//        role1.setId(1);
//        role1.setName("Name");
//        assertSame(role, this.userService.saveRole(role1));
//        verify(this.roleRepository).save((Role) any());
//        assertTrue(this.userService.getUsers().isEmpty());
//    }
//
//    @Test
//    public void testAddRoleToUser() {
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(new ArrayList<Role>());
//        when(this.userRepository.findByUsername(anyString())).thenReturn(user);
//
//        Role role = new Role();
//        role.setId(1);
//        role.setName("Name");
//        when(this.roleRepository.findByName(anyString())).thenReturn(role);
//        this.userService.addRoleToUser("janedoe", "Role Name");
//        verify(this.userRepository).findByUsername(anyString());
//        verify(this.roleRepository).findByName(anyString());
//        assertTrue(this.userService.getUsers().isEmpty());
//    }
//
//    @Test
//    public void testGetUser() {
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(new ArrayList<Role>());
//        when(this.userRepository.findByUsername(anyString())).thenReturn(user);
//        assertSame(user, this.userService.getUser("janedoe"));
//        verify(this.userRepository).findByUsername(anyString());
//        assertTrue(this.userService.getUsers().isEmpty());
//    }
//
//    @Test
//    public void testGetUsers() {
//        ArrayList<User> userList = new ArrayList<User>();
//        when(this.userRepository.findAll()).thenReturn(userList);
//        List<User> actualUsers = this.userService.getUsers();
//        assertSame(userList, actualUsers);
//        assertTrue(actualUsers.isEmpty());
//        verify(this.userRepository).findAll();
//    }
//
//    @Test
//    public void testLoadUserByUsername() throws UsernameNotFoundException {
//        User user = new User();
//        user.setPassword("iloveyou");
//        user.setUsername("janedoe");
//        user.setId(1);
//        user.setRoles(new ArrayList<Role>());
//        when(this.userRepository.findByUsername(anyString())).thenReturn(user);
//        UserDetails actualLoadUserByUsernameResult = this.userService.loadUserByUsername("janedoe");
//        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
//        assertTrue(actualLoadUserByUsernameResult.isEnabled());
//        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
//        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
//        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
//        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
//        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
//        verify(this.userRepository).findByUsername(anyString());
//        assertTrue(this.userService.getUsers().isEmpty());
//    }
//}
//
