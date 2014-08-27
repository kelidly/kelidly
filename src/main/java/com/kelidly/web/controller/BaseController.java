package com.kelidly.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import com.kelidly.entity.Article;
import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;
import com.kelidly.service.ArticleService;
import com.kelidly.service.SiteService;

public class BaseController {
	
	@Resource(name = "siteService")
	SiteService siteService;

	@Resource(name = "articleService")
	ArticleService articleService;

	/**
	 * 显示site和article
	 * @param pid 一级栏目的id，查找二级目录使用
	 * @param id 二级栏目id，查找二级栏目文章或者列表
	 * @param pageNo 文章列表页码
	 * @param pageSize 文章列表大小
	 * @param model
	 */
	protected void showSiteAndArticle(long pid,long id,long articleid,int pageNo,int pageSize,Model model) {

		// 一级栏目
		List<Site> psitelist = siteService.findFirstSiteList();
		model.addAttribute("psitelist", psitelist);

		//二级栏目		
		List<Site> sublist = siteService.findSiteListByPid(pid);
		model.addAttribute("sublist", sublist);
		
		// 二级子栏目
		Site psite = siteService.findSiteById(pid);
		model.addAttribute("psite", psite);

		// 栏目内容
		Site site = siteService.findSiteById(id);
		model.addAttribute("site", site);
		// --判断列表类型 内容 或 列表
		if (site != null && site.getState() == 2) {
			// 查找article表得列表
			PageModel pagemodel = articleService.findPageArticleBySiteId(
					pageNo, pageSize, id);
			model.addAttribute("pagemodel", pagemodel);
			
			Article article = articleService.findArticleByid(articleid);
			model.addAttribute("article", article);
			
		}
	}

}
