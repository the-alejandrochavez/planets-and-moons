package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.MoonFailException;
import com.revature.models.Moon;
import com.revature.utilities.ConnectionUtil;

public class MoonDao {

	public List<Moon> getAllMoons() {
		// TODO: implement
		return null;
	}

	public Moon getMoonByName(String moonName) {
		// TODO: implement
		return null;
	}

	public Moon getMoonById(int moonId) {
		// TODO: implement
		return null;
	}

	public Moon createMoon(Moon m) {
		// TODO: implement
		try (Connection conn = ConnectionUtil.createConnection()) {
			String sql = "insert into moons (name, myPlanetId) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, m.getName());
			ps.setInt(2, m.getMyPlanetId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				Moon moon = new Moon();
				rs.getLong(1);
				m.getName();
				m.getMyPlanetId();
				return moon;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean deleteMoonById(int moonId) {
		// TODO: implement
		return false;
	}

	public List<Moon> getMoonsFromPlanet(int planetId) {
		// TODO: implement
		return null;
	}
}
