package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
<<<<<<< HEAD
=======
	static {
		System.out.println("Main Service method called");
	}
>>>>>>> 8fa629b157e6e7b04677fc696651e8740c35ded1
	@Autowired
	UserRepository repo;
	
	public User login(User u) {
		return repo.login(u);
	}
	
	public boolean checkForUsername(String un) {
		return repo.checkForUsername(un);
	}
	
	public boolean checkForEmail(String email) {
		return repo.checkForEmail(email);
	}
	public int register(User u) {
		int response= 0;
		if(repo.checkForUsername(u.getUsername())) {
			if(repo.checkForEmail(u.getEmail())) {				
				repo.register(u);
				response = 1;
			}
			else {
				response = -2;
			}
		}else {
			response = -1;
		}
		
		return response;
	}
}
