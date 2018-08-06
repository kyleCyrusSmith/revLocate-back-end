package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Set;

@Transactional
@Repository
public class SetRepository {
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * This method gets all of the sets in the database.
	 * @return
	 */
	public List<Set> getAllSets() {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Set", Set.class).getResultList();
	}
	/**
	 * This method grabs the set of the given id.
	 * @param i
	 * @return
	 */
	public Set getSetById(int i) {
		Session s = sessionFactory.getCurrentSession();
		Set grabbedSet = s.get(Set.class, i);
		return grabbedSet;
	}
	/**
	 * This method insets a new Set into the database
	 * @param newSet
	 * @return
	 */
	public Set newSet(Set newSet) {
		System.out.println("gets to this point");
		Session s = sessionFactory.getCurrentSession();
		System.out.println("buildCustomset => set info: "+newSet.toString());
		System.out.println("buildCustomset => set name: "+newSet.getName());
		System.out.println("buildCustomset => set authorId: "+newSet.getAuthorId());
		System.out.println("buildCustomset => set location1: "+newSet.getLoc1());
		System.out.println("buildCustomset => set location2: "+newSet.getLoc2());
		System.out.println("buildCustomset => set location3: "+newSet.getLoc3());
		s.save("Sets", newSet);
		return newSet;
	}
	/**
	 * This method updates the set.
	 * @param updatedSet
	 * @return
	 */
	public Set updateSet(Set updatedSet) {
		Session s = sessionFactory.getCurrentSession();
		Set newSet = s.get(Set.class, updatedSet.getSetId());
		
		newSet = updatedSet;
		s.merge(newSet);
		return newSet;
	}
	

}
