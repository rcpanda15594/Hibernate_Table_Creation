package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		System.out.println("Configuration Started...");
		
	//Activate hb 
		
		Configuration cfg=new Configuration();
		
		//read cfgs file data
		
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		
		//build session factory object
		SessionFactory factory=cfg.buildSessionFactory();
		System.out.println("Session factory obj class name ==" +factory.getClass());
		//create session
		Session ses=factory.openSession();
		System.out.println("Session obj class name ==" +ses.getClass());
		//create entity classobj
		
		Employee emp=new Employee();
		
		emp.setEid(1004);
		emp.setEname("Rajesh");
		emp.setEmail("rajesh@gamil.com");
		emp.setSalary(25000);
		
		Transaction tx=null;
		try {
		tx=ses.beginTransaction();
		
		//save the obj
		ses.save(emp);
		
		//flush the session
//		ses.flush();
		tx.commit();
		System.out.println("Objct Saved/Record Inserted...");
		
		}
		catch (Exception e) {
			tx.rollback();
		}
		//close objs
		ses.close();
		factory.close();
		
		System.out.println("Session ended...");

	}

}
