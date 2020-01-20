package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			// get instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			// print instructor detail object
			System.out.println("tempInstructorDetail: "+tempInstructorDetail);
			
			
			// print instructor detail 
			System.out.println("the associate instructor: "+tempInstructorDetail.getInstructor());
			
			//delete instructor detail object
			System.out.println("deleting the tempInstructor...");
			
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
			
			factory.close();
		}
		
	}

}
