package com.revature.unit.user.dao;

import com.revature.models.User;
import com.revature.repository.UserDao;
import com.revature.utilities.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestGetUserByUsername {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    @DisplayName("Get User By Username")
    public void testGetUserByUsername() {
        String username = "Alex";

        UserDao userDao = new UserDao();
        User expectedUser = new User();
        expectedUser.setUsername(username);
        User actualUser = userDao.getUserByUsername(username);

        Assertions.assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    }

    @Test
    @DisplayName("Get User By Username (User does not exist)")
    public void testGetUserByUsernameNonExistent() {
        String username = "User";

        UserDao userDao = new UserDao();
        User actualUser = userDao.getUserByUsername(username);

        Assertions.assertNull(actualUser);
    }

    @Test
    @DisplayName("Get User By Username (Blank username)")
    public void testGetUserByUsernameBlank() {
        String username = "";

        UserDao userDao = new UserDao();
        User actualUser = userDao.getUserByUsername(username);

        Assertions.assertNull(actualUser);
    }
}
