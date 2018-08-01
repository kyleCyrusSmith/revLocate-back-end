package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component @Entity @Table(name="Locations")
public class Location {
	
	@Id @Column(name="LocationID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int locationId;
	
	@Column(name="Latitude")
	private double latitude;
	
	@Column(name="Longitude")
	private double longitude;
	
	@Column(name="Common_Weather")
	private String commonWeather;
	
	@Column(name="Local_Language")
	private String localLanguage;
	
	@Column(name="Difficulty")
	private String difficulty;

	public Location () {}
	
	
	
	public Location(int locationId, double laditude, double longitude, String commonWeather, String localLanguage,
			String difficulty) {
		super();
		this.locationId = locationId;
		this.latitude = laditude;
		this.longitude = longitude;
		this.commonWeather = commonWeather;
		this.localLanguage = localLanguage;
		this.difficulty = difficulty;
	}



	public Location(int locationId) {
		super();
		this.locationId = locationId;
	}



	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLaditude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCommonWeather() {
		return commonWeather;
	}

	public void setCommonWeather(String commonWeather) {
		this.commonWeather = commonWeather;
	}

	public String getLocalLanguage() {
		return localLanguage;
	}

	public void setLocalLanguage(String localLanguage) {
		this.localLanguage = localLanguage;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	

}
