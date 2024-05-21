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

public class TestGetPlanetByName {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    @DisplayName("Get Planet By Name")
    public void testGetPlanetByName() {
        int ownerId = 1;
        String planetName = "Earth";

        Planet expectedPlanet = new Planet();
        expectedPlanet.setName(planetName);
        expectedPlanet.setOwnerId(ownerId);

        PlanetDao planetDao = new PlanetDao();
        Planet actualPlanet = planetDao.getPlanetByName(ownerId, planetName);

        Assertions.assertEquals(expectedPlanet.getName(), actualPlanet.getName());
    }

    @Test
    @DisplayName("Get Planet By Name (Does Not Exist)")
    public void testGetPlanetByNameDoesNotExist() {
        int ownerId = 1;
        String planetName = "Mercury";

        PlanetDao planetDao = new PlanetDao();
        Planet actualPlanet = planetDao.getPlanetByName(ownerId, planetName);

        Assertions.assertNull(actualPlanet);
    }
}
