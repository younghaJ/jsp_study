<%@page import="ch07.MuUtil"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%
	String protocol = request.getProtocol();
	int port = request.getServerPort();
	//ip값
	String remoteAddr = request.getRemoteAddr();
	String method = request.getMethod();
	String uri = request.getRequestURI();
	StringBuffer url = request.getRequestURL();
	String query = request.getQueryString();
	//정수타입으로 매개변수 받는 방법
	//int age = Integer.parseInt(request.getParameter("age"));
	int age2 = MuUtil.parseInt(request, "age");
%>
protocal:<%=protocol%><br>
port:<%=port%><br>
remoteAddr:<%=remoteAddr%><br>
method:<%=method%><br>
uri:<%=uri%><br>
url:<%=url%><br>
query:<%=query%><br>