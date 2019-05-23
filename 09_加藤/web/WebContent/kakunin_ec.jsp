<%@page import="java.util.ArrayList"%>
<%@page import="web.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>購入確認画面</title>
</head>
<body>

<% ArrayList<String> listname = (ArrayList<String>)session.getAttribute("cart_name"); %>
<% ArrayList<Integer> listprice = (ArrayList<Integer>)session.getAttribute("cart_price"); %>
<% ArrayList<Integer> listorder = (ArrayList<Integer>)session.getAttribute("cart_order"); %>
<% int tax = 0;
   int total = 0;
%>
<h1><p align="center">購入してよろしいでしょうか？</p></h1><br>
<form action="http://localhost:8080/web/kakunin" method="POST">
<table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
<tr>
    <th>商品名</th>
    <th>単価</th>
    <th>数量</th>
</tr>
<tr>
     <% for(int i=0; i<listname.size(); i++){
     %>
     <td><%= listname.get(i) %></td>
     <td><%= listprice.get(i) %>円</td>
     <td><%= listorder.get(i) %>
         <% total += (listprice.get(i) * listorder.get(i)); %>
     </td>
</tr>

<% } %>

<tr>
    <th colspan="2">消費税</th>
    <td><% tax = (int)(total * 0.08); %>
        <%= tax %>円</td>
</tr>
<tr>
    <th colspan="2">合計金額</th>
    <td><%= tax + total %>円
    </td>
</tr>
</table>
</form>

<div align="center">
<table>
<tr>
    <td>
        <form action = "http://localhost:8080/web/kensaku" method="POST">
        <input type="submit" align="center" value="いいえ">
        </form>
    </td>
    <td>
         <form action = "http://localhost:8080/web/kakunin" method="POST">
              <input type="submit" value="はい">
         </form>
    </td>
</tr>
</table>
</div>
</body>
</html>