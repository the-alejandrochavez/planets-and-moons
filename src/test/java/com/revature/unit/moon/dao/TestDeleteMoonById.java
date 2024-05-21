//package com.revature.unit.moon.dao;
//
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
//public class TestDeleteMoonById {
//    public Connection conn;
//
//    @BeforeEach
//    public void setUp() throws SQLException {
//        conn = ConnectionUtil.createConnection();
//    }
//
//    @Test
//    @DisplayName("Delete Moon By Id")
//    public void testDeleteMoonById() {
//        int ownerId = 1;
//        int moonId = 6;
//
//        boolean expectedResult = true;
//
//        MoonDao moonDao = new MoonDao();
//        boolean actualResult = moonDao.deleteMoonById(ownerId, moonId);
//
//        Assertions.assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    @DisplayName("Delete Moon By Id (Does Not Exist)")
//    public void testDeleteMoonByIdDoesNotExist() {
//        int ownerId = 1;
//        int moonId = 23;
//
//        boolean expectedResult = false;
//
//        MoonDao moonDao = new MoonDao();
//        boolean actualResult = moonDao.deleteMoonById(ownerId, moonId);
//
//        Assertions.assertEquals(expectedResult, actualResult);
//    }
//}
