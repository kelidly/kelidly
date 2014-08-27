package com.kelidly.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelidly.commons.conf.CommonConstant;
import com.kelidly.constants.Constants;
import com.kelidly.dao.SiteDao;
import com.kelidly.entity.Site;
import com.kelidly.model.tree.SiteTree;
import com.kelidly.service.AdminService;
import com.kelidly.service.SiteService;
import com.kelidly.util.JsonUtil;

@Controller  
@RequestMapping("/admin")
public class AdminController {

	@Resource(name="adminService")
	AdminService adminService; 
	@Resource(name="siteDao")
	SiteDao siteDao;
	@Resource(name="siteService")
	SiteService siteService;

	@RequestMapping(value="/add")
	public String addUser() throws IOException{
	
		return null;	
		
	}
	
	@RequestMapping("/login")
	public String login(){
		
		return "/admin/login";
	}
	
	@RequestMapping("/loginout")
	public String loginout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstant.AUTH_USER, null);
		
		return "/admin/login";
	}
	

	@RequestMapping(value="/index" )
	public String loginUser(@RequestParam("adminName")String AdminName,@RequestParam("pwd")String pwd,
			@RequestParam("type")String type,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		
		boolean flag = adminService.loginAdmin(AdminName,pwd);
		
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute(CommonConstant.AUTH_USER, AdminName);
			
			//栏目树
			SiteTree siteTree = siteService.getSiteTree();		
			session.setAttribute("tree", siteTree);
			
			return "/admin/index";
		}else {
			String str = "您输入的密码和账户名不匹配，请重新输入!";
			request.setAttribute("rtMsg", str);
			return "/admin/login";
		}
		
	}


	
	
}
