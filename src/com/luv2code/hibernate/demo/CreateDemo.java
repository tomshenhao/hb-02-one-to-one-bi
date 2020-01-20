package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
//			Instructor tempInstructor = 
//					new Instructor("Chad","Darby","darby@luv2code.com");
//			
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail(
//							"http://www.luv2code.com/youtube", 
//							"Luv 2 code!!!");
			
			Instructor tempInstructor = 
					new Instructor("Madhu","Patel","madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://youtube.com", 
							"Guitar");
			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			System.out.println("Saving the Instructor..."+tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			factory.close();
		}
		
	}

}
