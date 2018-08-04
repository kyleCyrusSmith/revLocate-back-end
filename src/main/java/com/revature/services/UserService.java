package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Set;
import com.revature.beans.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repo;
	
	public List<Set> getSetsFromUser(User u){
		return repo.getSetsFromUser(u.getUserId());
	}
	
	public User login(User u) {
		return repo.login(u);
	}
	
	public User updateUser(User u) {
		return repo.updateUser(u);
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
				System.out.println("Email is bad");
				response = -2;
			}
		}else {
			System.out.println("Username is bad");
			response = -1;
		}
		
		return response;
	}
	public List<User> getAllFriends(User user){
		return repo.getAllFriends(user);
		
	}
	
	public int addUser(User user, User target) {
		return repo.addFriend(user, target);
	}
	
	public int deleteUser(User user, User target) {
		return repo.removeFriend(user, target);
	}
}
