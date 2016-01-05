package com.webnovelscrossroads.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.cache.annotation.CacheRemoveAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.BlogDao;
import com.webnovelscrossroads.dao.UserDao;
import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.User;
import com.webnovelscrossroads.service.card.model.BlogCard;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
		itemAsyncTask.saveItemsFromAsyncOff(blog);
	}
	
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	@CacheRemoveAll(cacheName = "homeItems")
	public void delete(Blog blog) {
		blogDao.delete(blog);	
	}

	public Blog findOne(int id) {
		return blogDao.findOne(id);
	}


	public Map<String,List<BlogCard>> getBlogCard() {
		
			Map<String,List<BlogCard>> cards = new HashMap<>();
			
			List<Blog> blogs = blogDao.findAll();
			blogs.forEach(blog -> {
				List<BlogCard> pom = new ArrayList<>();
				jdbcTemplate.query(BlogCard.queryFindChapterLinksforBlog(blog),new Object[] {blog.getId()},
				 (rs, rowNum) -> new BlogCard(rs.getInt("id"), rs.getString("title"), rs.getString("link")))
				 .forEach( bCard -> pom.add(bCard));
				cards.put(blog.getId().toString(), pom);
			} );
			
			//check if works
			for (Blog blog : blogs) {
				for (BlogCard card : cards.get(blog.getId().toString())) {
					System.out.println(card);
				}
			}
			
		return cards;
	}
	
	

}
