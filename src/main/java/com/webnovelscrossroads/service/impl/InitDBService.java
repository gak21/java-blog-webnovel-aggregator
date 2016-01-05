package com.webnovelscrossroads.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.*;
import com.webnovelscrossroads.model.Blog;
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
	void init() {
		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleDao.save(userRole);

		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleDao.save(adminRole);

		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		roles.add(adminRole);
		userAdmin.setRoles(roles);
		userDao.save(userAdmin);

		Blog gravity = new Blog();
		gravity.setName("Gravity");
		gravity.setUrl("http://gravitytales.com/feed/");
		gravity.setUser(userAdmin);
		blogDao.save(gravity);

		Blog scrya = new Blog();
		scrya.setName("Scrya");
		scrya.setUrl("https://scryatranslations.wordpress.com/feed/");
		scrya.setUser(userAdmin);
		blogDao.save(scrya);

		/*
		 * Blog Wuxiaworld = new Blog(); Wuxiaworld.setName("Wuxiaworld");
		 * Wuxiaworld.setUrl("http://www.wuxiaworld.com/feed/");
		 * Wuxiaworld.setUser(userAdmin); blogDao.save(Wuxiaworld);
		 */

		Blog youraikun = new Blog();
		youraikun.setName("yoraikun");
		youraikun.setUrl("https://yoraikun.wordpress.com/feed/");
		youraikun.setUser(userAdmin);
		blogDao.save(youraikun);

		Blog translationNations = new Blog();
		translationNations.setName("Translation Nations");
		translationNations.setUrl("http://www.translationnations.com/feed/");
		translationNations.setUser(userAdmin);
		blogDao.save(translationNations);
	}
}
