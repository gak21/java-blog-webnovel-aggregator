package com.webnovelscrossroads.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/index")
	public String Home(Model model){
		model.addAttribute("items", itemService.getItems());
		return "index";
	}
}
