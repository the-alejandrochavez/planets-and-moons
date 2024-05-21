//package com.revature.unit.planet.dao;
//
//import com.revature.repository.PlanetDao;
//import com.revature.utilities.ConnectionUtil;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class TestDeletePlanetById {
//    public Connection conn;
//
//    @BeforeEach
//    public void setUp() throws SQLException {
//        conn = ConnectionUtil.createConnection();
//    }
//
//    @Test
//    @DisplayName("Delete Planet By Id")
//    public void testDeletePlanetById() {
//        int planetId = 13;
//
//        boolean expectedResult = true;
//
//        PlanetDao planetDao = new PlanetDao();
//        boolean actualResult = planetDao.deletePlanetById(planetId);
//
//        Assertions.assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    @DisplayName("Delete Planet By Id (Does Not Exist)")
//    public void testDeletePlanetByIdDoesNotExist() {
//        int planetId = 23;
//
//        boolean expectedResult = false;
//
//        PlanetDao planetDao = new PlanetDao();
//        boolean actualResult = planetDao.deletePlanetById(planetId);
//
//        Assertions.assertEquals(expectedResult, actualResult);
//    }
//}
