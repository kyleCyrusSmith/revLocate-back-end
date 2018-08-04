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
		System.out.println("Number of locations to choose from: "+repo.getAllLocations().size());
		System.out.println("The random number: "+(value+1));
		Location randomLocation = repo.getAllLocations().get(value); 
		
		return randomLocation;
	}
	
	public Location newLocation(Location loc) {
		return repo.makeNewLocation(loc);
	}

}
