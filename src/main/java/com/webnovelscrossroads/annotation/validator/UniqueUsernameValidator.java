package com.webnovelscrossroads.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.webnovelscrossroads.annotation.UniqueUsername;
import com.webnovelscrossroads.dao.UserDao;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	UserDao userDao;
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {	
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		// TODO Delete this null check after InitDBService is @Deprecated
		if(userDao == null)
			return true;
		return userDao.findByName(username) == null;
	}



}
