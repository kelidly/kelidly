package com.kelidly.web.controller.admin;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelidly.dao.SiteDao;
import com.kelidly.entity.Site;
import com.kelidly.model.tree.SiteTree;
import com.kelidly.service.AdminService;
import com.kelidly.service.ArticleService;
import com.kelidly.service.SiteService;
import com.kelidly.util.NumberUtils;

@Controller  
@RequestMapping("/site")
public class SiteController {

	@Resource(name="adminService")
	AdminService adminService; 
	
	@Resource(name="articleService")
	ArticleService articleService;
	
	@Resource(name="siteService")
	SiteService siteService;
	
	@Autowired
	private HttpServletRequest request;
	

	@RequestMapping(value="/showSite")
	public String showSite(Model model,@RequestParam("siteid")long id){
		Site site=siteService.findSiteById(id);
		if(site!=null){
			Site psite=siteService.findSiteById(site.getPid());
			model.addAttribute("site", site);
			if(psite==null){
				psite=new Site();
				psite.setName("根目录");
				psite.setPid(0);
			}
			model.addAttribute("psite", psite);
		}		
		//栏目树
		SiteTree siteTree = siteService.findSiteTree();		
		model.addAttribute("tree", siteTree);
		return "/admin/article/site";
	}
	
	@RequestMapping(value="/modifySite")
	public String modifySite(Model model,Site site) {	
		String rtMsg = "";
		try {
			siteService.modifySite(site);
			rtMsg = "修改成功！";
		} catch (Exception e) {
			rtMsg = "修改失败！";
		}
		model.addAttribute("rtMsg", rtMsg);
		
		SiteTree siteTree = siteService.findSiteTree();
		model.addAttribute("tree", siteTree);
		Site psite=siteService.findSiteById(site.getPid());
		if(psite==null){
			psite=new Site();
			psite.setName("根目录");
			psite.setPid(0);
		}
		model.addAttribute("psite", psite);
		return "/admin/article/site";
	}

	@RequestMapping(value="/addSite")
	public String addSite(Site site, Model model,@RequestParam(value="actionType",defaultValue="") String actionType){

		if("add".equals(actionType)){
			
			//检测编码
			boolean haveName = siteService.checkSiteName(site.getName());
			String rtMsg ="";
			if(!haveName){//如果编码已存在
				rtMsg = "栏目名称重复，添加失败";				
			}else{
				siteService.addSite(site);
				rtMsg = "添加栏目成功！";		
			}
			model.addAttribute("rtMsg", rtMsg);			
		}		
		
		SiteTree siteTree = siteService.findSiteTree();
		model.addAttribute("tree", siteTree);
		Site psite=siteService.findSiteById(site.getPid());
		if(psite==null){
			psite=new Site();
			psite.setName("根目录");
			psite.setPid(0);
		}
		model.addAttribute("psite", psite);
		return "/admin/article/addsite";
	}
	
	@RequestMapping(value="/delSite")
	public String delSite( Model model,@RequestParam("siteid")long id){
		String rtMsg ="";
		Site psite=siteService.findSiteById(id);
		if(psite!=null&&psite.getPid()>0){	
			if (siteService.delSite(psite.getId())) {
				rtMsg = "删除栏目成功！";	
			}else{
				rtMsg = "删除栏目失败！";
			}			
		}else{
			rtMsg = "不能删除一级栏目！";	
		}
		model.addAttribute("rtMsg", rtMsg);	
		
		SiteTree siteTree = siteService.findSiteTree();
		request.setAttribute("tree", siteTree);
		return "/admin/article/addsite";
	}
	
}
