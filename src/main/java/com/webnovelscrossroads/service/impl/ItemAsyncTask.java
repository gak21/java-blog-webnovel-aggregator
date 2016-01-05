package com.webnovelscrossroads.service.impl;

import java.util.List;

import javax.cache.annotation.CacheRemoveAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.ItemDao;
import com.webnovelscrossroads.exception.RssException;
import com.webnovelscrossroads.model.Blog;
import com.webnovelscrossroads.model.Item;

/**
 * Service get items from single blog (from RSS link) and save them in DB
 * @author Michał
 *
 */
@Service
public class ItemAsyncTask {
	
	@Autowired
	private RssService rssService;
	
	@Autowired
	private ItemDao itemDao;
	
	@Async
	@CacheRemoveAll(cacheName = "homeItems")
	public void saveItemsFrom(Blog blog){
		try {
			List<Item> items = rssService.getItems(blog.getUrl());
			for (Item item : items) {
				Item saveItem = itemDao.findByBlogAndLink(blog, item.getLink());
				if (saveItem == null) {
					item.setBlog(blog);
					itemDao.save(item);			
				}
			}
		} catch (RssException e) {
			e.printStackTrace();
		}		
	}
	/**
	 * Method Recommended for  post metodin Controller.
	 * it will load added items to the view, before sending response.
	 * @param blog
	 */
	@CacheRemoveAll(cacheName = "homeItems")
	public void saveItemsFromAsyncOff(Blog blog){
		try {
			List<Item> items = rssService.getItems(blog.getUrl());
			for (Item item : items) {
				Item saveItem = itemDao.findByBlogAndLink(blog, item.getLink());
				if (saveItem == null) {
					item.setBlog(blog);
					itemDao.save(item);			
				}
			}
		} catch (RssException e) {
			e.printStackTrace();
		}		
	}
}
