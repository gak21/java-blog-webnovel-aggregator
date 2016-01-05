package com.webnovelscrossroads.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class ItemNoticeBoard {
	private String blogName;
	private Map<String, String> Chapterlinks = new HashMap<>();
	public ItemNoticeBoard(String blogName, Map<String, String> chapterlinks) {
		this.blogName = blogName;
		this.Chapterlinks = chapterlinks;
	}
/*
	select b.name, i.title, i.link from item as i
	left join blog as b on i.blog_id = b.id
	where b.name like "Scrya"
	order by published_date DESC 
	limit 5;
	*/
}
