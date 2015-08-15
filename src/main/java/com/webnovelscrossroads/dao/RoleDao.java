package com.webnovelscrossroads.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webnovelscrossroads.model.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
