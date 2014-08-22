package com.kelidly.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelidly.service.LinksService;

@Controller
@RequestMapping("index")
public class IndexController {
	@Resource(name = "linksService")
	LinksService linksService;
	
	@RequestMapping("/login")
	public String login(){
		
		return "/login/login";
	}
/*	@RequestMapping("/admin")
	public String adminIndex(){
		
		return "/admin/index";
	}*/
	
	@RequestMapping("/index")
	public String index(Model  model){
		

		
		List linksList = linksService.query(1, 20).getResult();
		model.addAttribute("linksList", linksList);	
		
		
		

		
		return "/front/index";
	}
	
	@RequestMapping("/interceptor")
	public String interceptor(){
		
		return "interceptor";
	}

	
	
}
