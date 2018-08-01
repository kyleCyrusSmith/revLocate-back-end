package com.revature.services;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.revature.beans.Set;
import com.revature.beans.User;
import com.revature.repositories.SetRepository;

@Service
public class SetService {
	SetRepository repo;
	
	public Set rateSet(Set theSet, double rating) {
		theSet.setTotalRated(theSet.getTotalRated() + 1);
		theSet.setTotalRating((theSet.getTotalRating()+rating) /theSet.getTotalRated());
		repo.updateSet(theSet);
		return theSet;
	}
	
	public List<Set> getSetsFromUser(User u){
		return repo.getSetsFromUser(u.getUserId());
	}
	
	public Set newSet(Set set) {
		repo.buildCustomSet(set);
		return set;
	}
	
	public List<Set> getAllSets(){
		return repo.getAllSets();
	}
	
	public Set getSetById(int id) {
		return repo.getSetById(id);
	}
	
	public Set getRandomSet() {
		Random rand = new Random();
		int value = rand.nextInt(repo.getAllSets().size());
		Set randomSet = repo.getSetById(value); 
		
		return randomSet;
	}
}
