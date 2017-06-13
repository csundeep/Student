package com.program.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.program.model.Course;
import com.program.util.HibernateUtil;

public class AddCourses implements ServletContextListener {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Session session = HibernateUtil.getNewSession();
		Transaction tx = session.beginTransaction();

		Course c1 = new Course();
		c1.setCourseId(1);
		c1.setCourseName("Java");

		Course c2 = new Course();
		c2.setCourseId(2);
		c2.setCourseName(".Net");

		Course c3 = new Course();
		c3.setCourseId(3);
		c3.setCourseName("PHP");

		Course c4 = new Course();
		c4.setCourseId(4);
		c4.setCourseName("Python");

		session.saveOrUpdate(c1);
		session.saveOrUpdate(c2);
		session.saveOrUpdate(c3);
		session.saveOrUpdate(c4);
		tx.commit();
		session.close();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		main(null);

	}
}

