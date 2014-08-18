package com.kelidly.web.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kelidly.entity.News;
import com.kelidly.entity.NewsType;
import com.kelidly.entity.SystemConfig;
import com.kelidly.model.PageModel;
import com.kelidly.model.SystemInfoForm;
import com.kelidly.service.NewsService;
import com.kelidly.service.SystemService;

@Controller
@RequestMapping("/back/system")
public class BackSystemController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(BackSystemController.class);
	String checkpassword = "";
	String password = "";
	String username= "";	
	private List<SystemConfig> sysInfo;
	@Resource
	private SystemService systemService;
	
	/**
	 *  显示配置
	 * @param model
	 * @return
	 */
	@RequestMapping("/showSystemConfig")
	public String showSystemConfig(Model model){
		
		sysInfo = systemService.getSystemInfoForList();
		model.addAttribute("sysInfo", sysInfo);
		
		return "/admin/system/system_manage";
	}
	
	/**
	 * 更新配置
	 * @param bean
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateSystemconfig")
	public String updateSystemconfig(SystemInfoForm systemInfoForm,Model model){
		List<SystemConfig> systemConfigs = systemInfoForm.getSysInfo();
		String rtMsg = "";
		if (systemConfigs != null){
			try {
				systemService.updateSystemInfo(systemConfigs);
				rtMsg = "更新成功！";
			} catch (Exception e) {
				rtMsg = "更新失败！请查明原因。";
			}
		}
		model.addAttribute("rtMsg", rtMsg);
		
		sysInfo = systemService.getSystemInfoForList();
		model.addAttribute("sysInfo", sysInfo);	        
		
		return "/admin/system/system_manage";
	}	
	
	@RequestMapping("/clean")
	public String clean(Model model){
		
		String rtMsg = "";
		try {
			systemService.updateSystemInfo();
			rtMsg = "缓存清除成功！";
		} catch (Exception e) {
			rtMsg = "缓存清除失败！请查明原因。";
		}
		model.addAttribute("rtMsg", rtMsg);
		
		sysInfo = systemService.getSystemInfoForList();
		model.addAttribute("sysInfo", sysInfo);
		
		return "/admin/system/system_manage";
		
	}


	
	

}
