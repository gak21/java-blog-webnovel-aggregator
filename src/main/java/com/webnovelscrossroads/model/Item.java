package com.webnovelscrossroads.model;

import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
/**
 * Entity implementation class for Entity: Item
 *
 */
@Getter
@Setter
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

}
