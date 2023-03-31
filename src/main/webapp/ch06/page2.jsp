<%@page import="java.util.Date"%>
<%@page contentType="text/html; charset=UTF-8"
		import="java.util.*,java.net.*"
%>
<%@page session="true" buffer="16kb"%>

<%
	Date d = new Date();
%>
현제의 날짜와 시간은? <%=d.toLocaleString()%>