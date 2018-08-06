package com.revature.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Set;
import com.revature.repositories.SetRepository;

@Service
public class SetService {
	@Autowired
	SetRepository repo;
	
	public Set rateSet(Set theSet, double rating) {
		theSet.setTotalRated(theSet.getTotalRated() + 1);
		theSet.setTotalRating(theSet.getTotalRating()+rating);
		theSet.setRating((theSet.getTotalRating()) /theSet.getTotalRated());
		return repo.updateSet(theSet);
	}
	public Set updateSet(Set updatedSet) {
		return repo.updateSet(updatedSet);
	}
	public Set newSet(Set set) {
		System.out.println("set info: "+set.toString());
		System.out.println("set name: "+set.getName());
		System.out.println("set authorId: "+set.getAuthorId());
		System.out.println("set location1: "+set.getLoc1());
		System.out.println("set location2: "+set.getLoc2());
		System.out.println("set location3: "+set.getLoc3());
		System.out.println("set location4: "+set.getLoc4());
		System.out.println("set location5: "+set.getLoc5());
		//System.out.println(repo.buildCustomSet(set));
		return repo.newSet(set);
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
		System.out.println("The number of sets to choose from is: "+repo.getAllSets().size());
		System.out.println("the random number is: "+(value+1));
		Set randomSet = repo.getAllSets().get(value); 
		
		return randomSet;
	}
}
