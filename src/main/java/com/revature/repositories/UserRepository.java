package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;

@Transactional
@Repository
public class UserRepository {
	static {
		System.out.println("in the user repository");
	}
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Checks to see if a user can log in, and if they can, returns the logged in user.
	 * @param un the username to be passed in
	 * @param pw the password to be passed in
	 * @return it will return either the user if it can successfully find a user with that password, or null if it cannot
	 */
	public User login(User u) {
		Session s = sessionFactory.getCurrentSession();
		String hql = "from User u where u.username = :username and u.password = :password";
		List<User> result = s.createQuery(hql, User.class).setParameter("username", u.getUsername()).setParameter("password", u.getPassword()).getResultList();
		if(result.isEmpty()) {
			return null;
		}
		else {
			return result.get(0);
		}
	}
	
	/**
	 * Validation step for the front-end to make sure that the username is unique. It should help, given that the Username attribute
	 * is already specified as unique in the table.
	 * @param un the username to be passed in to be checked
	 * @return true or false, depending if there is or is not an email there
	 */
	public boolean checkForUsername(String un) {
		Session s = sessionFactory.getCurrentSession();
		String hql = "from User u where u.username = :username";
		List <User> result = s.createQuery(hql, User.class).setParameter("username", un).getResultList();
		if(result.isEmpty()) {
			return true;
		}else {
			return false;	
		}
	}
	/**
	 * Validation step for the front-end to make sure that email is unique. This should help, given that the email attribute is
	 * already specified as unique in the table.
	 * @param email the email to be passed in to be checked
	 * @return true or false, depending if there is or is not an email there
	 */
	public boolean checkForEmail(String email) {
		Session s = sessionFactory.getCurrentSession();
		String hql = "from User u where u.email = :email";
		List <User> result = s.createQuery(hql, User.class).setParameter("email", email).getResultList();
		if(result.isEmpty()) {
			return true;
		}else {
			return false;	
		}
	}
	
	/**
	 * Method to register a new user
	 * @return
	 */
	public User register(User u) {
		Session s = sessionFactory.getCurrentSession();
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());
		System.out.println(u.getEmail());
		s.save("Users", u);
		return u;
	}
}
