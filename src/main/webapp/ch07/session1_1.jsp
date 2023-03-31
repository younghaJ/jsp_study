<%@page contentType="text/html; charset=UTF-8"%>
<%
	String season = request.getParameter("season");
	String fruit = request.getParameter("fruit");
	
	String id = (String)session.getAttribute("idKey");
	int intervalTime = session.getMaxInactiveInterval();
	if(id!=null){
%>
<b><%=id%></b>님이 좋아하는 계절과 과일은<p>
<b><%=season%></b><b><%=fruit%></b>입니다<p>
세션ID:<%=session.getId()%><br>
세션 유지 시간: <%=intervalTime%>초
<%	
	}else{
	out.println("세션의 시간경과");
	}
%>