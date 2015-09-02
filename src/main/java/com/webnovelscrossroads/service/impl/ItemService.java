package com.webnovelscrossroads.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.ItemDao;
import com.webnovelscrossroads.model.Item;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getItems() {
		return itemDao.findAll(new PageRequest(0, 20, Direction.DESC, "publishedDate")).getContent();
	}

}
