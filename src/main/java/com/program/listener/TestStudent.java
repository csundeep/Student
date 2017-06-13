package com.program.listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.program.model.Course;
import com.program.model.Department;
import com.program.model.Student;
import com.program.util.HibernateUtil;

public class TestStudent {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Set<Course> courses = new HashSet<Course>();
		
		Course c1 = new Course();
		c1.setCourseId(1);
		c1.setCourseName("Java");
		courses.add(c1);
		
		Course c2 = new Course();
		c2.setCourseId(2);
		c2.setCourseName(".Net");
		courses.add(c2);
		
		Course c3 = new Course();
		c3.setCourseId(3);
		c3.setCourseName("PHP");
		courses.add(c3);
		
		Department department1 = new Department();
		department1.setDepartmentId(1);
		department1.setDepartmentName("CSE");
		
		Department department2 = new Department();
		department2.setDepartmentId(2);
		department2.setDepartmentName("ECE");
		
		// Laptop laptop = new Laptop("AA125345", "HP ENVY M5", "INTEL CORE I7",
		// "8 GB", "1 TB", "2 GB INVIDEA", true);
		
		Session session = HibernateUtil.getNewSession();
		Transaction tx = session.beginTransaction();
		// session.saveOrUpdate(new Student("M1023131", "sandy", "chowdary", sdf
		// .parse("25-08-1991"), "M", courses));
		//
		// session.saveOrUpdate(new Student("M1023132", "Kiran", "Kunchala", sdf
		// .parse("13-11-1989"), "M", courses));
		
		session.save(new Student("M1023131", "sandy", "chowdary", sdf.parse("25-08-1991"), "M", courses, department1));
		session.saveOrUpdate(new Student("M1023132", "Kiran", "Kunchala", sdf.parse("13-11-1989"), "M", courses, department2));
		
		tx.commit();
		session.close();
		
	}
}
