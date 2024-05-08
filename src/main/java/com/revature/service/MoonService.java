package com.revature.service;

import java.util.List;

import com.revature.models.Moon;
import com.revature.repository.MoonDao;

public class MoonService {

	private MoonDao dao;
	private PlanetService planetService;

	public MoonService(MoonDao dao, PlanetService planetService) {
		this.dao = dao;
		this.planetService = planetService;
	}

	public MoonService(PlanetService planetService) {
		this.planetService = planetService;
	}

	public List<Moon> getAllMoons(int ownerId) {
		return dao.getAllMoons(ownerId);
	}

	public Moon getMoonByName(int ownerId, String moonName) {
		if (moonName.length() <= 30) {
			return dao.getMoonByName(ownerId, moonName);
		}
		return null;
	}

	public Moon getMoonById(int ownerId, int moonId) {
		return dao.getMoonById(ownerId, moonId);
	}

	public Moon createMoon(int ownerId, Moon m) {
		if (m.getName().length() <= 30 && planetService.getPlanetById(ownerId, m.getMyPlanetId()).getName() != null && m
				.getName().length() > 0) {
			if (getMoonByName(ownerId, m.getName()) == null) {
				Moon validMoon = new Moon();
				validMoon.setName(m.getName());
				validMoon.setMyPlanetId(m.getMyPlanetId());
				return dao.createMoon(validMoon);
			}

		}
		return null;
	}

	public boolean deleteMoonById(int ownerId, int moonId) {
		return dao.deleteMoonById(ownerId, moonId);
	}

	public List<Moon> getMoonsFromPlanet(int myPlanetId) {
		return dao.getMoonsFromPlanet(myPlanetId);
	}
}
