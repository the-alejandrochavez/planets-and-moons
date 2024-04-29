package com.revature.service;

import java.util.List;

import com.revature.models.Planet;
import com.revature.repository.PlanetDao;

public class PlanetService {

	private PlanetDao dao;

	public PlanetService(PlanetDao dao) {
		this.dao = dao;
	}

	public List<Planet> getAllPlanets() {
		return dao.getAllPlanets();
	}

	public Planet getPlanetByName(int ownerId, String planetName) {
		// TODO Auto-generated method stub
		if (planetName.length() <= 30) {
			System.out.println("IM HEREEE");
			return dao.getPlanetByName(planetName);
		}
		return null;
	}

	public Planet getPlanetById(int ownerId, int planetId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Planet createPlanet(int ownerId, Planet planet) {
		// TODO Auto-generated method stub
		if (planet.getName().length() <= 30) {
			Planet validPlanet = new Planet();
			validPlanet.setName(planet.getName());
			validPlanet.setOwnerId(ownerId);
			return dao.createPlanet(validPlanet);
		}
		return null;
	}

	public boolean deletePlanetById(int ownerId, int planetId) {
		// TODO Auto-generated method stub
		return dao.deletePlanetById(planetId);
	}
}
