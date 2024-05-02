package com.revature.service;

import java.util.List;

import com.revature.models.Planet;
import com.revature.repository.PlanetDao;

public class PlanetService {

	private PlanetDao dao;

	public PlanetService(PlanetDao dao) {
		this.dao = dao;
	}

	public List<Planet> getAllPlanets(int ownerId) {
		return dao.getAllPlanets(ownerId);
	}

	public Planet getPlanetByName(int ownerId, String planetName) {
		if (planetName.length() <= 30) {
			return dao.getPlanetByName(ownerId, planetName);
		}
		return null;
	}

	public Planet getPlanetById(int ownerId, int planetId) {
		return dao.getPlanetById(ownerId, planetId);
	}

	public Planet createPlanet(int ownerId, Planet planet) {
		if (planet.getName().length() <= 30) {
			if (getPlanetByName(ownerId, planet.getName()).getName() == null) {
				Planet validPlanet = new Planet();
				validPlanet.setName(planet.getName());
				validPlanet.setOwnerId(ownerId);
				return dao.createPlanet(validPlanet);
			}
		}
		return null;
	}

	public boolean deletePlanetById(int ownerId, int planetId) {
		if (getPlanetById(ownerId, planetId).getOwnerId() == ownerId) {
			return dao.deletePlanetById(planetId);
		}
		return false;
	}
}
