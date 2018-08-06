package com.revature.beans;

public class UserLocation {
	private User user;
	private Location loc;
	
	public UserLocation() {}

	public UserLocation(User user, Location loc) {
		super();
		this.user = user;
		this.loc = loc;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Location getLoc() {
		return loc;
	}



	public void setLoc(Location loc) {
		this.loc = loc;
	}
	

}
