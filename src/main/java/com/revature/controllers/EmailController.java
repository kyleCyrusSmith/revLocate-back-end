package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;
import com.revature.util.Email;

@CrossOrigin
@RestController
@RequestMapping(value="/messages")
public class EmailController {
	/*@Autowired
	Email mail;
	@Autowired
	UserService uservice;
	
	@PostMapping(value="/game-updates",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> updateAlert(@RequestBody List<User> ulist){
		for(User user:ulist) {
			mail
		}
		
		return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
	}*/
}
