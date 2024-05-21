package com.revature.unit.user.dao;

import com.revature.models.User;
import com.revature.models.UsernamePasswordAuthentication;
import com.revature.repository.UserDao;
import com.revature.utilities.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestCreateUser {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    @DisplayName("Create Valid User")
    public void testCreateUser() {
        String name = "Alex";
        UsernamePasswordAuthentication user = new UsernamePasswordAuthentication();
        user.setUsername(name);
        user.setPassword("Pass");

        UserDao userDao = new UserDao();
        User expectedUser = new User();
        expectedUser.setUsername(name);
        expectedUser.setPassword("Pass");

        User actualUser = userDao.createUser(user);

        Assertions.assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    }

    @Test
    @DisplayName("Creating User That Exists")
    public void testCreateUserExist() {
        UsernamePasswordAuthentication user = new UsernamePasswordAuthentication();
        user.setUsername("Jose");
        user.setPassword("Pass");

        UserDao userDao = new UserDao();
        User expectedUser = null;
        User actualUser = userDao.createUser(user);

        Assertions.assertEquals(expectedUser, actualUser);
    }
}
