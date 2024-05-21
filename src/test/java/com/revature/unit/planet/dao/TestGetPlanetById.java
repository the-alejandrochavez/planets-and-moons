package com.revature.unit.planet.dao;

import com.revature.models.Planet;
import com.revature.repository.PlanetDao;
import com.revature.utilities.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestGetPlanetById {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    @DisplayName("Get Planet By Id")
    public void testGetPlanetById() {
        int ownerId = 1;
        int planetId = 5;

        Planet expectedPlanet = new Planet();
        expectedPlanet.setId(planetId);
        expectedPlanet.setOwnerId(ownerId);

        PlanetDao planetDao = new PlanetDao();
        Planet actualPlanet = planetDao.getPlanetById(ownerId, planetId);

        Assertions.assertEquals(expectedPlanet, actualPlanet);
    }

    @Test
    @DisplayName("Get Planet By Id (Does Not Exist)")
    public void testGetPlanetByIdDoesNotExist() {
        int ownerId = 1;
        int planetId = 23;

        PlanetDao planetDao = new PlanetDao();
        Planet actualPlanet = planetDao.getPlanetById(ownerId, planetId);

        Assertions.assertNull(actualPlanet);
    }
}
