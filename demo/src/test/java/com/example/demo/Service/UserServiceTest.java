package com.example.demo.Service;


import com.example.demo.Domain.UserLogin;
import com.example.demo.EncryptionDecryption.EncryptDecrypt;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Utilities.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private EncryptDecrypt encryptDecrypt;
    @Mock
    private Mail mail;
    @InjectMocks
    private  UserService userService;

    @Test
    public void addUser() throws Exception {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername("amulya123");
        userLogin.setPassword("amulya");
        userLogin.setUserEmail("amulya123@gmail.com");
        userLogin.setTimeStamps(new Timestamp(new Date().getTime()));
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.empty());
        assertNotNull(userService.addUser(userLogin).getUserName());
    }

    @Test
    public void updatePassword() {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername("sairam36");
        userLogin.setPassword("sairam12");
        userLogin.setUserEmail("sairam21240306@gmail.com");
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.of(userLogin));
        assertEquals("Password Changed Successfully!!",userService.updatePassword(userLogin));
    }

    @Test
    public void forgotPassword() {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername("sairam36");
        userLogin.setUserEmail("sairam21240306@gmail.com");
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.of(userLogin));
        assertEquals("Sent an Link!!",userService.forgotPassword(userLogin));
    }
    @Test
    public void loginUser() {
       UserLogin userLogin = new UserLogin();
        userLogin.setUsername("sairam36");
        userLogin.setPassword("sairam");
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.of(userLogin));
        when(encryptDecrypt.decrypt(anyString(),anyString())).thenReturn(userLogin.getPassword());
        assertEquals("Login Success",userService.loginUser(userLogin));
    }
    @Test
    public void findUser()throws Exception {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername("sairam36");
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.of(userLogin));
        assertEquals(userLogin,userService.findUser("sairam36"));
    }
}