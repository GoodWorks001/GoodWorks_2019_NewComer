<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占いアプリケーション</title>
</head>
<body>
<form action = "http://localhost:8080/web/fortune" method="POST">
<h1>占いアプリケーション</h1>
<table>
<tr>
    <th>名前</th>
    <td><input type="text" name="name"></td>
</tr>
<tr>
<th>生年月日</th>
<td><select name="year">
<% for (int i = 1919;i <= 2019; i++){ %>

	<option value =<%=i %>><%= i %></option>
	<%  }  %>
</select>年

<select name="month">
<% for (int i=1;i<=12;i++){ %>

	<option value = <%=i %>>><%= i %></option>
	<% }%>
</select>月

<select name="date">
<% for (int i=1;i<=31;i++){%>

	<option value =<%=i %>><%= i %></option>
	<% }%>
</select>日
</td>
</tr>
</table>
<input type  ="submit" value="占う">
</form>

</body>
</html>