//package com.revature.unit.moon.dao;
//
//import com.revature.models.Moon;
//import com.revature.repository.MoonDao;
//import com.revature.utilities.ConnectionUtil;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class TestCreateMoon {
//    public Connection conn;
//
//    @BeforeEach
//    public void setUp() throws SQLException {
//        conn = ConnectionUtil.createConnection();
//    }
//
//    @Test
//    @DisplayName("Create Moon")
//    public void testCreateMoon() {
//        int myPlanetId = 5;
//        String moonName = "Celius";
//
//        Moon expectedMoon = new Moon();
//        expectedMoon.setName(moonName);
//        expectedMoon.setMyPlanetId(myPlanetId);
//
//        Moon m = new Moon();
//        m.setName(moonName);
//        m.setMyPlanetId(myPlanetId);
//
//        MoonDao moonDao = new MoonDao();
//        Moon actualMoon = moonDao.createMoon(m);
//
//        Assertions.assertEquals(expectedMoon.getName(), actualMoon.getName());
//    }
//
//    @Test
//    @DisplayName("Create Moon (Already exist)")
//    public void testCreateMoonThatExist() {
//        int myPlanetId = 5;
//        String moonName = "Moon";
//
//        Moon expectedMoon = null;
//
//        Moon m = new Moon();
//        m.setName(moonName);
//        m.setMyPlanetId(myPlanetId);
//
//        MoonDao moonDao = new MoonDao();
//        Moon actualMoon = moonDao.createMoon(m);
//
//        Assertions.assertEquals(expectedMoon, actualMoon);
//    }
//}
