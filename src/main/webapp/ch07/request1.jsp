<%@page contentType="text/html; charset=UTF-8"%>
<%
	// hobby를 제외한 다른 값을 출력	
	String name = request.getParameter("name");
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");
	String test = request.getParameter("test");
	String hobby[] = request.getParameterValues("hobby");
%>
name:<%=name%><br>
studentNum:<%=studentNum%><br>
gender:<%=gender%><br>
major:<%=major%><br>
hobby:<%
	for(int i=0;i<hobby.length;i++){
		out.println(hobby[i]+"&nbsp");
	}
%>
<br>

name:<%=name.length()%><br>
test:<%=test%><br>