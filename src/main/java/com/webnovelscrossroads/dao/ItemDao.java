package com.webnovelscrossroads.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webnovelscrossroads.model.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {

}
