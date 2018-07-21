package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
	
		try {
			
			// Create teh SessionFactory using the hibernate.cfg.xml file
			Configuration config = new Configuration();
			config.configure();//if you use a different name specify it inside
			
			
			return config.buildSessionFactory();
			
		} catch (Throwable t) {
			t.printStackTrace();
			throw new ExceptionInInitializerError(t);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}
	
	
	
	
	
}
