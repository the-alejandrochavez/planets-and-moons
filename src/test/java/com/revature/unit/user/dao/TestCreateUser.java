package com.revature.unit.user.dao;

import com.revature.models.User;
import com.revature.models.UsernamePasswordAuthentication;
import com.revature.repository.UserDao;
import com.revature.utilities.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    public void testCreateUser() {
        UsernamePasswordAuthentication user = new UsernamePasswordAuthentication();
        user.setUsername("Adrian");
        user.setPassword("Pass");

        UserDao userDao = new UserDao();
        User expectedUser = new User();
        User actualUser = userDao.createUser(user);

        Assertions.assertEquals(expectedUser, actualUser);
    }
}
