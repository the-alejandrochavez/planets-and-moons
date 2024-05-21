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

public class TestGetMoonByName {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    @DisplayName("Get Moon By Name")
    public void testGetMoonByName() {
        int ownerId = 1;
        String moonName = "Moon";

        Moon expectedMoon = new Moon();
        expectedMoon.setName(moonName);
        expectedMoon.setMyPlanetId(5);

        MoonDao moonDao = new MoonDao();
        Moon actualMoon = moonDao.getMoonByName(ownerId, moonName);

        Assertions.assertEquals(expectedMoon.getName(), actualMoon.getName());
    }

    @Test
    @DisplayName("Get Moon By Name (Does Not Exist)")
    public void testGetMoonByNameDoesNotExist() {
        int ownerId = 1;
        String moonName = "Moon-2";

        MoonDao moonDao = new MoonDao();
        Moon actualMoon = moonDao.getMoonByName(ownerId, moonName);

        Assertions.assertNull(actualMoon);
    }
}
