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
import com.revature.services.LocationService;

@CrossOrigin
@RestController
@RequestMapping(value="/locations")
public class LocationController {
	
	@Autowired
	LocationService lservice;
	
	//Tested 8/3/2018 @ 11:07 PM It works -Al
	@GetMapping(value="/{i}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> specificLocation(@PathVariable int i){
		Location specLoc = lservice.getSpecificLocation(i);
		if(specLoc == null) {
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Location>(specLoc, HttpStatus.OK);			
		}
	}
	
	//Tested 8/4/2018 @ 1:37 PM It works -Al
	@GetMapping(value="/random", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> randomLocation(){
		Location randLoc= lservice.getRandomLocation();
		if(randLoc == null) {
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Location>(randLoc, HttpStatus.OK);
	}
	
	//Tested 8/3/2018 @ 11:07pm It works -Al
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> newLocation(@RequestBody Location ul) {
		if(ul != null) {
			lservice.newLocation(ul);
			return new ResponseEntity<Location>(ul, HttpStatus.CREATED);	
		}else {
			return new ResponseEntity<Location>(ul, HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}
