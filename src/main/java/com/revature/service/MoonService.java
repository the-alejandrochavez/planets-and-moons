package com.revature.service;

import java.util.List;

import com.revature.models.Moon;
import com.revature.repository.MoonDao;

public class MoonService {

	private MoonDao dao;

	public MoonService(MoonDao dao) {
		this.dao = dao;
	}

	public List<Moon> getAllMoons() {
		// TODO implement
		return dao.getAllMoons();
	}

	public Moon getMoonByName(int myPlanetId, String moonName) {
		// TODO implement
		return null;
	}

	public Moon getMoonById(int myPlanetId, int moonId) {
		// TODO Aimplement
		return null;
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
		return false;
	}

	public List<Moon> getMoonsFromPlanet(int myPlanetId) {
		// TODO Auto-generated method stub
		return null;
	}
}
