package com.revature.unit.moon.dao;

import com.revature.models.Moon;
import com.revature.repository.MoonDao;
import com.revature.utilities.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestGetMoonById {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    @DisplayName("Get Moon By Id")
    public void testGetMoonById() {
        int ownerId = 1;
        int moonId = 2;

        Moon expectedMoon = new Moon();
        expectedMoon.setId(moonId);

        MoonDao moonDao = new MoonDao();
        Moon actualMoon = moonDao.getMoonById(ownerId, moonId);

        Assertions.assertEquals(expectedMoon, actualMoon);
    }

    @Test
    @DisplayName("Get Moon By Id (Does Not Exist)")
    public void testGetMoonByIdDoesNotExist() {
        int ownerId = 1;
        int moonId = 10;

        MoonDao moonDao = new MoonDao();
        Moon actualMoon = moonDao.getMoonById(ownerId, moonId);

        Assertions.assertNull(actualMoon);
    }
}
