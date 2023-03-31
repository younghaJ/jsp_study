<%@page contentType="text/html; charset=UTF-8"%>
<%
	String bloodType = request.getParameter("bloodType");
	String name = "aaa";
%>
<!-- 표현식에서 ""이 있을깨는 ''으로 시작한다 -->
<jsp:include page= '<%=bloodType+".jsp"%>'>
	<jsp:param value="<%=name%>" name="name"/>
</jsp:include>