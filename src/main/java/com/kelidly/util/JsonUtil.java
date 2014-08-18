package com.kelidly.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JsonUtil {

	public static void write(HttpServletResponse response, String resultFlag,
			String result) throws IOException {
		PrintWriter out = response.getWriter();  
		JSONObject json=new JSONObject();  
		json.accumulate(resultFlag, result); 
		out.println(json.toString());   
		out.flush();   
		out.close(); 
	}
	public static void test( String resultFlag,
			String result) throws IOException {
		
		JSONObject json=new JSONObject();  
        json.accumulate(resultFlag, result); 
        System.out.println(json.toString());   
  
	}
	public static void main(String[] args) {
		try {
			test("success","1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
