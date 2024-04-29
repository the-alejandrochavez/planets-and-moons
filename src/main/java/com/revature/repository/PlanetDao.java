package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Planet;
import com.revature.utilities.ConnectionUtil;

public class PlanetDao {

	public List<Planet> getAllPlanets() {
		// TODO: implement
		List<Planet> planets = new ArrayList<>();
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from planets";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Planet planet = new Planet();
				planet.setId(rs.getInt("id"));
				planet.setName(rs.getString("name"));
				planet.setOwnerId(rs.getInt("ownerId"));
				planets.add(planet);
			}
			return planets;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Planet getPlanetByName(String planetName) {
		// TODO: implement
		Planet planet = new Planet();
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "select * from planets where name = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, planetName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				planet.setId(rs.getInt("id"));
				planet.setName(rs.getString("name"));
				planet.setOwnerId(rs.getInt("ownerId"));
			}
			return planet;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Planet getPlanetById(int planetId) {
		// TODO: implement
		return null;
	}

	public Planet createPlanet(Planet p) {
		Planet createdPlanet = new Planet();
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "insert into planets (name, ownerId) values (?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getOwnerId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				createdPlanet.setId(rs.getInt(1));
				createdPlanet.setName(p.getName());
				createdPlanet.setOwnerId(p.getOwnerId());
			}
			return createdPlanet;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return new Planet();
		}
	}

	public boolean deletePlanetById(int planetId) {
		// TODO Auto-generated method stub
		try (Connection connection = ConnectionUtil.createConnection()) {
			String sql = "delete from planets where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, planetId);
			ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
