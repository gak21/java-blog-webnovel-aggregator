package com.webnovelscrossroads.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.BlogDao;
import com.webnovelscrossroads.dao.ItemDao;
import com.webnovelscrossroads.dao.UserDao;
import com.webnovelscrossroads.exception.RssException;
import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.Item;
import com.webnovelscrossroads.model.User;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RssService rssService;
	
	@Autowired
	private ItemDao itemDao;
	
	public void saveItems(Blog blog){
		try {
			List<Item> items = rssService.getItems(blog.getUrl());
			for (Item item : items) {
				Item saveItem = itemDao.findByBlogAndLink(blog, item.getLink());
				if (saveItem == null) {
					item.setBlog(blog);
					itemDao.save(item);
					
				}
			}
		} catch (RssException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void save(Blog blog, String name) {
		User user = userDao.findByName(name);
		blog.setUser(user);
		blogDao.save(blog);
		saveItems(blog);
	}
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(Blog blog) {
		blogDao.delete(blog);
		
	}

	public Blog findOne(int id) {
		return blogDao.findOne(id);
	}

}
