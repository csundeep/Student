package com.program.service;

import java.util.List;

import com.program.exception.ServiceException;
import com.program.model.Course;
import com.program.model.Department;
import com.program.model.Student;

public interface StudentService {
	String addStudent(Student student) throws ServiceException;
	List<Course> getCourses();
	List<Department> getDepartments();
	void saveLaptop(String vendor);
}
