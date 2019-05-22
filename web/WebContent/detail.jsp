<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="pro" scope="session" class="web.ProductBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--使用するクラスのインポート --%>
<%@page import="java.util.ArrayList"%>


<html>
<head>
<%--スタイルシートの定義 --%>
<style>
h1 {
	text-align: center;
}

</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品紹介</title>

<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link href="ecentry.css" rel="stylesheet" type="text/css">
</head>

<body>

<h1 align="center">商品紹介</h1>
<form action = "http://localhost:8080/web/cart" method="POST">
<img src ="<jsp:getProperty property="pro_img" name="pro"/>" align = "left" width: 300px  height: 300px>

<article>
<table border="1" width="400" cellspacing="0" cellpadding="5" bordercolor="black">
<tr>
	<td>商品</td>
	<td><jsp:getProperty property="pro_name" name="pro"/></td>
</tr>

<tr>
	<td>カテゴリ</td>
	<td><jsp:getProperty property="cat_id" name="pro"/></td>
</tr>

<tr>
	<td>価格</td>
	<td><jsp:getProperty property="pro_price" name="pro"/></td>
</tr>
<tr>
	<td>在庫</td>
	<td><jsp:getProperty property="stock_no" name="pro"/></td>
</tr>

<tr>
	<td>商品紹介</td>
	<td><jsp:getProperty property="pro_msg" name="pro"/></td>
</tr>


</table>



<% int zaiko= (Integer)session.getAttribute("zaiko"); %>

<table><tr><td>
個数<select name="zaiko">
<option value="1">1</option>
<% for(int i=2; i<=zaiko;i++){ %>
<option value="<%=i%>"><%=i %></option>
<%} %>

<input type ="hidden" value= "<jsp:getProperty property="pro_name" name="pro"/>" name="name">
<input type ="hidden" value= "<jsp:getProperty property="pro_price" name="pro"/>" name="price">
<input type ="hidden" value= "<jsp:getProperty property="pro_cd" name="pro"/>" name="id">

<input type ="submit" value="カートへ" class="btn">
</form>
</select>

</td>
<td>



<form action ="login.jsp">
<input type = "submit" value="戻る" class="btn">
</form>

</td>
</tr></table>

</article>
</body>
</html>