package com.kelidly.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUploadUtil {
	
	public final static int FILE_NAME_ORIGINAL = 0;
	public final static  int FILE_NAME_DATE = 1;
	public final static  int FILE_NAME_MD5 = 2;
	

	public static boolean saveFile(MultipartFile file,
			HttpServletRequest request) {

		if (!file.isEmpty()) {

			try {
				String filePath = request.getSession().getServletContext()
						.getRealPath("/common/admin/upload/images");
				String fileTime = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				System.out.println("filePath:"+filePath);
				String fileTureName = fileTime + file.getOriginalFilename();
				System.out.println("fileTureName"+fileTureName);
				// 转存文件
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(filePath, fileTureName));
				// file.transferTo(new File(filePath));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static FileUploadBean saveFileAndGetBean(MultipartFile file,
			HttpServletRequest request, String folderName ) {

		if (!file.isEmpty()) {

			try {
				String filePath = request.getSession().getServletContext()
						.getRealPath("/common/admin/upload/"+folderName);
				String fileTureName = new SimpleDateFormat(
						"yyyyMMddHHmmss").format(new Date());
				// 转存文件
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(filePath, fileTureName));
				// file.transferTo(new File(filePath));
				FileUploadBean bean = new FileUploadBean();
				bean.setFileName(fileTureName);
				bean.setOriginalName(file.getOriginalFilename());
				bean.setSavePath(filePath);
				return bean;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static  FileUploadBean UploadFile(MultipartHttpServletRequest request,
			MultipartFile file,String saveRelativePath,int fileNameFormat ) {
		 String fileOriginalName = file.getOriginalFilename();   
		 String fileType=fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
		 String fileTureName ="";
		 switch (fileNameFormat) {
		case FILE_NAME_ORIGINAL:
			fileTureName = fileOriginalName;
			break;
		case FILE_NAME_DATE:
			fileTureName = new SimpleDateFormat(
					"yyyyMMddHHmmss").format(new Date()) + fileType;
			break;
		case FILE_NAME_MD5:
			fileTureName = fileOriginalName;
			break;
		default:
			fileTureName = fileOriginalName;
			break;
		}
		
		// 获取路径  
		 //String filePath = request.getSession().getServletContext().getRealPath("/")+ "common/upload/product";  
		String filePath = request.getSession().getServletContext().getRealPath("/")+ saveRelativePath;  
		//String ctxPath ="E:/images/";  
		//String ctxPath ="F:/eclipse里面的项目/hcx/WebContent/images/usermsg/";  
		// 创建文件 
		File dirPath = new File(filePath);  
		if (!dirPath.exists()) {  
		dirPath.mkdir();   
		}  
		String fileURL = filePath + "/" +fileTureName;
		File uploadFile = new File(fileURL); 
		try {
			FileCopyUtils.copy(file.getBytes(), uploadFile);
		} catch (IOException e) {
	
			return null;
		} 
		
		FileUploadBean bean = new FileUploadBean();
		bean.setState("success");
		bean.setFileName(fileTureName);
		bean.setType(fileType);
		bean.setOriginalName(fileOriginalName);
		bean.setSavePath(filePath);
		bean.setUrl(fileURL);
		bean.setRelativeURL(saveRelativePath + fileTureName);
		//bean.setSize(""+file.getSize());      
	/*	if (fileURL.) {
			
		}*/
		        System.out.println("********************imgFile1******" );
		        return bean;
	}

}
