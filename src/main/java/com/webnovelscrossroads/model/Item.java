package com.webnovelscrossroads.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;



/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(name = "published_date")
	private Date publishedDate;

	private String link;
	
	@ManyToOne
	@JoinColumn(name = "blog_id")
	private Blog blog;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
