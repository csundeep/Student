package com.program.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table
public class Course {
	@Id
	@Column(name = "course_id")
	private int courseId;
	@Column(name = "course_name")
	private String courseName;
	@ManyToMany
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinTable(name = "Student_course", inverseJoinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "student_id") }, joinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "course_id") })
	private Set<Student> students = new HashSet<Student>(0);

	public Course() {

	}

	public Course(String courseId) {

		this.courseId = Integer.parseInt(courseId);

	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {

		return courseName;
	}

	public void setCourseName(String courseName) {

		this.courseName = courseName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName
				+ "]";
	}

}
