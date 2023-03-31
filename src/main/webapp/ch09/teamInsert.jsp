<!-- ch09 / teamInsert.jsp -->
<%@page import="java.util.Vector" %>
<%@page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="mgr" class="ch09.TeamMgr"/>
<%
	Vector<String> vlist = mgr.teamList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
function check(){
	f = document.frm;
	if(f.city.value == ""){
		alert("사는곳 입력하세요.");
		f.city.focus();
		return;
	}
	if(f.age.value == ""){
		alert("나이 입력하세요.");
		f.age.focus();
		return;
	}
	if(f.team.value == ""){
		alert("팀 입력하세요.");
		f.team.focus();
		return; //
	}
	if(f.name.value == ""){
		alert("이름입력하세요.");
		f.name.focus();
		return; 
	}
	f.submit();
}
function check2(){
	document.frm.action = "teamInsertProc2.jsp";
	document.frm.submit();
}

function selectTeam(){
	// select의 name을 id로 변경
	teamselect = document.getElementById("teamselect");
	team = teamselect.options[teamselect.selectedIndex].value;
	//alert(team);
	document.frm.team.value= team;
}
</script>


<body>
<div align = "center">
<h1>Team Mgr
<form name="frm" method="post" action="teamInsertProc.jsp">
	<table border="1">
<tr>
	<td width="50" align="center">이름
	<td width="150"><input name="name" value="홍길동">

<tr>
	<td align="center">사는곳
	<td><input name="city" value="부산">

<tr>
	<td align="center">나이
	<td ><input name="age" value="27">

<tr>
	<td align="center">팀명
	<td>
		<input name="team" size="8">
		<select id="teamselect" onchange="selectTeam()">
			<% for(int i=0; i<vlist.size(); i++){ %>
				<option value="<%=vlist.get(i) %>"><%=vlist.get(i) %>
			<%} %>
		
	

<tr>
	<td align="center" colspan="2">
		<input type="button" value="SAVE" onclick="check()">
		<input type="button" value="SAVE2" onclick="check2()">
	


<p>
List
</div>
</body>
</html>