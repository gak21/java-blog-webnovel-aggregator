package com.webnovelscrossroads.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;

import com.webnovelscrossroads.annotation.UniqueUsername;

@Getter
@Setter
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message="Name must be at least 3 characters!")
	@Column(unique = true)
	@UniqueUsername
	private String name;
	
	@Size(min=1, message="Invalid email address!")
	@Email(message="Invalid email address!")
	private String email;
	
	@Size(min=5, message="password must be at least 5 characters!")
	private String password;
	
	private Boolean enabled;

	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.REMOVE)
	private List<Blog> Blogs;
}
