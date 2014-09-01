package com.kelidly.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;





import com.kelidly.entity.Article;
import com.kelidly.entity.Case;
import com.kelidly.entity.Site;
import com.kelidly.service.ArticleService;
import com.kelidly.service.LinksService;
import com.kelidly.service.SiteService;

@Controller
@RequestMapping("index")
public class IndexController {
	@Resource(name = "linksService")
	LinksService linksService;
	
	@Resource(name="siteService")
	SiteService siteService;
	
	@Resource(name="articleService")
	ArticleService articleService;
	
	@RequestMapping("/login")
	public String login(){
		
		return "/login/login";
	}

	
	@RequestMapping("/index")
	public String index(Model  model){
		
		List linksList = linksService.query(1, 20).getResult();
		model.addAttribute("linksList", linksList);	
		
		//header栏目
		List<Site> psitelist=siteService.findFirstSiteList();
		model.addAttribute("psitelist", psitelist);
		
		//新闻
		long newsid = 2;//新闻咨询在site表的id
		int newslimit =11;//首页显示多少条新闻咨询
		List<Integer> newsidlist = siteService.findIdListByPid(newsid);
		List<Article> newsList = articleService.getArticleByLimit(newsidlist, newslimit);
		model.addAttribute("newsList", newsList);
		
		//常见问题
		long supportid = 9;
		int supportlimit = 5;
		List<Integer> supportidlist = siteService.findIdListByPid(supportid);
		List<Article> supportList = articleService.getArticleByLimit(supportidlist, supportlimit);
		model.addAttribute("supportList", supportList);
		
		//常见问题
		long effectid = 17;
		int effectlimit = 8;
		List<Integer> effectidlist = siteService.findIdListByPid(effectid);
		List<Article> effectList = articleService.getArticleByLimit(effectidlist, effectlimit);
		model.addAttribute("effectList", effectList);
		
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
