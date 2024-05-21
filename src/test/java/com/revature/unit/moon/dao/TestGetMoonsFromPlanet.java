package com.revature.unit.moon.dao;

import com.revature.models.Moon;
import com.revature.repository.MoonDao;
import com.revature.utilities.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestGetMoonsFromPlanet {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    public void testGetMoonsFromPlanet() {
        int planetId = 5;

        List<Moon> expectedList = new ArrayList<>();
        Moon m = new Moon();
        Moon m2 = new Moon();
        m.setName("Moon");
        m.setMyPlanetId(planetId);
        m2.setName("Celius");
        m2.setMyPlanetId(planetId);
        expectedList.add(m);
        expectedList.add(m2);

        MoonDao moonDao = new MoonDao();
        List<Moon> actualList = moonDao.getMoonsFromPlanet(planetId);

        Assertions.assertEquals(expectedList.get(1).getMyPlanetId(),actualList.get(1).getMyPlanetId());
    }
}
