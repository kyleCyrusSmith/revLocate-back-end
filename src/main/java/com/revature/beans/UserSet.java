package com.revature.beans;

import java.util.ArrayList;

public class UserSet {
	private User user;
	private ArrayList<Set> sets;
	private Set set;
	
	public UserSet() {}
	
	public UserSet(User user, Set set) {
		super();
		this.user = user;
		this.set = set;
	}
	
	public UserSet(User user, ArrayList<Set> sets) {
		super();
		this.user = user;
		this.sets = sets;
	}
	
	public UserSet(User user, ArrayList<Set> sets, Set set) {
		super();
		this.user = user;
		this.sets = sets;
		this.set = set;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public ArrayList<Set> getSets() {
		return sets;
	}

	public void setSets(ArrayList<Set> sets) {
		this.sets = sets;
	}
}
