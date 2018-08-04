package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Location;
import com.revature.beans.Set;
import com.revature.beans.UserLocation;
import com.revature.services.LocationService;

@CrossOrigin
@RestController
@RequestMapping(value="/locations")
public class LocationController {
	
	@Autowired
	LocationService lservice;
	
	@GetMapping(value="/{i}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> specificLocation(@PathVariable int i){
		Location specLoc = lservice.getSpecificLocation(i);
		if(specLoc == null) {
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Location>(specLoc, HttpStatus.OK);			
		}
	}
	
	@GetMapping(value="/random", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> randomLocation(){
		Location randLoc= lservice.getRandomLocation();
		return new ResponseEntity<Location>(randLoc, HttpStatus.OK);
	}
	@PostMapping(value="/new", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> newLocation(@RequestBody UserLocation ul) {
		if(ul.getLoc() != null && ul.getUser() != null) {
			lservice.newLocation(ul.getUser(), ul.getLoc());
			return new ResponseEntity<Location>(ul.getLoc(), HttpStatus.ACCEPTED);	
		}else {
			return new ResponseEntity<Location>(ul.getLoc(), HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}
