<%@ page contentType="image/jpeg" %>
<%@ page import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" %>
<%@page import="com.softfz.hx.commons.conf.CommonConstant"%>
<%! 
	Color getRandColor(int fc,int bc){
		Random random = new Random();
		if(fc>255)	fc = 255;
		if(bc>255)	bc = 255;
		
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r,g,b);
	}
%>
 
<%
 	response.setHeader("Pragma","No-cache");
 	response.setHeader("cache-Control","no-cache");
 	response.setDateHeader("Expires",0);
 	
 	//参数
 	//图片宽度
 	int width = request.getParameter("width")==null||"".equals(request.getParameter("width").trim())?
 		60:Integer.parseInt(request.getParameter("width"));
 	//图片高度
 	int height = request.getParameter("height")==null||"".equals(request.getParameter("height").trim())?
 		20:Integer.parseInt(request.getParameter("height"));
 	//验证码个数	
 	int codeNum = request.getParameter("num")==null||"".equals(request.getParameter("num").trim())?
 		4:Integer.parseInt(request.getParameter("num"));
 	//SESSION名称
 	String sessionName = request.getParameter("name")==null||"".equals(request.getParameter("name").trim())?
 			CommonConstant.VERITY_CODE_KEY:request.getParameter("name");
 	
 	//在内存中创建图象
 	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
 	
 	//获取图形上下文
 	Graphics g = image.getGraphics();
 	Random random = new Random();
 	
 	g.setColor(getRandColor(200,250));
 	g.fillRect(0,0,width,height);
 	
 	g.setFont(new Font("Times New Roman",Font.PLAIN,18));
 	g.setColor(getRandColor(160,200));
 	
 	for(int i=0;i<55;i++){
 		int x = random.nextInt(width);
 		int y = random.nextInt(height);
 		int x1 = random.nextInt(12);
 		int y1 = random.nextInt(12);
 		g.drawLine(x,y,x+x1,y+y1);
 	}
 	
 	//取随机产生的认证码
 	String sRand = "";
 	for(int i=0;i<codeNum;i++){
 		String rand = String.valueOf(random.nextInt(10));
 		sRand += rand;
 		g.setColor(getRandColor(0,160));
 		g.drawString(rand,13*i+6,16);
 	}
 	session.setAttribute(sessionName,sRand);
 	g.dispose();

	ServletOutputStream sos = response.getOutputStream();
 	ImageIO.write(image,"JPEG",sos);
	sos.flush();
	sos.close();
	response.flushBuffer();
	out.clear();
	out = pageContext.pushBody();
%>