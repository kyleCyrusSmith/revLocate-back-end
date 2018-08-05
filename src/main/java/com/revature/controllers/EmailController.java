package com.revature.controllers;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

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
/*	@Autowired
	Email mail;
	@Autowired
	UserService uservice;
	
	@PostMapping(value="/game-updates",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> updateAlert(){
		List<User> ulist = uservice.getAllUsers();
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", 587); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");
		
    	Session session = Session.getDefaultInstance(props, 
    		    new javax.mail.Authenticator(){
    		        protected PasswordAuthentication getPasswordAuthentication() {
    		            return new PasswordAuthentication(
    		                "revalocate@gmail.com", "P4ssw0rd!");// Specify the Username and the PassWord
    		        }
    		});
    	String body = String.join(
        	    System.getProperty("line.separator"),
        	    "<h1>Game's been updated!</h1>",
        	    "<p>The game has been updated! We got new features and things!", 
        	    "It'll be tons of fun, go see what you can find!</p>."
        	);
		for(User user:ulist) {
			System.out.println("called user "+user.getUsername());
			Email.sendMail(session, user.getEmail(), "Here's something new to Locate with revLocate!" , body);
		}
		
		return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
	}*/
}
