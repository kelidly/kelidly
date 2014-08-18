package com.kelidly.web.controller.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kelidly.entity.Case;
import com.kelidly.model.PageModel;
import com.kelidly.service.CaseService;


@Controller
@RequestMapping("/back/case")
public class BackCaseController {

	@Resource(name = "caseService")
	CaseService caseService;
	
	@RequestMapping("/manage")
	public String toManage(Model model){
		// TODO Auto-generated method stub
		PageModel pagemodel =  caseService.query(1, 5);
		model.addAttribute("pagemodel", pagemodel);
		 return "/admin/case/case_manage";
	}
	@RequestMapping("/del")
	public String del(Model model,@RequestParam("caseId") int id){
		
		Boolean flag = false;
		flag = caseService.delete(id);
		if(flag){
			
			return toManage(model);
		}
		return "/admin/case/case_manage";
	}
	
	@RequestMapping("/pub")
	public String toPublic(Model model){
		
		
		return "/admin/case/case_pub";
	}
	@RequestMapping("/update")
	public String update(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request,Case bean,Model model) throws IOException{
		if (!file.isEmpty()) {
			InputStream is=null;
			FileOutputStream fos =null;
			    
				String filePath = "/upload/images/"+new Date().getTime()+file.getOriginalFilename();
				String realPath = request.getSession().getServletContext().getRealPath("common/")
						+filePath;
				
				System.out.println(realPath);
				fos = new FileOutputStream(realPath);
				is = file.getInputStream();
				int b=0;
				while((b=is.read())!= -1){
					fos.write(b);
				}
				fos.flush();
				fos.close();
				is.close();
				
				bean.setPic("/common"+filePath);
		}
		
			
		Boolean flag = false;
	
		flag = caseService.update(bean);
		if(flag){
			
			return toManage(model);
		}
		return "/admin/case/case_manage";
	}

	
	@RequestMapping("/add")
	public String add(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request,Case bean,Model model) throws IOException{
		if (!file.isEmpty()) {
			InputStream is=null;
			FileOutputStream fos =null;
			    
				String filePath = "/upload/images/"+new Date().getTime()+file.getOriginalFilename();
				String realPath = request.getSession().getServletContext().getRealPath("common/")
						+filePath;
				
				System.out.println(realPath);
				fos = new FileOutputStream(realPath);
				is = file.getInputStream();
				int b=0;
				while((b=is.read())!= -1){
					fos.write(b);
				}
				fos.flush();
				fos.close();
				is.close();
				
				bean.setPic("/common"+filePath);
		}
		Boolean flag = false;
		flag = caseService.add(bean);
		if(flag){
			
			return toManage(model);
		}
		return "/admin/case/case_manage";
	}
	
	@RequestMapping("/updateView")
	public String toUpdate(@RequestParam("caseId")int caseId,Model model){
		
		
		Case bean = caseService.queryBean(caseId);
	
		model.addAttribute("bean", bean);
		
		return "/admin/case/case_update";
	}
	
	@RequestMapping("/pageQuery")
	public String toPageManage(@RequestParam(value="currentPage",defaultValue="1") int pageNo,
			@RequestParam(value="pageSize",defaultValue="8") int pageSize,Model model){
	
		
		PageModel pagemodel = caseService.query(pageNo,pageSize);
		
		
		model.addAttribute("pagemodel", pagemodel);
		return "/admin/case/case_manage";
	}
	@RequestMapping("/delMany")
	public String delMany(@RequestParam("checkId")int[] idArr,Model model){

		 Boolean flag = false;
		 flag = caseService.delete(idArr);
		 if(flag){
			 
			 return toManage(model);
		 }
		return "/admin/product/pro_manage";
	}
	
}
