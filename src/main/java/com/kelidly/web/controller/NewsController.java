package com.kelidly.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelidly.entity.News;
import com.kelidly.entity.NewsType;
import com.kelidly.model.PageModel;
import com.kelidly.service.NewsService;

@Controller
@RequestMapping("news")
public class NewsController {

	@Resource (name="newsService")
	NewsService newsService;


	
	@RequestMapping("/index")
	public String toIndex(@RequestParam(value="currentPage",defaultValue="1") int pageNo,
			@RequestParam(value="pageSize",defaultValue="40") int pageSize,
			@RequestParam(value="typeId",defaultValue="1") int typeId,Model model){
		
		List newsList = newsService.queryByType(typeId);       
        if (newsList != null && newsList.size()!=0) {			
        	News newsBean = (News)newsList.get(0);
        	NewsType newsType = newsService.findNewstypeByid(newsBean.getTypeId());
        	//新闻类型
        	model.addAttribute("newsType",newsType);
		}
        //某类型新闻列表（未用）
        model.addAttribute("newsList", newsList);	
        
        //分页新闻列表
        PageModel pagemodel = newsService.query(pageNo,pageSize,typeId);
		model.addAttribute("pagemodel", pagemodel);
		
		//新闻类型列表
		List<NewsType> typeList = newsService.queryAllType();
	    model.addAttribute("typeList", typeList);
	    
	    //最新咨询
	    List recentList = newsService.queryRecentNews();
		model.addAttribute("recentList", recentList);
		return "/front/news/news";
	}
	
	@RequestMapping("/detail")
	public String toDetailView(@RequestParam(value="id",defaultValue="1") int newsId,
			@RequestParam(value="typeId",defaultValue="1") int typeId,Model model){
		
		//List newsList = newsService.queryByType(newsId);
	    List<NewsType> typeList = newsService.queryAllType();
	    model.addAttribute("typeList", typeList);
	    
	    News newsBean = newsService.queryForBeanById(newsId);
	    model.addAttribute("newsBean", newsBean);
	    
        //List updownList = newsService.queryForUpDownById(newsId);
	    
		//最新咨询
		List<News> recentList = newsService.queryRecentNews();
		model.addAttribute("recentList", recentList);
		return "/front/news/news_detail";
	}
	@RequestMapping("/proof")
	public String toProofView(Model model){
		
		List newsList = newsService.queryRecentNews();
		
		model.addAttribute("newsList", newsList);
		return "/front/about/proof";
	}
	
	
	
	
}
