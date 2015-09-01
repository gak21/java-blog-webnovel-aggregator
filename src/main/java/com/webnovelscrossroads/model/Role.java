package com.webnovelscrossroads.model;



import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Getter
@Setter
@Entity
public class Role  {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	@ManyToMany(mappedBy="roles")
	private List<User> users;
}
