package com.webnovelscrossroads.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		System.out.println(request.getServletPath());
		
		return "index";
	}
	
	@RequestMapping("/showMessage")
	public String showMessage(){
		return "showMessage";
	}
	
}
