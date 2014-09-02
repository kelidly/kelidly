package com.kelidly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kelidly.dao.AdminDao;
import com.kelidly.entity.Admin;
import com.kelidly.service.AdminService;
import com.kelidly.util.MD5;

@Component("adminService")
public class AdminServiceImpl implements AdminService {

	@Resource(name="adminDao")
	AdminDao adminDao;
	

	@Override
	public boolean addAdmin(Admin bean) {
		
		try {
			adminDao.create(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}



	@Override
	public boolean loginAdmin(String userName, String pwd) {
		boolean flag = false;
		MD5 md5 = new MD5();	
		String password = md5.getMD5ofStr(pwd);
		Admin admin = adminDao.getAdminByInputNameAndPassword(userName, password);
		if (admin != null) {
			flag = true;
		}
		return flag;
	}


}
