<%@page contentType="text/html; charset=UTF-8"%>
<%!
	int one;					//필드는 JVM이 초기화를 세팅해줌. <- 선언문
	int two = 1;
	public int plus(){
		int three = one + two;
		return three;
	}
%>
<%
	int a;
	int b = 1;
//	int c = a+b;				//선언문이 아니기 때문에 초기화를 시겨주어야 한다
%>
<%=plus() %>