package com.kelidly.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kelidly.constants.Global;
import com.kelidly.entity.Article;
import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;
import com.kelidly.service.ArticleService;
import com.kelidly.service.SiteService;

public class BaseController {
	
	@Resource(name = "siteService")
	SiteService siteService;

	@Resource(name = "articleService")
	ArticleService articleService;

	@Autowired
	private HttpServletRequest request;
	/**
	 * 显示site和article
	 * @param pid 一级栏目的id，查找二级目录使用
	 * @param id 二级栏目id，查找二级栏目文章或者列表
	 * @param pageNo 文章列表页码
	 * @param pageSize 文章列表大小
	 * @param model
	 */
	protected void showSiteAndArticle(long pid,long id,long articleid,int pageNo,int pageSize,Model model) {

		// 一级栏目
		List<Site> psitelist = siteService.findFirstSiteList();
		model.addAttribute("psitelist", psitelist);

		//二级栏目		
		List<Site> sublist = siteService.findSiteListByPid(pid);
		model.addAttribute("sublist", sublist);
		
		// 二级子栏目
		Site psite = siteService.findSiteById(pid);
		model.addAttribute("psite", psite);

		// 栏目内容
		Site site = siteService.findSiteById(id);
		model.addAttribute("site", site);
		// --判断列表类型 内容 或 列表
		if (site != null && site.getState() == 2) {
			// 查找article表得列表
			PageModel pagemodel = articleService.findPageArticleBySiteId(
					pageNo, pageSize, id);
			model.addAttribute("pagemodel", pagemodel);
			
			Article article = articleService.findArticleByid(articleid);
			model.addAttribute("article", article);
			
		}
	}
	
	/**
	 * 判断文件夹是否存在，不存在者创建
	 */
	protected void checkfolderExists(String url) {
		File file=new File(url);  
		if  (!file .exists()  && !file .isDirectory())      
		{      
			try {
				file .mkdirs(); 				
			} catch (Exception e) {
				e.printStackTrace();
			}
		   
		    
		}
	}
	/**
	 * 判断文件是否存在，不存在者创建
	 */
	protected void checkFileExists(String url) {
		File file=new File(url);  
		if(!file.exists())    
		{    
		    try {    
		        file.createNewFile();    
		    } catch (IOException e) {    
		        e.printStackTrace();    
		    }    
		}  
	}
	
	protected String addImage(CommonsMultipartFile imgfile) {
		
		String filePath = null;
		
		if (!imgfile.isEmpty()) {
			InputStream is=null;
			FileOutputStream fos =null;
			
			//系统配置目录
			String varfilename = Global.getValue("resources");
			//当前时间做文件夹
			String filedirName = "/"+new Date().getTime();
			//文件名
			String fileName = "/"+imgfile.getOriginalFilename();
			
			//系统目录
			filePath = varfilename+filedirName+fileName;
			//保存目录
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			
			checkfolderExists(rootPath+varfilename+filedirName);
			try {
				fos = new FileOutputStream(rootPath+filePath);
				is = imgfile.getInputStream();
				int b=0;
				while((b=is.read())!= -1){
					fos.write(b);
				}
				fos.flush();
				fos.close();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;				
			}			
		}
		return filePath;
		
	}
	
protected String addFlashFiles2(CommonsMultipartFile[] files) {
		
		String filePath = null;
		
		if (files.length != 0 && files != null) {
			InputStream is=null;
			FileOutputStream fos =null;
			FileOutputStream imgfos =null;
			FileOutputStream swffos =null;
			//系统配置目录
			String varfilename = Global.getValue("resources");
			String filedirName = "/"+new Date().getTime();
			//系统目录
			filePath = varfilename + "/common/kelidly-res/effect" + filedirName;
			//保存目录
			String rootPath = request.getSession().getServletContext().getRealPath("/") + filePath;
			
			//checkfolderExists(rootPath);
			//checkfolderExists(rootPath + "/image");
			checkfolderExists(rootPath);
			checkfolderExists(rootPath + "/image");
			try {

				String originalFilename = null;
				for (CommonsMultipartFile commonsMultipartFile : files) {
					is = commonsMultipartFile.getInputStream();
					originalFilename = commonsMultipartFile.getOriginalFilename();
					if(originalFilename.lastIndexOf(".swf") != -1 
							|| originalFilename.lastIndexOf(".xml") != -1){
						swffos = new FileOutputStream(rootPath + "/" + originalFilename);
						fos = swffos;
					}
					else{
						imgfos = new FileOutputStream(rootPath + "/image/" + originalFilename);
						fos = imgfos;
					}
					int b=0;
					while((b=is.read())!= -1){
						fos.write(b);
					}
					fos.flush();
					fos.close();
					is.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;				
			}			
		}
		return filePath;
		
	}
protected String addFlashFiles(String rootPath,CommonsMultipartFile commonsMultipartFile) {
	
	
	
	if (commonsMultipartFile != null) {
		InputStream is=null;
		FileOutputStream fos =null;
		FileOutputStream imgfos =null;
		FileOutputStream swffos =null;

		try {

			String originalFilename = null;
			
				is = commonsMultipartFile.getInputStream();
				originalFilename = commonsMultipartFile.getOriginalFilename();
				if(originalFilename.lastIndexOf(".swf") != -1 
						|| originalFilename.lastIndexOf(".xml") != -1){
					swffos = new FileOutputStream(rootPath + "/" + originalFilename);
					fos = swffos;
				}
				else{
					imgfos = new FileOutputStream(rootPath + "/image/" + originalFilename);
					fos = imgfos;
				}
				int b=0;
				while((b=is.read())!= -1){
					fos.write(b);
				}
				fos.flush();
				fos.close();
				is.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;				
		}			
	}
	return "";
	
}


}
