package com.webnovelscrossroads.service.card.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.webnovelscrossroads.model.User;

public class CardCollection extends HashMap<String,List<BlogCard>> {

	public CardCollection(Map<String, List<BlogCard>> cards) {
		super(cards);
	}

}
