<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="result" class="ec.ItemBean" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品紹介</title>
</head>
<body>

<form action ="shoukaiServlet" method ="POST">

<h1><p align="center">商品紹介</p></h1>

<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="black">
<tr>
<td>商品名</td>
<td><jsp:getProperty name="result" property="name"/></td>
</tr>
<tr>
<td>カテゴリ</td>
<td><jsp:getProperty name="result" property="category"/></td>
</tr>
<tr>
<td>価格</td>
<td><jsp:getProperty name="result" property="price"/>円</td>
</tr>
<tr>
<td>在庫</td>
<td><jsp:getProperty name="result" property="stock"/></td>
</tr>
<tr>
<td>商品紹介</td>
<td><jsp:getProperty name="result" property="msg"/></td>
</tr>
</table>
<div>個数


<select name="category">
		<option></option>
			<% for(int i=0; i<10; i++) { %>
			<option value="<%= i %>"><%= i %></option>
			<% } %>

</div>

<input type="submit" value="カート">

<input type="button" value="戻る" onClick="location.href='kensaku.jsp'">

</form>
</body>
</html>