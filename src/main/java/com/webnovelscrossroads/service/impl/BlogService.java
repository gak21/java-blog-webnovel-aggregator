package com.webnovelscrossroads.service.impl;

import java.util.List;

import javax.cache.annotation.CacheRemoveAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@Autowired
	private ItemAsyncTask itemAsyncTask;
	
	// 1 hour = 60s *60min * 1000
	@Scheduled(fixedDelay= 3600000)
	public void reloadBlogs() {
		List<Blog> blogs = blogDao.findAll();
		for (Blog blog : blogs) {
			itemAsyncTask.saveItemsFrom(blog);
		}
	}
	

	public void save(Blog blog, String name) {
		User user = userDao.findByName(name);
		blog.setUser(user);
		blogDao.save(blog);
		itemAsyncTask.saveItemsFrom(blog);
	}
	
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	@CacheRemoveAll(cacheName = "homeItems")
	public void delete(Blog blog) {
		blogDao.delete(blog);	
	}

	public Blog findOne(int id) {
		return blogDao.findOne(id);
	}

}
