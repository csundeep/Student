package com.program.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// Student student = (Student) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "studentId", "studentId.mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "firstName", "firstName.mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "lastName", "lastName.mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "dateOfBirth", "dateOfBirth.mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "gender", "gender.mandatory");

	}

}
