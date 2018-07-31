package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Location;
import com.revature.beans.User;
import com.revature.services.LocationService;

@CrossOrigin
@RestController
@RequestMapping(value="/locations")
public class LocationController {
	
	@Autowired
	LocationService lservice;
	
	@GetMapping(value="/specific", produces=MediaType.APPLICATION_JSON_VALUE)
	public Location specificLocation(@RequestBody int i){
		Location specLoc = lservice.getSpecificLocation(i);
		return specLoc;		
	}
	
	@GetMapping(value="/random", produces=MediaType.APPLICATION_JSON_VALUE)
	public Location randomLocation(){
		Location randLoc= lservice.getRandomLocation();
		return randLoc;
	}
}
