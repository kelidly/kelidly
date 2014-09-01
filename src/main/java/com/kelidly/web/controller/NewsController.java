package com.kelidly.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelidly.service.NewsService;

@Controller
@RequestMapping("news")
public class NewsController extends BaseController {

	@Resource (name="newsService")
	NewsService newsService;

	@RequestMapping("/index")
	public String index(
			@RequestParam(value = "pid", defaultValue = "1") long pid,
			@RequestParam(value = "id", defaultValue = "1") long id,
			@RequestParam(value = "aid", defaultValue = "1") long articleid,
			@RequestParam(value = "currentPage", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
			Model model) {

		showSiteAndArticle(pid, id,articleid, pageNo, pageSize, model);

		return "front/news/index";
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

		return "front/news/detail";
	}
	
	
//	@RequestMapping("/index")
//	public String toIndex(@RequestParam(value="currentPage",defaultValue="1") int pageNo,
//			@RequestParam(value="pageSize",defaultValue="40") int pageSize,
//			@RequestParam(value="typeId",defaultValue="1") int typeId,Model model){
//		
//        NewsType newsType = newsService.findNewstypeByid(typeId);
//    	//新闻类型
//    	model.addAttribute("newsType",newsType);
//        
//        //分页新闻列表
//        PageModel pagemodel = newsService.query(pageNo,pageSize,typeId);
//		model.addAttribute("pagemodel", pagemodel);
//		
//		//新闻类型列表
//		List<NewsType> typeList = newsService.queryAllType();
//	    model.addAttribute("typeList", typeList);       
//	    
////	    //最新咨询
////	    List recentList = newsService.queryRecentNews();
////		model.addAttribute("recentList", recentList);
////		List newsList = newsService.queryByType(typeId);       
////      //某类型新闻列表
////      model.addAttribute("newsList", newsList);	
//		
//		return "/front/news/news";
//	}
//	
//	@RequestMapping("/detail")
//	public String toDetailView(@RequestParam(value="id",defaultValue="1") int newsId,
//			@RequestParam(value="typeId",defaultValue="1") int typeId,Model model){
//		
//	    List<NewsType> typeList = newsService.queryAllType();
//	    model.addAttribute("typeList", typeList);
//	    
//	    News newsBean = newsService.queryForBeanById(newsId);
//	    model.addAttribute("newsBean", newsBean);
//	    
//	    
//		//最新咨询
////		List<News> recentList = newsService.queryRecentNews();
////		model.addAttribute("recentList", recentList);
//	    
//		return "/front/news/news_detail";
//	}
//	@RequestMapping("/proof")
//	public String toProofView(Model model){
//		
//		List newsList = newsService.queryRecentNews();
//		
//		model.addAttribute("newsList", newsList);
//		return "/front/about/proof";
//	}
	
	
	
	
}
