package com.revature.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Location;
import com.revature.repositories.LocationRepository;

@Service
public class LocationService {
	@Autowired
	LocationRepository repo;
	
	public Location getSpecificLocation(int id) {
		Location grabbedLocation = repo.getLocationById(id);
		return grabbedLocation;
	}
	
	public Location getRandomLocation() {
		Random rand = new Random();
		int value = rand.nextInt(repo.getAllLocations().size());
		Location randomLocation = repo.getLocationById(value); 
		
		return randomLocation;
	}

}
