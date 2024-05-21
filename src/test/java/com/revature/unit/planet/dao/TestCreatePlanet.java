//package com.revature.unit.planet.dao;
//
//import com.revature.models.Planet;
//import com.revature.repository.PlanetDao;
//import com.revature.utilities.ConnectionUtil;
//import org.junit.jupiter.api.*;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class TestCreatePlanet {
//    public Connection conn;
//
//    @BeforeEach
//    public void setUp() throws SQLException {
//        conn = ConnectionUtil.createConnection();
//    }
//
//    @Test
//    @DisplayName("Create Planet")
//    public void testCreatePlanet() {
//        int ownerId = 1;
//        String planetName = "Saturn";
//
//        Planet expectedPlanet = new Planet();
//        expectedPlanet.setName(planetName);
//        expectedPlanet.setOwnerId(ownerId);
//
//        Planet p = new Planet();
//        p.setName(planetName);
//        p.setOwnerId(ownerId);
//
//        PlanetDao planetDao = new PlanetDao();
//        Planet actualPlanet = planetDao.createPlanet(p);
//
//        Assertions.assertEquals(expectedPlanet.getName(), actualPlanet.getName());
//    }
//
//    @Test
//    @DisplayName("Create Planet (Already exist)")
//    public void testCreatePlanetThatExist() {
//        int ownerId = 1;
//        String planetName = "Saturn";
//
//        Planet expectedPlanet = null;
//
//        Planet p = new Planet();
//        p.setName(planetName);
//        p.setOwnerId(ownerId);
//
//        PlanetDao planetDao = new PlanetDao();
//        Planet actualPlanet = planetDao.createPlanet(p);
//
//        Assertions.assertEquals(expectedPlanet, actualPlanet);
//    }
//}
