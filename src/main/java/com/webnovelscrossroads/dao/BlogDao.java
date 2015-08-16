package com.webnovelscrossroads.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.User;

public interface BlogDao extends JpaRepository<Blog, Integer> {
	
	List<Blog> findByUser(User user);	
}
