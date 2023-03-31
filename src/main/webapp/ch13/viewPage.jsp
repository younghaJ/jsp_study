<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%
	final String SAVEFOLDER = "C:/Jsp/myappp/src/main/webapp/ch13/storage/";
	final String ENCODING = "UTF-8";
	final int MAXSIZE = 1024*1024*20; //20MB
	try{
		MultipartRequest multi = 
				new MultipartRequest(request, SAVEFOLDER, MAXSIZE, ENCODING, new DefaultFileRenamePolicy());
		String user = multi.getParameter("user");
		String title = multi.getParameter("title");
		String fileName = multi.getFilesystemName("mylife");
		String fileType = multi.getContentType("myfile");
		//파일정보
		File f = multi.getFile("myfile");
		long len = 0;
		if(f!=null)
			len = f.length();
		out.println("user : " + user);
		out.println("title : " + title);
		out.println("user : " + fileName);
		out.println("user : " + fileType);
		out.println("user : " + len + "byte");
		out.println("user : " + user);
	}catch(Exception e){
		e.printStackTrace();
	}
%>