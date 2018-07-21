package com.reavature.drivers;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Student;

public class StudentDriver {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	
		//Retrive a Session from the SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			
//			// CREATE STUDENT DEMO
//			// Create a Student object
//			System.out.println("Creating a new student object...");
//			Student myStudent = new Student("Wezley", "Singleton", "ws@gmail.com");
//			
//			// Start a transaction
//			session.beginTransaction();
//			
//			// Save the student
//			System.out.println("Saving the student to the DB");
//			session.save(myStudent);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Student successfully saved!");
			
			//--------------------------------------------------
			
			/*
			 * HIBERNATE & PRIMARY KEYS
			 */
			//Create an array of students
//			System.out.println("Creating students array");
//			Student[] students = {
//					new Student("Blake", "kruppa", "bk@gmail.com"),
//					new Student("Steven", "Kelsy", "sk@gmail.com"),
//					new Student("Genesis", "Bonds", "bk@gmail.com")
//			};
//			
//			// Start transaction
//			session.beginTransaction();
//			
//			// Save each student in the array to the DB
//			System.out.println("Saving the students to the DB");
//			for(Student student: students) {
//				session.save(student);
//			}
//			// Commit the transaction
//			session.getTransaction().commit();
//			
//			System.out.println(students.length + " students saved to the DB");
			
			//------------------------------------------------------------------
			
			/*
			 * READ STUDENT DEMO
			 */
//			Student myStudent = new Student("David", "Fay", "df@gmail.com");
//			session.beginTransaction();
//			session.save(myStudent);
//			session.getTransaction().commit();
//			
//			// See that our student has an accessible id value
//			System.out.println("New student added with id: " + myStudent.getId());
//			
//			// Get a new session and begin a transaction
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Retrieve the student from the DB using its PK
//			System.out.println("Retrieving student with id: " + myStudent.getId());
//			Student student = session.get(Student.class, myStudent.getId());
//			System.out.println("Student successuflly retrieved: " + student);
//			
//			// Commit the transaction
//			session.getTransaction().commit();
			
			/*
			 * READ STUDENT DEMO (USING QUERY)
			 */
			
//			session.beginTransaction();
//			
//			System.out.println();
//			List<Student> students = session.createQuery("from Student").getResultList();
//			
//			displayStudents(students);
//
//			
//			// Query for studnets with last name 'Singleton'
//			System.out.println("Retrieving all studnets with last name 'Singleton'");
//			students = session.createQuery("from Student s where s.lastName = 'Singleton'").getResultList();
//			displayStudents(students);
//			
//			// Query for students wiht last name 'Singleton' OR first name 'Blake'
//			System.out.println("Retrieving all studnets with last name 'Singleton' or first name 'Blake'");
//			Query query = session.createQuery("from Student s where s.lastName = ? OR s.firstname = ?");
//			query.setParameter(0, "Singleton");
//			query.setParameter(1, "Blake");
//			students = query.getResultList();
//			displayStudents(students);
//			
//			// Query for students where email ends with 'k@gmail.com'
//			System.out.println("Retrieving students with email ending with 'k@gmail.com'");
//			students = session.createQuery("from Student s where s.email like '%k@gmail.com'").getResultList();
//			displayStudents(students);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student student : students) {
			System.out.println(student);
		}
	}
}
