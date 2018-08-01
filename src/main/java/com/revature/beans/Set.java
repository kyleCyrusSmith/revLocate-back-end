package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component @Entity @Table(name="Sets")
public class Set {
	
	@Id @Column(name="SetID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int setId;
	
	@Column(name="LocationID_1")
	private int loc1;
	
	@Column(name="LocationID_2")
	private int loc2;
	
	@Column(name="LocationID_3")
	private int loc3;
	
	@Column(name="LocationID_4")
	private int loc4;
	
	@Column(name="LocationID_5")
	private int loc5;
	
	@Column(name="Author")
	private int authorId;
	
	@Column(name="Rating")
	private int Rating;
	
	@Column(name="High_Score")
	private int highScore;
	
	public Set() {}
	
	

	public Set(int setId, int authorId, int rating, int highScore) {
		super();
		this.setId = setId;
		this.authorId = authorId;
		Rating = rating;
		this.highScore = highScore;
	}



	public Set(int setId, int authorId) {
		super();
		this.setId = setId;
		this.authorId = authorId;
	}



	public Set(int setId, int loc1, int loc2, int loc3, int loc4, int loc5, int authorId, int rating, int highScore) {
		super();
		this.setId = setId;
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.loc3 = loc3;
		this.loc4 = loc4;
		this.loc5 = loc5;
		this.authorId = authorId;
		Rating = rating;
		this.highScore = highScore;
	}



	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	public int getLoc1() {
		return loc1;
	}

	public void setLoc1(int loc1) {
		this.loc1 = loc1;
	}

	public int getLoc2() {
		return loc2;
	}

	public void setLoc2(int loc2) {
		this.loc2 = loc2;
	}

	public int getLoc3() {
		return loc3;
	}

	public void setLoc3(int loc3) {
		this.loc3 = loc3;
	}

	public int getLoc4() {
		return loc4;
	}

	public void setLoc4(int loc4) {
		this.loc4 = loc4;
	}

	public int getLoc5() {
		return loc5;
	}

	public void setLoc5(int loc5) {
		this.loc5 = loc5;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

}
