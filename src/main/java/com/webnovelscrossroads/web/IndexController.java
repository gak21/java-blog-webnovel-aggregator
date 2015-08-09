package com.webnovelscrossroads.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		System.out.println(request.getServletPath());
		
		return "index";
	}
	
}
