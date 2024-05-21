package com.revature.unit.user.service;

import com.revature.models.User;
import com.revature.models.UsernamePasswordAuthentication;
import com.revature.repository.UserDao;
import com.revature.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestRegister {
    @Mock
    public UserDao userDao;

    @InjectMocks
    public UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        User registerRequestData = new User();
        registerRequestData.setUsername("Matteo");
        registerRequestData.setPassword("Pass");

        Mockito.when(userDao.getUserByUsername(registerRequestData.getUsername())).thenReturn(null);

        UsernamePasswordAuthentication validUserData = new UsernamePasswordAuthentication();
        validUserData.setUsername("Matteo");
        validUserData.setPassword("Pass");

        Mockito.when(userDao.createUser(validUserData)).thenReturn(new User());

        User validUser = new User();
        validUser.setUsername("Matteo");
        validUser.setPassword("Pass");
        User registeredUser = userService.register(validUser);

        Assertions.assertNotNull(registeredUser);
    }
}
