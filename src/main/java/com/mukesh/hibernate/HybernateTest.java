package com.mukesh.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.mukesh.hibernate.entity.Address;
import com.mukesh.hibernate.entity.UserDetail;

public class HybernateTest {

	public static void main(String[] args) {
		UserDetail user = new UserDetail();
		user.setUserId(4);
		user.setUserName("Mukesh");
		user.setJoinedDate(new Date());
		// user.setAddress("Address field goes here");
		user.setDescription("description goes here");

		user.setUserName("Second User");
		Address address = new Address();
		address.setCity("City Name1");
		address.setStreet("Street Name1");
		address.setPincode("pincode1");
		address.setState("state1");
		//user.setHome_address(address);
		
		
		Address officeaddress = new Address();
		officeaddress.setCity("City Name2");
		officeaddress.setStreet("Street Name2");
		officeaddress.setPincode("pincode2");
		officeaddress.setState("state2");
		//user.setOffice_address(officeaddress);
		
		user.getListOfAddress().add(address);
		user.getListOfAddress().add(officeaddress);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetail) session.get(UserDetail.class, 1);
		//System.out.println("The value retrived as " + user.getUserName());
		System.out.println("The value retrived as " + user.getListOfAddress().size());
                session.close();
                

	}
}
