package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component @Entity @Table(name="Friends")
public class FriendList {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user")
	private int user1;
	
	@Column(name="friend")
	private int user2;
	
	public FriendList() {}

	public FriendList(int id, int user1, int user2) {
		super();
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser1() {
		return user1;
	}

	public void setUser1(int user1) {
		this.user1 = user1;
	}

	public int getUser2() {
		return user2;
	}

	public void setUser2(int user2) {
		this.user2 = user2;
	}
	
	
	
	}
