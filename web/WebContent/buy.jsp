<%@page import="web.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入画面</title>
</head>

<body>
<h1><p align="center">購入してもよろしいでしょうか？</p></h1><br>
<table border="1"width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
<tr>
   <th>商品名</th>
   <th>単価</th>
   <th>数量</th>
</tr>

<%--商品情報を格納した配列を取得 --%>
<% ArrayList<ProductBean> list = (ArrayList)session.getAttribute("cart"); %>
<% int zei =0; %>
<% int total =0; %>
<% for(int i=0;i<list.size(); i++){   %>


<tr>
   <td><%= list.get(i).getPro_name()  %></td>
   <td><%= list.get(i).getPro_price()  %></td>
   <td><%= list.get(i).getKosuu() %></td>
</tr>
<% total = total + list.get(i).getPro_price()*list.get(i).getKosuu(); %>

<% } %>
<% zei = (int)(total*0.08); %>
<tr>
   <th colspan="2">消費税</th><td><%=zei %></td>
</tr>
<tr>
   <th colspan="2">合計金額</th><td><%=total + zei %></td>
</tr>

</table>

<div align="center">
<table><tr>
<td>
<form action="cart.jsp" >
<input type="submit" value="いいえ">
</form>
</td>
<td>
<form action="http://localhost:8080/web/finish" method="POST">
<input type="hidden" value="<%=total + zei %>" name="all">
<input type="submit" value="はい">
</form>
</td>
</tr></table>
</div>

</body>

</html>