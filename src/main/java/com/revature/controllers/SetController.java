package com.revature.controllers;

import java.text.DecimalFormat;
import java.util.List;

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

import com.revature.beans.Set;
import com.revature.beans.User;
import com.revature.services.SetService;

@CrossOrigin
@RestController
@RequestMapping(value="/sets")
public class SetController {
	@Autowired
	SetService sservice;
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Set> getAllSets(){
		return sservice.getAllSets();
	}
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Set getSetByID(@PathVariable int id) {
		return sservice.getSetById(id);
	}
	@GetMapping(value="/random", produces=MediaType.APPLICATION_JSON_VALUE)
	public Set getRandomSet() {
		return sservice.getRandomSet();
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set> rateSet(Set theSet, double rating) {
		new DecimalFormat("#.#").format(rating);
		sservice.rateSet(theSet, rating);
		if(theSet == null) {
			return new ResponseEntity<Set>(theSet, HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Set>(theSet, HttpStatus.OK);
		}
	}
	@PostMapping(value="/new",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set> newSet(Set set, User user){
		set.setAuthorId(user.getUserId());
			sservice.newSet(set);
			return new ResponseEntity<Set>(set, HttpStatus.OK);
		
	}

}
