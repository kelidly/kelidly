package com.kelidly.web.controller.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kelidly.entity.Case;
import com.kelidly.entity.Site;
import com.kelidly.model.PageModel;
import com.kelidly.service.CaseService;
import com.kelidly.web.controller.BaseController;



@Controller
@RequestMapping("/back/case")
public class BackCaseController extends BaseController{

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
		
		
		return "/admin/case/case_pub";
	}
	@RequestMapping("/update")
	public String update(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request,Case c,Model model) throws IOException{
		
		
		if(file!=null){
			// 添加图片
			String filePath = addImage(file);
			if (filePath != null) {
				c.setPic(filePath);
			} else {
				c.setPic(null);
			}
		}		
			
		Boolean flag = false;	
		flag = caseService.update(c);		
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
	public String add(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request,Case c,Model model) throws IOException{
		
		if(file!=null){
			// 添加图片
			String filePath = addImage(file);
			if (filePath != null) {
				c.setPic(filePath);
			} else {
				c.setPic(null);
			}
		}		
		Boolean flag = false;
		flag = caseService.add(c);
		String rtMsg = "";
		if (flag) {
			rtMsg = "添加成功！";
			// 返回文章管理
			model.addAttribute("rtMsg", rtMsg);
			return toManage(model);
		} else {
			rtMsg = "添加失败！请查明原因。";			
			model.addAttribute("rtMsg", rtMsg);
			return "/admin/case/case_manage";
		}		
		
		
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
		String rtMsg = "";
		if (flag) {
			rtMsg = "删除成功！";
		} else {
			rtMsg = "删除失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);
		
		return toManage(model);
		
		
	}
	
	
	
}
