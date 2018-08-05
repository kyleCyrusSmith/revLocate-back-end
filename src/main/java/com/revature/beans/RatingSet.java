package com.revature.beans;

public class RatingSet {
	private double rating;
	private Set set;
	
	public RatingSet() {}

	public RatingSet(double rating, Set set) {
		super();
		this.rating = rating;
		this.set = set;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
}
