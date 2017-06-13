package com.program.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.program.exception.ServiceException;
import com.program.model.Course;
import com.program.model.Department;
import com.program.model.Student;
import com.program.service.StudentService;
import com.program.validation.StudentValidator;

@Controller
public class StudentController {
	StudentService studentService;
	private static Logger log = Logger.getLogger(StudentController.class);
	private Map<String, Course> courseCache;

	private Map<String, Department> departmentCache;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {

		binder.registerCustomEditor(Set.class, "courses", new CustomCollectionEditor(Set.class) {
			protected Object convertElement(Object element) {
				if (element instanceof Course) {
					return element;
				}
				if (element instanceof String) {
					return courseCache.get(element);
				}

				return null;
			}
		});

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));

	}

	@RequestMapping(value = "/addStudent.student")
	public ModelAndView addStudent() {

		ModelAndView modelAndView = new ModelAndView();
		log.info("In addSudent Controller");
		courseCache = new HashMap<String, Course>();
		for (Course course : studentService.getCourses()) {
			courseCache.put(new Integer(course.getCourseId()).toString(), course);
		}

		departmentCache = new HashMap<String, Department>();
		for (Department department : studentService.getDepartments()) {

			departmentCache.put(new Integer(department.getDepartmentId()).toString(), department);
		}

		modelAndView.addObject("student", new Student());
		modelAndView.addObject("courses", studentService.getCourses());

		modelAndView.addObject("departments", studentService.getDepartments());

		modelAndView.setViewName("addStudent");
		return modelAndView;
	}

	@RequestMapping(value = "/addStudent.student", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute Student student, BindingResult errors) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();

		new StudentValidator().validate(student, errors);
		if (errors.hasErrors()) {
			log.debug("Exception occured while submiting student form" + errors);
			System.out.println(errors);
			modelAndView.addObject("student", new Student());
			modelAndView.addObject("courses", studentService.getCourses());
			modelAndView.addObject("departments", studentService.getDepartments());

			modelAndView.setViewName("addStudent");
		} else {
			try {
				modelAndView.addObject("message",
						"student with id " + studentService.addStudent(student) + " added successfully");
			} catch (ServiceException e) {
				modelAndView.addObject("message", "could not add Student with id " + student.getStudentId());

			}
			modelAndView.setViewName("forward:index.jsp");
		}

		return modelAndView;
	}
}
