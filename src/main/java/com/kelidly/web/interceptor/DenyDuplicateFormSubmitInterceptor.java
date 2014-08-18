package com.kelidly.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kelidly.commons.conf.CommonConstant;
import com.kelidly.util.StringUtil;


/**
 * 
 * @ClassName: DenyDuplicateFormSubmitInterceptor 
 * @Description: token拦截器 
 * @author Victor.Chen chenld_fzu@163.com
 * @date 2012-3-30 下午03:04:32 
 *
 */
public class DenyDuplicateFormSubmitInterceptor extends HandlerInterceptorAdapter{
	
	


	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
	//default-storage-engine=INNODB
		 HttpSession session = request.getSession();
		 String sessionStr = (String)session.getAttribute(CommonConstant.AUTH_USER);
		 String str = request.getRequestURI()+".html";
		 //判断是否是登录请求，是的话就跳过去
		 if (StringUtil.isEmpty(sessionStr)) {
			 if (!str.startsWith("/admin/admin.html")||!str.startsWith("/admin/login.html")) {
				 response.sendRedirect(request.getContextPath() + "/admin/login.html");
			}
		 }		 
		return super.preHandle(request, response, handler);
	}  
	

}
