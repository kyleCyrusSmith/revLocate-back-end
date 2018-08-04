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
	
	//Tested on POSTMAN on 8/2/2018 @ 3:37 PM, Works. -Algustus Lee
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
			return new ResponseEntity<User>(temp, HttpStatus.OK);
		}
	}
	
	//Tested on POSTMAN on 7/27/2018 @ 11:05
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registerUser(@RequestBody User u){
		System.out.println("the username: "+u.getUsername());
		System.out.println("the password: "+u.getPassword());
		System.out.println("the email: "+u.getEmail());
		if(u.getUsername()==null || u.getPassword() ==null) {
			System.out.println("no dice, captain");
		}
		int workingCode = uservice.register(u);
		
		System.out.println("The code is: "+workingCode);
		if(workingCode == 1) {
			return new ResponseEntity<Integer>(workingCode, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Integer>(workingCode, HttpStatus.CONFLICT);
		}
	}
	
	//POSTMAN tested on 8/2/2018 at 4:55 PM, it works -Al
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User u){
		User user = uservice.updateUser(u);
		
		if(user == null) {
			return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping(value="/sets",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Set> allUserSets(User u) {
		List<Set> userSets = uservice.getSetsFromUser(u);
		if(userSets.size() > 0) {
			return userSets;
		}
		else {
			return userSets;
		}
	}
	
	//POSTMAN tested on 8/3/2018 @ 8:20PM, this returns all friends added by the logged in user.
	//It will return an empty list if there are no added friends. No matter what, it will return a 200.
	@GetMapping(value="/friends",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getFriends(User u){
		return uservice.getAllFriends(u);
	}
	
	
}
