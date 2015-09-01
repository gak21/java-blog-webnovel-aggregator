package com.webnovelscrossroads.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.URL;





/**
 * Entity implementation class for Entity: Blog
 *
 */
@Getter
@Setter
@Entity
public class Blog {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=1, message="Invalid Url!")
	@URL(message="Invalid Url!")
	private String url;
	
	@Size(min=1, message="password must be at least 1 characters!")
	private String name;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "blog", cascade=CascadeType.REMOVE)
	private List<Item> items;
}
