package com.webnovelscrossroads.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webnovelscrossroads.service.impl.ItemService;


@Controller
public class HomeController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/index")
	public String visitHome(Model model){
		model.addAttribute("items", itemService.getItems(0));
		return "index";
	}
	
	@RequestMapping("/indextest" )
	public @ResponseBody
	String getTime(@RequestParam int page){	
	    return itemService.getHtmlTableItems(itemService.getItems(page));
	}
}
