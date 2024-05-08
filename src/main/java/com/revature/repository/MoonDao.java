package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// import com.revature.exceptions.MoonFailException;
import com.revature.models.Moon;
import com.revature.utilities.ConnectionUtil;

public class MoonDao {

	public List<Moon> getAllMoons(int ownerId) {
		List<Moon> moons = new ArrayList<>();
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from moons m join planets p on m.myPlanetId = p.id where p.ownerId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ownerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Moon moon = new Moon();
				moon.setId(rs.getInt("id"));
				moon.setName(rs.getString("name"));
				moon.setMyPlanetId(rs.getInt("myPlanetId"));
				moons.add(moon);
			}
			return moons;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Moon getMoonByName(int ownerId, String moonName) {
		Moon moon = new Moon();
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from moons m join planets p on m.myPlanetId = p.id where p.ownerId = ? and m.name = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ownerId);
			ps.setString(2, moonName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				moon.setId(rs.getInt("id"));
				moon.setName(rs.getString("name"));
				moon.setMyPlanetId(rs.getInt("myPlanetId"));
			}

			String p_sql = "select * from planets where ownerId = ? and name = ?";
			PreparedStatement p_ps = connection.prepareStatement(p_sql);
			p_ps.setInt(1, ownerId);
			p_ps.setString(2, moonName);
			ResultSet p_rs = p_ps.executeQuery();

			if (p_rs.getString("name") == moon.getName()) {
				return null;
			}
			if (p_rs.getString("name") != null) {
				moon.setName(p_rs.getString("name"));
			}

			return moon;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Moon getMoonById(int ownerId, int moonId) {
		Moon moon = new Moon();
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from moons m join planets p on m.myPlanetId = p.id where p.ownerId = ? and m.id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ownerId);
			ps.setInt(2, moonId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				moon.setId(rs.getInt("id"));
				moon.setName(rs.getString("name"));
				moon.setMyPlanetId(rs.getInt("myPlanetId"));
			}
			if (moon.getId() == 0) {
				return null;
			}
			return moon;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Moon createMoon(Moon m) {
		Moon createdMoon = new Moon();
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "insert into moons (name, myPlanetId) values (?,?)";
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, m.getName());
			ps.setInt(2, m.getMyPlanetId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				createdMoon.setId(rs.getInt(1));
				createdMoon.setName(m.getName());
				createdMoon.setMyPlanetId(m.getMyPlanetId());
			}
			System.out.println("I CREATED IT");
			return createdMoon;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return new Moon();
		}
	}

	public boolean deleteMoonById(int ownerId, int moonId) {
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "delete from moons where myPlanetId in (select id from planets where ownerId = ?) and id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ownerId);
			ps.setInt(2, moonId);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public List<Moon> getMoonsFromPlanet(int planetId) {
		List<Moon> moons = new ArrayList<>();
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from moons where myPlanetId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, planetId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Moon moon = new Moon();
				moon.setId(rs.getInt("id"));
				moon.setName(rs.getString("name"));
				moon.setMyPlanetId(rs.getInt("myPlanetId"));
				moons.add(moon);
			}
			return moons;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
