<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mgr" class="ch09.TeamMgr"></jsp:useBean>
<jsp:useBean id="bean" class="ch09.TeamBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>

<%
	boolean result = mgr.updateTeam(bean);
	String msg = "수정실패";
	String url = "teamList.jsp";
	if(result){
		msg = "수정성공";
		url = "teamRead.jsp?num="+bean.getNum();
	}else{
		
	}
%>

<script>
alert("<%=msg%>");
location.href = "<%=url%>";
</script>
