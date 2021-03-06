package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.FriendRelation;
import com.revature.beans.Set;
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
	 * Grabs a user by their id
	 * @param id
	 * @return
	 */
	public User getUserById(int id) {
		Session s = sessionFactory.getCurrentSession();
		User grabbedUser = s.get(User.class, id);
		return grabbedUser;
	}
	/**
	 * Updates the user to the new settings inputted from the front end.
	 * @param u
	 */
	public User updateUser(User u) {
		Session s = sessionFactory.getCurrentSession();
		User user = s.get(User.class, u.getUserId());		
		
		user = u;
		s.merge(user);
		return user;
	}
	public User getUserByUsername(String username) {
		Session s = sessionFactory.getCurrentSession();
		String sqlString = "SELECT * FROM Users WHERE Username = :username";
		User grabbedUser = s.createNativeQuery(sqlString, User.class).setParameter("username", username).getSingleResult();
		return grabbedUser;
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
	public List<User> getAllUsers(){
		Session s = sessionFactory.getCurrentSession();
		List<User> theList = s.createQuery("From User", User.class).getResultList();
		return theList;
	}
	
	/**
	 * Function to get all the friends of the currently logged-in user.
	 * @param user the user that is logged in
	 * @return a list of all the users
	 */
	public List<User> getAllFriends(User user){
		Session s = sessionFactory.getCurrentSession();
		String sql = "Select * FROM Friends f INNER JOIN Users u ON u.UserID = f.friend WHERE f.user = :currentUser";
		List<User> theList = s.createNativeQuery(sql, User.class).setParameter("currentUser", user.getUserId()).getResultList();
		System.out.println(theList);
		return theList;
	}
	
	/**
	 * Checks to see if a user already has someone on their friends list.
	 * If they already have them on the friends' list, they cannot add them.
	 * @param user The logged-in user.
	 * @param target The person they want to add.
	 * @return returns 1 if someone was added, returns a 0 if someone was not.
	 */
	public int addFriend(FriendRelation fr) {
		Session s = sessionFactory.getCurrentSession();
		System.out.println("the user id: "+fr.getUser().getUserId());
		System.out.println("the target id: "+fr.getTarget().getUserId());
		String sql = "Select * FROM Friends f WHERE user = :user AND friend = :target";
		List theList = s.createNativeQuery(sql)
				.setParameter("user", fr.getUser().getUserId())
				.setParameter("target", fr.getTarget().getUserId())
				.getResultList();
		System.out.println("size of the list: "+theList.size());
		if(theList.size() == 0) {
		String sqlString = "insert into Friends(user, friend)values(:user, :target)";
		Query q = s.createNativeQuery(sqlString)
			.setParameter("user", fr.getUser().getUserId())
			.setParameter("target", fr.getTarget().getUserId());
		return q.executeUpdate();
		}else {
			System.out.println("target is already a friend");
			return 0;
		}
	}
	
	/**
	 * Checks to see if a user already has someone on their friends list.
	 * If they don't have them on their list, they cannot remove them.
	 * @param user the logged in user
	 * @param target the (soon to be no longer) friend to be 
	 * @return returns a 1 if successful delete, a 0 if unsuccessful
	 */
	public int removeFriend(FriendRelation fr) {
		Session s = sessionFactory.getCurrentSession();
		String sql = "Select * FROM Friends f WHERE user = :user AND friend = :target";
		List theList = s.createNativeQuery(sql)
				.setParameter("user", fr.getUser().getUserId())
				.setParameter("target", fr.getTarget().getUserId())
				.getResultList();
		if(theList.size() == 1) {
			String sqlString = "delete from Friends where user = :user AND friend = :target";
			Query q = s.createNativeQuery(sqlString)
				.setParameter("user", fr.getUser().getUserId())
				.setParameter("target", fr.getTarget().getUserId());
			return q.executeUpdate();			
		}
		else {
			System.out.println("target wasn't on the user's friend's list to begin with");
			return 0;
		}
	}
}
