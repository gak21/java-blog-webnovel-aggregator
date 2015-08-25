package com.webnovelscrossroads.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.Item;
import java.lang.Integer;

public interface ItemDao extends JpaRepository<Item, Integer> {

	List<Item> findByBlog(Blog blog, Pageable pageable);
	
	Item findByBlogAndLink(Blog blog, String link);
}
