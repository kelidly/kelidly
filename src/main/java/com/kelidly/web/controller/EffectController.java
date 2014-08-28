package com.kelidly.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelidly.entity.Article;
import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;

@Controller
@RequestMapping("effect")
public class EffectController extends BaseController {

	@RequestMapping("/index")
	public String index(
			@RequestParam(value = "pid", defaultValue = "1") long pid,
			@RequestParam(value = "id", defaultValue = "1") long id,
			@RequestParam(value = "aid", defaultValue = "1") long articleid,
			@RequestParam(value = "currentPage", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
			Model model) {

		// 一级栏目
		List<Site> psitelist = siteService.findFirstSiteList();
		model.addAttribute("psitelist", psitelist);

		// 二级栏目
		List<Site> sublist = siteService.findSiteListByPid(pid);
		model.addAttribute("sublist", sublist);

		// 二级子栏目
		Site psite = siteService.findSiteById(pid);
		model.addAttribute("psite", psite);

		// 栏目内容
		Site site = siteService.findSiteById(id);
		model.addAttribute("site", site);

		List<PageModel> pageModelList = new ArrayList<PageModel>();
				for (Site s : sublist) {			
					
					PageModel pagemodel = articleService.findPageArticleBySiteId(pageNo, pageSize, s.getId());
					pageModelList.add(pagemodel);
					
				}
		model.addAttribute("pageModelList", pageModelList);		
		

		return "front/effect/index";
	}

}
