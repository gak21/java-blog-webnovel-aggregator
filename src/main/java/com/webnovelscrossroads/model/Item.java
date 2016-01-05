package com.webnovelscrossroads.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 * Entity implementation class for Entity: Item
 *
 */

@Entity
@Table(indexes = {@Index(name="fk_blogid_date_index", columnList = "blog_id, published_date")})
@Getter
@Setter
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
	


}
