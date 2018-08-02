package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Set;
import com.revature.beans.User;
import com.revature.services.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/users")
public class UserController {
	@Autowired
	UserService uservice;
	
	//Tested on POSTMAN on 7/27/2018 @ 10:08 AM, Works. -Algustus Lee
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> loginUser(@RequestBody User u) {
		User temp = uservice.login(u);
		if(u.getUsername()==null || u.getPassword() ==null) {
			System.out.println("no dice, captain");
			return new ResponseEntity<User>(HttpStatus.UNPROCESSABLE_ENTITY);
		}else if(temp == null) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}
	
	//Tested on POSTMAN on 7/27/2018 @ 11:05
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registerUser(@RequestBody User u){
		System.out.println("the username: "+u.getUsername());
		System.out.println("the password: "+u.getPassword());
		System.out.println("the email: "+u.getEmail());
		if(u.getUsername()==null || u.getPassword() ==null) {
			System.out.println("no dice, captain");
		}
		int workingCode = uservice.register(u);
		
		System.out.println("The code is: "+workingCode);
		if(workingCode == 1) {
			return new ResponseEntity<User>(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User u){
		User user = uservice.updateUser(u);
		
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<User>(HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping(value="/sets",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Set> allUserSets(@RequestBody User u) {
		List<Set> userSets = uservice.getSetsFromUser(u);
		if(userSets.size() > 0) {
			return userSets;
		}
		else {
			return null;
		}
	}
	
	
}
