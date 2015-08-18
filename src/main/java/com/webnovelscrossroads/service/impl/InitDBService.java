package com.webnovelscrossroads.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.*;
import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.Item;
import com.webnovelscrossroads.model.Role;
import com.webnovelscrossroads.model.User;

@Service
@Transactional
public class InitDBService {
	@Autowired
	BlogDao blogDao;
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	UserDao userDao;
	
	@PostConstruct
	void init(){
		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleDao.save(userRole);
		
		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleDao.save(adminRole);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setPassword("admin");
		List<Role> roles =new ArrayList<>();
		roles.add(userRole);
		roles.add(adminRole);
		userAdmin.setRoles(roles);	
		userDao.save(userAdmin);
		
		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavavids.setUser(userAdmin);
		blogDao.save(blogJavavids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("first");
		item1.setLink("htttp://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemDao.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("second");
		item2.setLink("htttp://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemDao.save(item2);
	}
}
