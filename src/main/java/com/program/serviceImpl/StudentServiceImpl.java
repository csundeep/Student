package com.program.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.program.dao.StudentDao;
import com.program.exception.PersistException;
import com.program.exception.ServiceException;
import com.program.model.Course;
import com.program.model.Department;
import com.program.model.Student;
import com.program.service.StudentService;

@Service
@Component
public class StudentServiceImpl implements StudentService {
	StudentDao studentDao;

	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
	public String addStudent(Student student) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return studentDao.addStudent(student);
		} catch (PersistException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return studentDao.getCourses();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return studentDao.getDepartments();
	}

	@Override
	@Transactional
	public void saveLaptop(String vendor) {
		// TODO Auto-generated method stub

	}

}
