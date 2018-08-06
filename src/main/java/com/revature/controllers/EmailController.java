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

import com.revature.beans.Message;
import com.revature.beans.User;
import com.revature.services.UserService;
import com.revature.util.Email;

@CrossOrigin
@RestController
@RequestMapping(value="/messages")
public class EmailController {
	@Autowired
	Email mail;
	@Autowired
	UserService uservice;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> updateAlert(@RequestBody Message m){
		List<User> ulist = uservice.getAllUsers();
		m.setUserList(ulist);
		for(User user:ulist) {
			System.out.println("called user "+user.getUsername());
			Email.sendMail("revalocate@gmail.com", user.getEmail(), m.getMessageSubject() , m.getMessageBody());
		}
		
		return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
	}
}
