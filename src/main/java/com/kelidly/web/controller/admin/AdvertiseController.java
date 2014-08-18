package com.kelidly.web.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kelidly.entity.Advertise;
import com.kelidly.service.AdvertiseService;
import com.kelidly.util.FileUploadBean;
import com.kelidly.util.FileUploadUtil;

@Controller  
@RequestMapping("/advertise")
public class AdvertiseController {
	@Autowired
	private HttpServletRequest request;

	@Resource(name="advertiseService")
	AdvertiseService advertiseService; 
	
	@RequestMapping("filesUpload")
	public String filesUpload(@RequestParam("files") MultipartFile[] files) {
		//判断file数组不能为空并且长度大于0
		if(files!=null&&files.length>0){
			//循环获取file数组中得文件
			for(int i = 0;i<files.length;i++){
				MultipartFile file = files[i];
				//保存文件
				FileUploadBean uploadBean = FileUploadUtil.saveFileAndGetBean(file, request,"advertise");
				if (uploadBean!= null) {
					Advertise bean = new Advertise();
					bean.setName(uploadBean.getFileName());
					bean.setOldName(uploadBean.getOriginalName());
					bean.setPath(uploadBean.getSavePath());
					
					advertiseService.saveBean(bean);
				}
			}
		}
		// 重定向
		return "redirect:/list.html";
	}

	@RequestMapping("fileUpload")
	public String fileUpload(@RequestParam("file") MultipartFile file){
		
		if (!file.isEmpty()) {
			FileUploadBean uploadBean = FileUploadUtil.saveFileAndGetBean(file, request,"advertise");
			if (uploadBean!= null) {
				Advertise bean = new Advertise();
				bean.setName(uploadBean.getFileName());
				bean.setOldName(uploadBean.getOriginalName());
				bean.setPath(uploadBean.getSavePath());
				
				advertiseService.saveBean(bean);
			}
		}
		
		return "";
	}

	
}
