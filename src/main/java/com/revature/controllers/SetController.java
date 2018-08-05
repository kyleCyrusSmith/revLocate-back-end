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

import com.revature.beans.RatingSet;
import com.revature.beans.Set;
import com.revature.services.SetService;

@CrossOrigin
@RestController
@RequestMapping(value="/sets")
public class SetController {
	@Autowired
	SetService sservice;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Set>> getAllSets(){
		List<Set> allSets = sservice.getAllSets();
		if(allSets.size() > 0) {
			return new ResponseEntity<List<Set>>(sservice.getAllSets(), HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Set>>(HttpStatus.NO_CONTENT);
		}
		
	}
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set> getSetByID(@PathVariable int id) {
		Set specSet = sservice.getSetById(id);
		if(specSet == null) {
			return new ResponseEntity<Set>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Set>(specSet, HttpStatus.OK);			
		}
	}
	@GetMapping(value="/random", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set> getRandomSet() {
		Set randSet = sservice.getRandomSet();
		if(randSet == null) {
			return new ResponseEntity<Set>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Set>(randSet, HttpStatus.OK);			
		}
	}
	
	@PostMapping(value="/rate",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set> rateSet(@RequestBody RatingSet rs) {
		new DecimalFormat("#.#").format(rs.getRating());
		sservice.rateSet(rs.getSet(), rs.getRating());
		if(rs.getSet() == null) {
			return new ResponseEntity<Set>(rs.getSet(), HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Set>(rs.getSet(), HttpStatus.OK);
		}
	}
	@PostMapping(value="/new",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set> newSet(@RequestBody Set us){
		if(us != null) {
			sservice.newSet(us);
			return new ResponseEntity<Set>(us, HttpStatus.CREATED);	
		}else {
			return new ResponseEntity<Set>(us, HttpStatus.METHOD_NOT_ALLOWED);
		}
		
	}

}
