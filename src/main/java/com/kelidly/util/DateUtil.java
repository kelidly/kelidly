package com.kelidly.util;


import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * a)	创建方法：public Date stringToDate(String dateStr, String pattern)
实现功能：将指定格式字符串转换成时间。
实现步骤：先创建SimpleDateFormat(pattern),再调用SimpleDateFormat中的parse(dateStr)方法，最后return转换好的时间。


b)	创建方法：public Date dateToString(Date date, String pattern)
实现功能：将时间转换成指定格式字符串
实现步骤：先创建SimpleDateFormat(pattern),再调用SimpleDateFormat中的format(date)方法，最后return转换好的字符串格式的时间。
注：可以重载以上两个方法指定字符串格式为(“yyyyMMdd”、“yyyy-MM-dd”或“yyyy-MM-dd HH:mm:ss”)


	 */
	

	/**
	 * 重载实现功能：将指定格式字符串转换成时间。
	 * @param dateStr
	 * @param pattern
	 * @param index
	 * @return
	 */
	public Date stringToDate(String dateStr, String pattern,int index){
		DateFormat df = new SimpleDateFormat(pattern);
		      Date date = null;
		    //从指定位置开始解析
			date = df.parse(dateStr,new ParsePosition(index));
		
		   return date;
	}
	/**
	 * 重载 实现功能：将指定格式字符串转换成时间。
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	
	public static Date stringToDate(String dateStr, String pattern){
		DateFormat df = new SimpleDateFormat(pattern);
		      Date date = null;
		    
			date = df.parse(dateStr,new ParsePosition(0));
		
		   return date;
	}
	
	public static Date stringToDate(String dateStr){
		DateFormat df = new SimpleDateFormat();
		      Date date = null;
		    
			date = df.parse(dateStr,new ParsePosition(0));
		
		   return date;
	}
	
	/**
	 * 实现功能：将时间转换成指定格式字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString(Date date, String pattern){
		
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}



}
