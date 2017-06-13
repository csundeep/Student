package com.program.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.program.dao.StudentDao;
import com.program.exception.PersistException;
import com.program.model.Course;
import com.program.model.Department;
import com.program.model.Student;

@Repository
@Component
public class StudentDaoHibernateImpl implements StudentDao {
	HibernateTemplate template;

	@Autowired
	public StudentDaoHibernateImpl(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public String addStudent(Student student) throws PersistException {
		try {
			template.save(student);
			return student.getStudentId();
		} catch (DataAccessException e) {
			throw new PersistException(e.getMessage(), e);
			// e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCourses() {

		return (List<Course>) template.find("from Course");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return (List<Department>) template.find("from Department");
	}

}
