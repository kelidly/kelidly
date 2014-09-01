package com.kelidly.web.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kelidly.entity.Site;

import com.kelidly.service.LinksService;
import com.kelidly.service.SiteService;

@Controller
@RequestMapping("index")
public class IndexController {
	@Resource(name = "linksService")
	LinksService linksService;
	
	@Resource(name="siteService")
	SiteService siteService;
	
	@RequestMapping("/login")
	public String login(){
		
		return "/login/login";
	}

	
	@RequestMapping("/index")
	public String index(Model  model){
		
		List linksList = linksService.query(1, 20).getResult();
		model.addAttribute("linksList", linksList);	
		
		List<Site> psitelist=siteService.findFirstSiteList();
		model.addAttribute("psitelist", psitelist);
		
		return "/front/index";
	}
	
	@RequestMapping("/load")
	public String load(){
		
		return "/front/load";
	}
	
	@RequestMapping("/interceptor")
	public String interceptor(){
		
		return "interceptor";
	}


	
}
