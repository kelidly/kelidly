package com.kelidly.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kelidly.constants.Global;
import com.kelidly.model.SystemInfo;
import com.kelidly.service.SystemService;




public class WebConfigContextListener implements ServletContextListener {
	private static Logger logger=Logger.getLogger(WebConfigContextListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext context=event.getServletContext();
//		ApplicationContext applicationContext= WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SystemService systemService=(SystemService)applicationContext.getBean("systemService");
		SystemInfo info = systemService.getSystemInfo();
		Global.SYSTEMINFO = info;
		
		setWebConfig(context,info);
	}

	
	private void setWebConfig(ServletContext context, SystemInfo info){

		String[] webinfo=Global.SYSTEMNAME;
		for(String s:webinfo){
			logger.debug(s+":"+info.getValue(s));
			context.setAttribute(s, info.getValue(s));
		}		
		context.setAttribute("webroot", context.getContextPath());
	}

}
