<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�肢�A�v���P�[�V����</title>
</head>
<body>
<form action = "http://localhost:8080/web/fortune" method="POST">
<h1>�肢�A�v���P�[�V����</h1>
<table>
<tr>
    <th>���O</th>
    <td><input type="text" name="name"></td>
</tr>
<tr>
<th>���N����</th>
<td><select name="year">
<% for (int i = 1919;i <= 2019; i++){ %>

	<option value =<%=i %>><%= i %></option>
	<%  }  %>
</select>�N

<select name="month">
<% for (int i=1;i<=12;i++){ %>

	<option value = <%=i %>>><%= i %></option>
	<% }%>
</select>��

<select name="date">
<% for (int i=1;i<=31;i++){%>

	<option value =<%=i %>><%= i %></option>
	<% }%>
</select>��
</td>
</tr>
</table>
<input type  ="submit" value="�肤">
</form>

</body>
</html>