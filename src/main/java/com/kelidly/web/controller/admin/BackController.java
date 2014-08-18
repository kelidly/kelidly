package com.kelidly.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back")
public class BackController {
	
	
	
	@RequestMapping("/index")
	public String index(){
		
		return "/admin/index";
	}
	
	@RequestMapping("/interceptor")
	public String interceptor(){
		
		return "interceptor";
	}
	
	
}
