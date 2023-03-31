<%@page contentType="text/html; charset=UTF-8"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	//DB에 왔다 갔다 가정하고
	boolean result = true;
	String msg = "로그인 실패";
	String url = "login.jsp";
	
	if(result){
		msg = "로그인 성공";
		url = "loginOK.jsp";
		session.setAttribute("idKey", id);
	}	
%>
<script>
	alert("<%=msg%>");
	location.href = "<%=url%>";
</script>