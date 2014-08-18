package com.kelidly.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kelidly.model.SystemInfo;
import com.kelidly.util.NumberUtils;
import com.kelidly.util.StringUtil;




public class Global {
	
	private static Logger logger = Logger.getLogger(Global.class);
	
	public static SystemInfo SYSTEMINFO;
	public static Map BORROWCONFIG;
	public static List ALLKEFU;

	public static Set TENDER_SET= Collections.synchronizedSet(new HashSet());
	public static Map RESULT_MAP=Collections.synchronizedMap(new HashMap<String,String>());
	public static final String TABLE_PREFIX="";
	
	public static String[] SYSTEMNAME=new String[]{"webname","meta_keywords","meta_description",
		"beian","copyright","fuwutel","address","weburl","vip_fee","most_cash","theme_dir"};
	
	public static ThreadLocal ipThreadLocal= new ThreadLocal();
	public static ThreadLocal perviewBorrowThreadLocal = new ThreadLocal();
	public static ThreadLocal paramLocal = new ThreadLocal();
	

	
	public static String getValue(String key){
		Object o=null;
		if(SYSTEMINFO!=null){
			o=SYSTEMINFO.getValue(key);
		}
		if(o==null){
			return "";
		}
		return o.toString();
	}
	
	public static String getString(String key){
		String s=StringUtil.isNull(getValue(key));
		return s;
	}
	
	public static int getInt(String key){
		int i=NumberUtils.getInt(getValue(key));
		return i;
	}
	
	public static double getDouble(String key){
		double i=NumberUtils.getDouble(getValue(key));
		return i;
	}	

	public static String getWebid(){
		return StringUtil.isNull(Global.getValue("webid"));
	}
	
	public static String getIP(){
		Object retObj=Global.ipThreadLocal.get();
		logger.debug("Set Ip:"+retObj);
		return retObj==null?"":retObj.toString();
	}

}
