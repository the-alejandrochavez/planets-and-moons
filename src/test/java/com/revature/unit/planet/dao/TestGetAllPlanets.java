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
import java.util.ArrayList;
import java.util.List;

public class TestGetAllPlanets {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    @DisplayName("List All Planets")
    public void testGetAllPlanets() {
        int ownerId = 1;
        PlanetDao planetDao = new PlanetDao();

        List<Planet> expectedList = new ArrayList<>();
        Planet e = new Planet();
        e.setName("Earth");
        e.setOwnerId(ownerId);
        expectedList.add(e);

        List<Planet> actualList = planetDao.getAllPlanets(ownerId);

        Assertions.assertEquals(expectedList.get(0).getName(), actualList.get(0).getName());
    }

    @Test
    @DisplayName("List All Planets (Empty)")
    public void testGetAllPlanetsEmpty() {
        int ownerId = 2;
        PlanetDao planetDao = new PlanetDao();
        List<Planet> expectedList = new ArrayList<>();

        List<Planet> actualList = planetDao.getAllPlanets(ownerId);

        Assertions.assertEquals(expectedList, actualList);
    }
}
