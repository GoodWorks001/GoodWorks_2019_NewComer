<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="web.ProductBean"%>
<%@page import="web.CategoryBean"%>
<%@page import="web.DAO2"%>
<%@page import="web.CateDAO"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<link rel="stylesheet" href="second.css">
<meta charset="UTF-8">
<title>カートページ</title>
</head>
<body>
<%

 ArrayList<ProductBean> cList = (ArrayList<ProductBean>)session.getAttribute("scart");

int sum =0;
int tax =0;
int count =0;
int price =0;






%>




<h1><div align="center">カート</div></h1><br>

<table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
<tr>
<th>商品名</th>
<th>単価</th>
<th>数量</th>
</tr>
<% for(int i=0; i<cList.size(); i++ ) {

	ProductBean pbean = cList.get(i);
	count = pbean.getBuy();
	price = pbean.getPro_price();

%>

<tr>
<td><%= pbean.getPro_name() %></td>
<td>￥<%= price %></td>
<td><%= count %></td>
</tr>

<% sum=sum+(count*price);




%>

<% }

tax =(int)(sum*0.08);

%>

<tr>
<th colspan="2">消費税</th>
<td>￥<%=tax %></td>
</tr>
<tr>
<th colspan="2">合計金額</th>
<td>￥<%=tax+sum %></td>
</tr>
</table>

<div align="center">
<table><tr>
<td>
<form action = "search.jsp">
<input type="submit" align="center" value="買い物を続ける">
</form>
</td>
<td>
<form action = "kakunin.jsp">
<input type="submit" value="購入">
</form>
</td>
</tr></table>
</div>
</body>
</html>