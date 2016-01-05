package com.webnovelscrossroads.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webnovelscrossroads.model.User;
import com.webnovelscrossroads.service.card.model.BlogCard;
import com.webnovelscrossroads.service.card.model.CardCollection;
import com.webnovelscrossroads.service.impl.BlogService;
import com.webnovelscrossroads.service.impl.ItemService;
import com.webnovelscrossroads.service.impl.UserWrapper;

/**
 * Different view from index page
 * Created for experiment html5/css3/ajax/jquery
 * @author Michał
 *
 */
@Controller
public class Home2Controller {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/home2")
	public String visitHome2(Model model){
		model.addAttribute("items", itemService.getItems(0));
		return "home2";
	}
	
	@RequestMapping(value="/testjson", headers = {"Accept=text/xml, application/json"}, produces= MediaType.APPLICATION_JSON_VALUE )
	CardCollection sendTo(){
		User user = new User();
		user.setName("testUser");
		user.setPassword("pass234");
		user.setEmail("Lol@eBig.com");
		
		Map<String,List<BlogCard>> cards = blogService.getBlogCard();
		CardCollection collection = new CardCollection(cards);
		
		User user2 = new User();
		user2.setName("testUser2");
		user2.setPassword("pass333");
		user2.setEmail("Lol3@eBig.com");
		
		List<User> users2 = new LinkedList<>();
		users2.add(user);
		users2.add(user2);
		
		UserWrapper users = new UserWrapper();
		users.add(user);
		users.add(user2);
		
		String message=itemService.getCardsItems();
		System.out.println(message);
		
		//return users;
		return collection;
	}
	
}
