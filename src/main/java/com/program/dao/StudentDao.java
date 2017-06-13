package com.program.dao;

import java.util.List;

import com.program.exception.PersistException;
import com.program.model.Course;
import com.program.model.Department;
import com.program.model.Student;

public interface StudentDao {
	String addStudent(Student student) throws PersistException;
	
	List<Course> getCourses();
	
	List<Department> getDepartments();
	
}
