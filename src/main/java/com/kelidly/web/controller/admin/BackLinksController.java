package com.kelidly.web.controller.admin;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelidly.entity.Links;
import com.kelidly.model.PageModel;
import com.kelidly.service.LinksService;



@Controller
@RequestMapping("/back/links")
public class BackLinksController {

	@Resource(name = "linksService")
	LinksService linksService;
	
	@RequestMapping("/manage")
	public String toManage(Model model){
		// TODO Auto-generated method stub
		PageModel pagemodel =  linksService.query(1, 5);
		model.addAttribute("pagemodel", pagemodel);
		 return "/admin/links/links_manage";
	}
	@RequestMapping("/del")
	public String del(Model model,@RequestParam("linksId") int id){
		
		Boolean flag = false;
		flag = linksService.delete(id);
		
		String rtMsg = "";
		if (flag) {
			rtMsg = "删除成功！";
		} else {
			rtMsg = "删除失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);
		
		return toManage(model);
		
	}
	
	@RequestMapping("/pub")
	public String toPublic(Model model){
		
		
		return "/admin/links/links_pub";
	}
	@RequestMapping("/update")
	public String update(Links bean,Model model) throws IOException{
	
		
			
		Boolean flag = false;
	
		flag = linksService.update(bean);
		String rtMsg = "";		
		if (flag) {
			rtMsg = "修改成功！";
		} else {
			rtMsg = "修改失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);	
		
		return toManage(model);
	}

	
	@RequestMapping("/add")
	public String add(Links bean,Model model){
		
		Boolean flag = false;
		flag = linksService.add(bean);
		String rtMsg = "";		
		if (flag) {
			rtMsg = "修改成功！";
		} else {
			rtMsg = "修改失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);		
			
		return toManage(model);
		
	}
	
	@RequestMapping("/updateView")
	public String toUpdate(@RequestParam("linksId")int linksId,Model model){
		
		
		Links bean = linksService.queryBean(linksId);
	
		model.addAttribute("bean", bean);
		
		return "/admin/links/links_update";
	}
	
	@RequestMapping("/delMany")
	public String delMany(@RequestParam("checkId")int[] idArr,Model model){

		 Boolean flag = false;
		 flag = linksService.delete(idArr);
		 if(flag){
			 
			 return toManage(model);
		 }
		return "/admin/links/links_manage";
	}
	
	@RequestMapping("/pageQuery")
	public String toPageManage(@RequestParam(value="currentPage",defaultValue="1") int pageNo,
			@RequestParam(value="pageSize",defaultValue="8") int pageSize,Model model){
	
		
		PageModel pagemodel = linksService.query(pageNo,pageSize);
		
		
		model.addAttribute("pagemodel", pagemodel);
		return "/admin/links/links_manage";
	}
	
	
}
