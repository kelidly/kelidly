package com.kelidly.web.controller.admin;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelidly.entity.Words;
import com.kelidly.model.PageModel;
import com.kelidly.service.WordsService;



@Controller
@RequestMapping("/back/words")
public class BackWordsController {

	@Resource(name = "wordsService")
	WordsService wordsService;
	
	@RequestMapping("/manage")
	public String toManage(Model model){
		
		PageModel pagemodel =  wordsService.query(1, 5);
		model.addAttribute("pagemodel", pagemodel);
		 return "/admin/words/words_manage";
	}
	@RequestMapping("/del")
	public String del(Model model,@RequestParam("wordsId") int id){
		
		Boolean flag = false;
		flag = wordsService.delete(id);
		if(flag){
			
			return toManage(model);
		}
		return "/admin/words/words_manage";
	}
	
	@RequestMapping("/pub")
	public String toPublic(Model model){
		
		
		return "/admin/words/words_pub";
	}
	@RequestMapping("/update")
	public String update(Words bean,Model model) throws IOException{
	
		
			
		Boolean flag = false;
	
		flag = wordsService.update(bean);
		if(flag){
			
			return toManage(model);
		}
		return "/admin/words/words_manage";
	}

	
	@RequestMapping("/add")
	public String add(Words bean,Model model){
		
		Boolean flag = false;
		flag = wordsService.saveWords(bean);
		if(flag){
			
			return toManage(model);
		}
		return "/admin/words/words_manage";
	}
	
	@RequestMapping("/updateView")
	public String toUpdate(@RequestParam("wordsId")int wordsId,Model model){
		
		
		Words bean = wordsService.queryBean(wordsId);
	
		model.addAttribute("bean", bean);
		
		return "/admin/words/words_update";
	}
	
	@RequestMapping("/pageQuery")
	public String toPageManage(@RequestParam(value="currentPage",defaultValue="1") int pageNo,
			@RequestParam(value="pageSize",defaultValue="8") int pageSize,Model model){
	
		
		PageModel pagemodel = wordsService.query(pageNo,pageSize);
		
		
		model.addAttribute("pagemodel", pagemodel);
		return "/admin/words/words_manage";
	}
	
	
}
