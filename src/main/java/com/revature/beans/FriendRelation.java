package com.revature.beans;

public class FriendRelation {
	private User user;
	private User target;
	private String targetName;
	
	public FriendRelation() {}
	
	public FriendRelation(User user, String targetName) {
		super();
		this.user = user;
		this.targetName = targetName;
	}

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

	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	
	
	
	
	
}
