<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.text.NumberFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品詳細画面</title>
</head>
<body>


<form method="POST" action="http://localhost:8080/ec/syosai">
<center>
<h1>商品詳細</h1>
</center>
<%NumberFormat nfCur = NumberFormat.getCurrencyInstance(); %>
<%String pass = (String) request.getAttribute("img"); %>
<img src=<%= pass %> align="left">

商品紹介
<table border="1" >
<tr>
<td>商品名</td><td>
<%out.println(request.getAttribute("name")); %>
</td>
</tr>
<tr>
<td>カテゴリ</td><td>
<%out.println(request.getAttribute("cat_name")); %>
</td>
</tr>
<tr>
<td>価格</td><td>
<%
String s =(String) request.getAttribute("price");
out.println(nfCur.format(Integer.parseInt(s)));
%>
</td>
</tr>
<tr>
<td>在庫数</td><td>
<%out.println(request.getAttribute("stock")); %>
</td>
</tr>
<tr>
<td>商品紹介</td><td>
<%out.println(request.getAttribute("msg")); %>
</td>
</tr>
</table>
<%
String stock =(String) request.getAttribute("stock");
%>
<!-- 個数を在庫数の文だけ選べるようにする -->
個数
<select name="kosuu">
		<%
		for(int i=1;i<= Integer.parseInt(stock); i++){
			out.println("<option value=" + i + ">" + i+ "</option>");
		}
		%>
</select>
<button type="submit" name="cart" value="cart">カートへ</button>
<button type="submit" name="back" value="back">戻る</button>
</form>
</body>
</html>