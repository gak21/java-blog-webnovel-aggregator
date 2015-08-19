package com.webnovelscrossroads.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.BlogDao;
import com.webnovelscrossroads.dao.UserDao;
import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.User;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userDao;
	
	public void save(Blog blog, String name) {
		User user = userDao.findByName(name);
		blog.setUser(user);
		blogDao.save(blog);
		
	}

}
