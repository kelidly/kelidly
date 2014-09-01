package com.kelidly.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.kelidly.constants.Global;
import com.kelidly.dao.SystemDao;
import com.kelidly.entity.SystemConfig;
import com.kelidly.model.SystemInfo;
import com.kelidly.service.SystemService;


//
//import com.wojiaowaimai.context.Global;
//import com.wojiaowaimai.dao.SystemDao;
//import com.wojiaowaimai.dao.UsersDao;
//import com.wojiaowaimai.entity.SystemConfig;
//import com.wojiaowaimai.model.SystemInfo;
//import com.wojiaowaimai.service.SystemService;
//import com.wojiaowaimai.web.action.UsersAction;


@Service("systemService")
public class SystemServiceImpl implements SystemService {
	
	private static Logger logger = Logger.getLogger(SystemServiceImpl.class);
	
	@Resource
	private SystemDao systemDao;
	
	@Override
	public SystemInfo getSystemInfo() {
		SystemInfo info = new SystemInfo(); 
		List list = systemDao.getsystem();
		for (int i = 0; i < list.size(); i++) {
			SystemConfig sys = (SystemConfig) list.get(i);
			info.addConfig(sys);
		}		
		return info;
	}

	
	@Override
	public List getSystemInfoForList() {		
		return systemDao.getsystem();
	}

	/**
	 * 根据模块显示系统设置信息
	 * @return
	 */	
	@Override
	public List getSystemInfoForListBysytle(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void updateSystemInfo(List<SystemConfig> list) {
		for (SystemConfig systemConfig : list) {
			systemDao.update(systemConfig);
		}
		
	}
	
	/**
	 * @author lijie
	 * @param url
	 * url 为网站根目录路径
	 */
	@Override
	public void clean(String url) {
		
	}

	
	@Override
	@Transactional
	public void updateSystem(long id) {
		
	}
	
	

	
	private void setWebConfig(ServletContext context, SystemInfo info){

		String[] webinfo=Global.SYSTEMNAME;
		for(String s:webinfo){
			logger.debug(s+":"+info.getValue(s));
			context.setAttribute(s, info.getValue(s));
		}
		context.setAttribute("webroot", context.getContextPath());
	}


	@Override
	public void addDrawBankList(List list) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 更新 系统config
	 */
	@Override
	public void updateSystemInfo(){
		
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		ServletContext context = wac.getServletContext();
		
		SystemInfo info = getSystemInfo();
		Global.SYSTEMINFO = info;
		setWebConfig(context,info);
		
		
	}
	
}
