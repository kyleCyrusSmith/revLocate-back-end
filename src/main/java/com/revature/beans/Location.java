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
	
	@Column(name="Author")
	private int author;

	@Column(name="Altitude")
	private double altitude;
	
	@Column(name="Timezone")
	private String timeZone;
	public Location () {}
	}
