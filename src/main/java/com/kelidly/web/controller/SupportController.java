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
@RequestMapping("support")
public class SupportController extends BaseController{

	@Resource (name="newsService")
	NewsService newsService;

	@RequestMapping("/index")
	public String index(
			@RequestParam(value = "pid", defaultValue = "1") long pid,
			@RequestParam(value = "id", defaultValue = "1") long id,
			@RequestParam(value = "aid", defaultValue = "1") long articleid,
			@RequestParam(value = "currentPage", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
			Model model) {

		showSiteAndArticle(pid, id,articleid, pageNo, pageSize, model);

		return "front/support/index";
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

		return "front/support/detail";
	}
	
//	@RequestMapping("/index")
//	public String toIndex(@RequestParam(value="typeId",defaultValue="1") int typeId,Model model){
//		
//		
//		return "/front/support/index";
//	}
//	@RequestMapping("/service")
//	public String toService(Model model){
//		
//		
//		return "/front/support/service";
//	}
//	@RequestMapping("/download")
//	public String toDownload(Model model){
//		
//		
//		return "/front/support/download";
//	}
//	@RequestMapping("/FAQ")
//	public String toFAQ(Model model){
//		
//
//		return "/front/support/FAQ";
//	}
//	@RequestMapping("/index1")
//	public String toIndex(@RequestParam(value="currentPage",defaultValue="1") int pageNo,
//			@RequestParam(value="pageSize",defaultValue="2") int pageSize,
//			@RequestParam(value="typeId",defaultValue="1") int typeId,Model model){
//		
//		List newsList = newsService.queryByType(typeId);
//	    List typeList = newsService.queryAllType();
//	    List recentList = newsService.queryRecentNews();
//	    
//        PageModel pagemodel = newsService.query(pageNo,pageSize,typeId);
//        if (newsList != null && newsList.size()!=0) {
//			
//        	News newsBean = (News)newsList.get(0);
//        	NewsType newsType = newsService.findNewstypeByid(newsBean.getTypeId());
//        	model.addAttribute("newsType",newsType);
//		}
//		
//		model.addAttribute("pagemodel", pagemodel);
//
//	    model.addAttribute("typeList", typeList);
//		model.addAttribute("newsList", newsList);		
//		model.addAttribute("recentList", recentList);
//		return "/front/news/news";
//	}
//	@RequestMapping("/detail")
//	public String toDetailView(@RequestParam(value="id",defaultValue="1") int newsId,
//			@RequestParam(value="typeId",defaultValue="1") int typeId,Model model){
//		
//		//List newsList = newsService.queryByType(newsId);
//	    List typeList = newsService.queryAllType();
//	    List recentList = newsService.queryRecentNews();
//	    News newsBean = newsService.queryForBeanById(newsId);
//        List updownList = newsService.queryForUpDownById(newsId);
//
//	    model.addAttribute("typeList", typeList);
//		model.addAttribute("newsBean", newsBean);
//		model.addAttribute("recentList", recentList);
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
