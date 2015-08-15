package com.webnovelscrossroads.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webnovelscrossroads.model.Blog;

public interface BlogDao extends JpaRepository<Blog, Integer> {

}
