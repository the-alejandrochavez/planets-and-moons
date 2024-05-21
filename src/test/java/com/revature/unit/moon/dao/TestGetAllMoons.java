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
import java.util.ArrayList;
import java.util.List;

public class TestGetAllMoons {
    public Connection conn;

    @BeforeEach
    public void setUp() throws SQLException {
        conn = ConnectionUtil.createConnection();
    }

    @Test
    @DisplayName("List All Moons")
    public void testGetAllMoons() {
        int ownerId = 1;
        MoonDao moonDao = new MoonDao();

        List<Moon> expectedList = new ArrayList<>();
        Moon e = new Moon();
        e.setName("Moon");
        e.setMyPlanetId(5);
        expectedList.add(e);

        List<Moon> actualList = moonDao.getAllMoons(ownerId);

        Assertions.assertEquals(expectedList.get(0).getName(), actualList.get(0).getName());
    }

    @Test
    @DisplayName("List All Moons (Empty)")
    public void testGetAllMoonsEmpty() {
        int ownerId = 2;
        MoonDao moonDao = new MoonDao();
        List<Moon> expectedList = new ArrayList<>();

        List<Moon> actualList = moonDao.getAllMoons(ownerId);

        Assertions.assertEquals(expectedList, actualList);
    }
}
