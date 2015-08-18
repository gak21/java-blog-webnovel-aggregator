package com.webnovelscrossroads.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webnovelscrossroads.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByName(String Name);

}
