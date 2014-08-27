package com.kelidly.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;
import com.kelidly.service.ArticleService;
import com.kelidly.service.NewsService;
import com.kelidly.service.SiteService;

@Controller
@RequestMapping("product")
public class ProductController extends BaseController{

	@Resource(name = "siteService")
	SiteService siteService;

	@Resource(name = "articleService")
	ArticleService articleService;

	@RequestMapping("/index")
	public String index(
			@RequestParam(value = "pid", defaultValue = "1") long pid,
			@RequestParam(value = "id", defaultValue = "1") long id,
			@RequestParam(value = "aid", defaultValue = "1") long articleid,
			@RequestParam(value = "currentPage", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
			Model model) {

		showSiteAndArticle(pid, id,articleid, pageNo, pageSize, model);

		return "front/product/index";
	}

	@RequestMapping("/detail")
	public String detail(
			@RequestParam(value = "pid", defaultValue = "1") long pid,
			@RequestParam(value = "id", defaultValue = "1") long id,
			@RequestParam(value = "aid", defaultValue = "1") long articleid,
			@RequestParam(value = "currentPage", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
			Model model) {
		
		showSiteAndArticle(pid, id,articleid, pageNo, pageSize, model);

		return "front/product/detail";
	}

}


