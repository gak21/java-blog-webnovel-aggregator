package com.webnovelscrossroads.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.UserDao;
import com.webnovelscrossroads.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}
}
