package com.jayanta.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jayanta.entity.Instructor;
import com.jayanta.entity.InstructorDetail;



public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			// create the objects
			int instructorId = 2;
			//get instructor by primary key --> id
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			
			/*Instructor tempInstructor = session.get(Instructor.class, instructorId); will return
			 * null if instructor with mentioned id not found so, print if found.
			 */
			//TO-DO code betterment
			System.out.println("Found instructor with id : "+instructorId+ " as "+tempInstructor);
		    // delete instructor
			if(tempInstructor !=null) {
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





