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
import com.kelidly.service.WordsService;

@Controller
@RequestMapping("article")
public class ArticleController {
	@Resource (name="articleService")
	ArticleService articleService;	
	@Resource (name="wordsService")
	WordsService wordsService;
	
	
	
	

	
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
