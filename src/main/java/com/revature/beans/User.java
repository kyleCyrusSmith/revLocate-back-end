package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component @Entity @Table(name="Users")
public class User {
	/**
	 * use the /** to make the javadoc, explain what methods do on substantial methods
	 */
	@Id @Column(name="Userid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="High_Score")
	private int highScore;
	
	@Column(name="Coins")
	private int coins;
	
	public User () {}

	public User(String username) {
		super();
		this.username = username;
	}
	
	public User(int userId) {
		super();
		this.userId = userId;
	}
	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public User(String username, String password, String email, int highScore, int coins) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.highScore = highScore;
		this.coins = coins;
	}


	public User(int userId, String username, String password, String email, int highScore, int coins) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.highScore = highScore;
		this.coins = coins;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}
}