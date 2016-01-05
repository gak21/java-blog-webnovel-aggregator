package com.webnovelscrossroads.service.card.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.web.header.writers.frameoptions.StaticAllowFromStrategy;

import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.Item;
import com.webnovelscrossroads.model.User;

@Getter
@Setter
public class BlogCard {

/*
	select max(published_date) from item
	where blog_id =1
	
	select title, link from item
WHERE blog_id =1 and published_date BETWEEN DATE_ADD(CURDATE(), INTERVAL -1 day) AND CURDATE()
order by blog_id DESC, published_date DESC;
	;*/
	private Integer id;
	private String title;
	private String link;
	
	public BlogCard(Integer id, String title, String link) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
	}	
	
	public static String queryFindChapterLinksforBlog(Blog blog){
		return "select id, title, link from item"+ 
				" WHERE blog_id = ? and published_date BETWEEN DATE_ADD(CURDATE(), INTERVAL -1 day) AND CURDATE()"+
				" order by  blog_id DESC, published_date DESC";
				
	}

	@Override
	public String toString() {
		return "BlogCard [id=" + id + ", title=" + title + ", link=" + link
				+ "]";
	}
	

}
