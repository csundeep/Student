package com.program.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.program.model.Department;
import com.program.util.HibernateUtil;

public class AddDepartment implements ServletContextListener {
	public static void main(String[] args) {
		Session session = HibernateUtil.getNewSession();
		Transaction tx = session.beginTransaction();

		Department d1 = new Department();
		d1.setDepartmentId(1);
		d1.setDepartmentName("CSE");
		d1.setStrength(120);
		Department d2 = new Department();
		d2.setDepartmentId(2);
		d2.setDepartmentName("ECE");
		d2.setStrength(120);
		Department d3 = new Department();
		d3.setDepartmentId(3);
		d3.setDepartmentName("MECH");
		d3.setStrength(90);
		Department d4 = new Department();
		d4.setDepartmentId(4);
		d4.setDepartmentName("AERO");
		d4.setStrength(60);
		session.saveOrUpdate(d1);
		session.saveOrUpdate(d2);
		session.saveOrUpdate(d3);
		session.saveOrUpdate(d4);

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
