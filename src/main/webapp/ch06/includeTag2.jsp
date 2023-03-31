<%@page contentType="text/html; charset=UTF-8"%>
<%
	String siteName = request.getParameter("siteName");
%>
요청한 사이트 : <%=siteName%>
<!-- 추가적인 요청값이 있을때 param 사용 -->
<jsp:include page="includeTagTop2.jsp">
	<jsp:param name="id" value="aaa"/>
	<jsp:param name="pwd" value="1234"/>
</jsp:include>