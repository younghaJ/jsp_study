<%@page contentType="text/html; charset=UTF-8"%>
<h1>구구단</h1>
<table border='1'>
	<tr>
		<th>2단</th>
		<th>3단</th>
		<th>4단</th>
		<th>5단</th>
		<th>6단</th>
		<th>7단</th>
		<th>8단</th>
		<th>9단</th>
	</tr>
	<%for(int i=1;i<10;i++){ %>
	<tr>
	<% for(int j=2; j<10;j++){ %>
		<td align='center'><%=j+" X "+i+" = "+j*i%></td>
	<%}%>
	</tr>
	<%}%>
</table>