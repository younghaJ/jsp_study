<%@page contentType="text/html; charset=UTF-8"%>
<%@page session="true" %>
<%
	String sessionID = session.getId();
	session.setMaxInactiveInterval(30);
%>
최초 접속시 제공되는 세션 id 값 : <%=sessionID %>