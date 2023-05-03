package com.app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Student;

public class App {

	public static void main(String[] args) {

		// Step 1
		Configuration conf = new Configuration();

		conf.configure("hibernate.cfg.xml");

		// Step 2

		SessionFactory factory = conf.buildSessionFactory();

		// Step 3
		Session session = factory.openSession();

		// Step 4
		Transaction tx = session.beginTransaction();
		
		  Student s1=new Student(); 
		  s1.setId(101); s1.setName("aniket");
		  s1.setMarks(89);
		  
		 // Step 5
		 session.save(s1);
		 

		/*String sql = "select s.name,s.marks from Student s";
		Query query = session.createQuery(sql);

		List list = query.list();

		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			Object ob[]=(Object [])iterator.next();

			System.out.println("  "+ob[0]+"  "+ob[1]);

		}
*/
		// Strp 6
		tx.commit();

		session.close();
		factory.close();

		System.out.println("Success Added");

	}

}


