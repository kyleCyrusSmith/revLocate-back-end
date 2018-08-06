package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Location;

@Transactional
@Repository
public class LocationRepository {
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * A function made to create new locations, a feature to allow users to click on locations
	 * on the map, get the longitude and latitude of it, and have it placed as a new location in the
	 * database.
	 * @param newLocation
	 * @return
	 */
	public Location makeNewLocation(Location newLocation) {
		Session s = sessionFactory.getCurrentSession();
		s.save("Locations",newLocation);
		return newLocation;
		
	}
	
	/**
	 * A function made to get a location in the database of the specified ID.
	 * @param id
	 * @return
	 */
	public Location getLocationById(int id) {
		Session s = sessionFactory.getCurrentSession();
		Location grabbedLocation = s.get(Location.class, id);
		return grabbedLocation;
		
	}
	
	public List<Location> getAllLocations(){
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Location", Location.class).getResultList();
	}
}
