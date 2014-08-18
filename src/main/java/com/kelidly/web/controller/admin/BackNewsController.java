package com.kelidly.web.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kelidly.entity.News;
import com.kelidly.entity.NewsType;
import com.kelidly.model.PageModel;
import com.kelidly.service.NewsService;

@Controller
@RequestMapping("/back/news")
public class BackNewsController {

	@Resource(name = "newsService")
	NewsService newsService;
	
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 管理新闻
	 * @param model
	 * @return
	 */
	@RequestMapping("/manage")
	public String toManage(Model model){
		
		PageModel pagemodel = newsService.query(1,5);		
		model.addAttribute("pagemodel", pagemodel);
		
		List<NewsType> newsTypeList = newsService.queryAllType();
		model.addAttribute("newsTypeList", newsTypeList);
		
		return "/admin/news/news_manage";
	}
	
	@RequestMapping("/pub")
	public String toPublic(Model model){
		
		List<NewsType> list = newsService.queryAllType();
		model.addAttribute("typeList", list);
		return "/admin/news/news_pub";
	}
	/**
	 * 添加新闻
	 * @param bean
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(News bean,Model model){		
		
		String rtMsg = "";
		Boolean flag = newsService.add(bean);
		if (!flag) {
			rtMsg = "添加失败！请查明原因。";
			model.addAttribute("rtMsg", rtMsg);
			return "/admin/news/news_pub";
		} else {
			rtMsg = "添加成功！";
			model.addAttribute("rtMsg", rtMsg);
			return toManage(model);
		}
	    
	}
	@RequestMapping("/updateView")
	public String toUpdate(@RequestParam("newsId")int newsId,Model model){
		
		
		News bean = newsService.queryBean(newsId);
		List typeList = newsService.queryAllType();
		model.addAttribute("typeList", typeList);
		model.addAttribute("bean", bean);
		
		return "/admin/news/news_update";
	}
	@RequestMapping("/toTypeView")
	public String toTypeView(Model model){
		
		List list = newsService.queryAllType();		
		model.addAttribute("beanList", list);
		
		return "/admin/news/type_manage";
	}
	@RequestMapping("/addType")
	
	public String addType(Model model,NewsType typeBean ){
		String rtMsg = "";
		boolean flag = newsService.addType(typeBean);
        if (flag) {
        	rtMsg = "添加失败！请查明原因。";
		}else{
			rtMsg = "添加成功！";			
		}
        model.addAttribute("rtMsg", rtMsg);
        
        List<NewsType> list = newsService.queryAllType();		
		model.addAttribute("beanList", list);
		
		return "/admin/news/type_manage";
	}
	
	@RequestMapping("/delType")
	public String delType(Model model,@RequestParam("typeId")int typeId){
		String rtMsg = "";
		boolean flag = newsService.delType(typeId);
        if (flag) {        	
        	rtMsg = "删除成功！";	
		}else{
			rtMsg = "删除失败！请查明原因。";
		}
        model.addAttribute("rtMsg", rtMsg);
        
        List<NewsType> list = newsService.queryAllType();		
		model.addAttribute("beanList", list);
       
        return "/admin/news/type_manage";
		

	}
	@RequestMapping("/updateType")
	@ResponseBody
	public String updateType(HttpServletResponse response,Model model,NewsType newsType){
	
		String result = "";
		boolean flag = newsService.updateType(newsType);
        if (flag) {
			//toTypeView(model);
			result = "success";
		}
        
        //response.setCharacterEncoding("utf-8");
		return "success";
	}
	@RequestMapping("/update")
	public String update(News bean,Model model){
		
		String rtMsg = "";
		Boolean flag = newsService.update(bean);		
        if (flag) {        	
        	rtMsg = "更新成功！";
        	return toManage(model);
		}else{
			rtMsg = "更新失败！请查明原因。";
		}        
        model.addAttribute("rtMsg", rtMsg);
		
		return "/admin/news/news_update";
	}
	@RequestMapping("/del")
	public String del(Model model,@RequestParam("newsId") int id){
		
		String rtMsg = "";
		Boolean flag = newsService.delete(id);
		 if (flag) {        	
	        	rtMsg = "删除成功！";
	        	return toManage(model);
			}else{
				rtMsg = "删除失败！请查明原因。";
			}        
	        model.addAttribute("rtMsg", rtMsg);
		return "/admin/news/news_manage";
	}
	@RequestMapping("/delMany")
	public String delMany(@RequestParam("checkId")int[] idArr,Model model){

		 Boolean flag = false;
		 flag = newsService.delete(idArr);
		 if(flag){
			 
			 return toManage(model);
		 }
		return "/admin/news/news_manage";
	}
	@RequestMapping("/pageQuery")
	public String toPageManage(@RequestParam(value="currentPage",defaultValue="1") int pageNo,
			@RequestParam(value="pageSize",defaultValue="8") int pageSize,Model model){
	
		
		PageModel pagemodel = newsService.query(pageNo,pageSize);		
		model.addAttribute("pagemodel", pagemodel);
		
		List<NewsType> newsTypeList = newsService.queryAllType();
		model.addAttribute("newsTypeList", newsTypeList);
		
		return "/admin/news/news_manage";
	}
	
	
	
}
