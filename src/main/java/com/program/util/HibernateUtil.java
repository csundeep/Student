package com.program.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static Session getNewSession() {

		Configuration cfg = new Configuration();

		// read the hibernate.cfg.xml
		cfg.configure();

		// get the information about session-factory
		SessionFactory factory = cfg.buildSessionFactory();

		return factory.openSession();
	}
}
