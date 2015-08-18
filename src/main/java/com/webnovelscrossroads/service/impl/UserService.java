package com.webnovelscrossroads.service.impl;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.BlogDao;
import com.webnovelscrossroads.dao.ItemDao;
import com.webnovelscrossroads.dao.RoleDao;
import com.webnovelscrossroads.dao.UserDao;
import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.Item;
import com.webnovelscrossroads.model.Role;
import com.webnovelscrossroads.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}
	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogDao.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemDao.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles =new ArrayList<>();
		roles.add(roleDao.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userDao.save(user);
		
	}

	public User findOneWithBlogs(String name) {
		User user = userDao.findByName(name);
		return findOneWithBlogs(user.getId());
	}
}
