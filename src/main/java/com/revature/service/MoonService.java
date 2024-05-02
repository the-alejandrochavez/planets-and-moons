package com.revature.service;

import java.util.List;

import com.revature.models.Moon;
import com.revature.repository.MoonDao;

public class MoonService {

	private MoonDao dao;

	public MoonService(MoonDao dao) {
		this.dao = dao;
	}

	public List<Moon> getAllMoons(int ownerId) {
		// TODO implement
		return dao.getAllMoons(ownerId);
	}

	public Moon getMoonByName(int ownerId, String moonName) {
		// TODO implement
		if (moonName.length() <= 30) {
			return dao.getMoonByName(ownerId, moonName);
		}
		return null;
	}

	public Moon getMoonById(int ownerId, int moonId) {
		// TODO Aimplement
		return dao.getMoonById(ownerId, moonId);
	}

	public Moon createMoon(Moon m) {
		// TODO implement
		if (m.getName().length() <= 30) {
			Moon validMoon = new Moon();
			validMoon.setName(m.getName());
			validMoon.setMyPlanetId(m.getMyPlanetId());
			return dao.createMoon(validMoon);
		}
		return null;
	}

	public boolean deleteMoonById(int moonId) {
		// TODO implement
		return dao.deleteMoonById(moonId);
	}

	public List<Moon> getMoonsFromPlanet(int myPlanetId) {
		// TODO Auto-generated method stub
		return null;
	}
}
