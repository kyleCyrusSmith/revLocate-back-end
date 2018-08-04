package com.revature.beans;

public class FriendRelation {
	private User user;
	private User target;
	
	public FriendRelation(User user, User target) {
		super();
		this.user = user;
		this.target = target;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getTarget() {
		return target;
	}
	public void setTarget(User target) {
		this.target = target;
	}
	
	
	
}
