package com.kelidly.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kelidly.entity.Article;
import com.kelidly.entity.Words;
import com.kelidly.service.ArticleService;
import com.kelidly.service.NewsService;
import com.kelidly.service.WordsService;

@Controller
@RequestMapping("article")
public class ArticleController {
	@Resource (name="newsService")
	NewsService newsService;
	@Resource (name="articleService")
	ArticleService articleService;	
	@Resource (name="wordsService")
	WordsService wordsService;
	/**
	 * 关于汇兴
	 * @param model
	 * @return
	 */
	@RequestMapping("/about")
	public String aboutDetail(@RequestParam(value="id",defaultValue="1")int id,Model model){
		
		//查询左右文章，
		List<Article> articleList = articleService.findArticleByType(1);
		model.addAttribute("articleList", articleList);
		//根据id查文章
		Article article = articleService.findArticleByid(id);
		model.addAttribute("article", article);
		
		return "/front/about/detail";
	}
	/**
	 * 产品介绍
	 * @param model
	 * @return
	 */
	@RequestMapping("/product")
	public String productDetail(@RequestParam(value="id",defaultValue="1")int id,Model model){
		
		//查询左右文章，所有product文章
		List<Article> articleList = articleService.findArticleByType(2);
		model.addAttribute("articleList", articleList);
		//根据id查文章
		Article article = articleService.findArticleByid(id);
		model.addAttribute("article", article);
		
		return "/front/product/detail";
	}
	/**
	 * 联系我们
	 * @param model
	 * @return
	 */
	@RequestMapping("/contact")
	public String contactDetail(@RequestParam(value="id",defaultValue="1")int id,Model model){
		
		//查询左右文章，
		List<Article> articleList = articleService.findArticleByType(3);
		model.addAttribute("articleList", articleList);
		//根据id查文章
		Article article = articleService.findArticleByid(id);
		model.addAttribute("article", article);
		
		return "/front/contact/detail";
	}
	
	
	@RequestMapping("/feedback")
	public String toFeedBackView(Model model){		
		
		return "/front/contact/feedback";
	}
	
	@RequestMapping("/cooperative")
	public String toCooperativeView(Model model) {
	
		return "/front/contact/cooperative";
	}
	
	
	@RequestMapping("/emap")
	public String eMap(Model model){
		
		return "/front/contact/emap";
	}
	
	@RequestMapping("/words")	
	public String toWords(Model model,Words bean){		
		
		Boolean flag = wordsService.saveWords(bean);
        String rtMsg = "";
        if (flag) {
        	rtMsg="留言成功！感谢您的留言。";
		}else {
			rtMsg="留言失败，很抱歉给您带来不便。我们将核实留言失败的原因，您可以通过其他方式联系我们。";
		}
        model.addAttribute("rtMsg", rtMsg);
		return "/front/contact/feedback";
	}
	
	@RequestMapping("/feedback/verify")
	@ResponseBody
	public String toFeedBackVerify(HttpServletResponse res,HttpServletRequest request,Model model){
		
		String num=request.getParameter("num");
		String random=(String)request.getSession().getAttribute("random");
		String name=request.getParameter("name");
		return "success";
	}

	
	
}
