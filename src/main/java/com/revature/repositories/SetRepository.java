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
	 * This method gets all of the sets from one specific user. That integer is pulled from the userId
	 * of the author.
	 * @param i
	 * @return
	 */
	public List<Set> getSetsFromUser(int i){
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Sets where Author = :userId", Set.class).setParameter("userId", i).getResultList();
	}
	/**
	 * This method insets a new Set into the database
	 * @param newSet
	 * @return
	 */
	public Set buildCustomSet(Set newSet) {
		Session s = sessionFactory.getCurrentSession();
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
		s.merge(updatedSet);
		return updatedSet;
	}
	

}
