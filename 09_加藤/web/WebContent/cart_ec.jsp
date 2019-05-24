<%@page import="java.util.ArrayList"%>
<%@page import="web.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>カート</title>
</head>
<body>

<%-- セッションに登録した商品名用のアレイリストを取得する --%>
<%-- 取得したアレイリストを変数に格納する --%>
<% ArrayList<String> listname = (ArrayList<String>)session.getAttribute("cart_name"); %>
<%-- セッションに登録した金額用のアレイリストを取得する --%>
<%-- 取得したアレイリストを変数に格納する --%>
<% ArrayList<Integer> listprice = (ArrayList<Integer>)session.getAttribute("cart_price"); %>
<%-- セッションに登録した購入個数用のアレイリストを取得する --%>
<%-- 取得したアレイリストを変数に格納する --%>
<% ArrayList<Integer> listorder = (ArrayList<Integer>)session.getAttribute("cart_order"); %>
<%-- 合計金額用と消費税用の変数を初期化している --%>
<% int tax = 0;
   int total = 0;
%>
<h1><p align="center">カート</p></h1><br>
<form action="http://localhost:8080/web/cart" method="POST">
<table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
<tr>
    <th>商品名</th>
    <th>単価</th>
    <th>数量</th>
</tr>
<tr>
     <% for(int i=0; i<listname.size(); i++){
     %>
     <%-- それぞれのアレイリストから値を取得する --%>
     <td><%= listname.get(i) %></td>
     <td><%= listprice.get(i) %>円</td>
     <td><%= listorder.get(i) %>
         <%-- 商品の価格と購入個数を掛け算し、得られた結果を変数に格納している --%>
         <% total += (listprice.get(i) * listorder.get(i)); %>
     </td>
</tr>

<% } %>

<tr>
    <th colspan="2">消費税</th>
    <td>
    <%-- 消費税のみの計算を行うロジック --%>
    <% tax = (int)(total * 0.08); %>
        <%= tax %>円</td>
</tr>
<tr>
    <%-- 消費税込みの計算を行うロジック --%>
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
        <form action = "kensaku_ec.jsp">
        <input type="submit" align="center" value="買い物を続ける">
        </form>
    </td>
    <td>
         <form action = "kakunin_ec.jsp">
              <input type="submit" value="購入">
         </form>
    </td>
</tr>
</table>
</div>
</body>
</html>