package com.kelidly.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.kelidly.entity.Case;

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
		model.addAttribute("psite", psitelist);
		
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
