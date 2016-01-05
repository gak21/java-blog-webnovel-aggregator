package com.webnovelscrossroads.service.impl;

import java.util.List;
import java.util.stream.Stream;

import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.webnovelscrossroads.dao.ItemDao;
import com.webnovelscrossroads.model.Item;

@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CacheResult(cacheName = "homeItems")
	public List<Item> getItems(@CacheKey int page) {
		return itemDao.findAll(
				new PageRequest(page, 20, Direction.DESC, "publishedDate"))
				.getContent();
	}

	/**
	 * TEST metod for ajax. Better solution is to pass jakson and let jquery
	 * create tags
	 * 
	 * @param items
	 * @return
	 */
	public String getHtmlTableItems(List<Item> items) {
		StringBuilder result = new StringBuilder(8000);
		for (Item item : items) {
			result.append("<tr><td>")
					.append(item.getPublishedDate())
					.append("<em>")
					.append(item.getBlog().getName())
					.append("</em></td><td><strong> <a rel=\"nofollow\" href=\"")
					.append(item.getLink()).append("\" target=\"_blank\">")
					.append(item.getTitle()).append("</a></strong></td></tr>");
		}
		return result.toString();
	}

	public String getCardsItems(){
		
		jdbcTemplate.query(
                "select i.title  from item as i limit 5",
                (rs, rowNum) -> new UserWrapper( rs.getString("title"))
        ).forEach(System.out::println);
		
		
		return "test passed";
	}
}
