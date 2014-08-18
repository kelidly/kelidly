package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class HttpRequest {

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
          
            URLConnection connection = realUrl.openConnection();
           
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            
            connection.connect();
           
            Map<String, List<String>> map = connection.getHeaderFields();
           
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
           
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("输出"+e);
            e.printStackTrace();
        }
   
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            
            URLConnection conn = realUrl.openConnection();
            
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            
            conn.setDoOutput(true);
            conn.setDoInput(true);
            
            out = new PrintWriter(conn.getOutputStream());
           
            out.print(param);
           
            out.flush();
          
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println(" 输出"+e);
            e.printStackTrace();
        }
       
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
    public String backJSONString(HttpServletRequest request) throws IOException {
/*		ServletInputStream input = request.getInputStream();
		StringBuffer Json = new StringBuffer();
		int b = 0;
		while ((b = input.read()) != -1) {
			Json.append((char) b);
		}
		String JsonString = new String(Json.toString().getBytes("ISO-8859-1"),
				"UTF-8");
		return JsonString;*/
    	ServletInputStream input  = request.getInputStream();
    	StringBuffer json = new StringBuffer();
    	int b = 0;
    	while ((b = input.read()) != -1){
    		json.append((char) b);
    	}
    	System.out.println("输出"+json.toString());
    	String jsonString = new String(json.toString().getBytes("ISO-8859-1"),"UTF-8");
    	System.out.println("输出"+jsonString);
    	return jsonString;
	}
    
    
    public static void main(String[] args) {
        
        /*String s=HttpRequest.sendGet("http://localhost:6144/Home/RequestString", "key=123&v=456");
        System.out.println(s);*/
        
        
        //String sr=HttpRequest.sendPost("http://localhost:8089/newrdt/login", "userName=www&pwd=111111");
       // System.out.println(sr);
    }
}