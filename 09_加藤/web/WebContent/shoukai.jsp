<%@page import="web.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品紹介画面</title>
</head>
<body>

<%-- 値を非表示して保持するための変数 --%>
<% int stock = 0;
   int price = 0;
   String name = "";%>

<%-- セッションに登録したアレイリストを取得する --%>
<%-- 取得したアレイリストを変数に格納する --%>
<% ArrayList<ProductBean> clist = (ArrayList<ProductBean>)session.getAttribute("clist"); %>
<% ArrayList<CategoryBean> dlist = (ArrayList<CategoryBean>)session.getAttribute("dlist"); %>

	<h1 align="center">商品紹介</h1>
	<form action="http://localhost:8080/web/shoukai" method="POST">

	<%-- アレイリストに格納している個数分ループしている --%>
	<%-- アレイリストの情報を取得している --%>
	<% for(int i=0; i<clist.size(); i++){
    		ProductBean pb = clist.get(i);
    %>

		<%-- 画像の出力用アレイリストの取得 --%>
		<image src="img/<%= pb.getImg() %>" align="left" width="300" height="300">

	<% } %>

		<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="black">
			<tr>
				<td>商品名</td>
				<%-- アレイリストの情報を取得している --%>
				<%-- 非表示送信用の変数に情報を格納している --%>
				<% for(int i=0; i<clist.size(); i++){
    				ProductBean pb = clist.get(i);
    				name = pb.getName();
            	%>
				<td align="left"><%= pb.getName() %></td>
				<% } %>
			</tr>
			<tr>

				<%-- アレイリストの情報を取得している --%>
				<td>カテゴリ</td>
				<% for(int i=0; i<clist.size(); i++){
					ProductBean pb = clist.get(i);
           		 %>
				<td align="left"><%= pb.getCatename() %></td>
				<% } %>
			</tr>
			<tr>

				<%-- アレイリストの情報を取得している --%>
				<%-- 非表示送信用の変数に情報を格納している --%>
				<td>価格</td>
				<% for(int i=0; i<clist.size(); i++){
    				ProductBean pb = clist.get(i);
    				price = pb.getPrice();
           		%>
				<td align="left"><%= pb.getPrice() %>円</td>
				<% } %>
			</tr>
			<tr>
				<%-- アレイリストの情報を取得している --%>
				<td>在庫</td>
				<% for(int i=0; i<clist.size(); i++){
    				ProductBean pb = clist.get(i);
            	%>
				<td align="left"><%= pb.getZaiko() %></td>
				<% } %>
			</tr>
			<tr>

				<%-- アレイリストの情報を取得している --%>
				<td>商品紹介</td>
				<% for(int i=0; i<clist.size(); i++){
    				ProductBean pb = clist.get(i);
            	%>
				<td align="left"><%= pb.getMsg() %></td>
				<% } %>
			</tr>
		</table>

		</form>


		<form action="http://localhost:8080/web/cart" method="POST">
		<div style="float:left;">
			個数<select name="order">
				<% for(int i=0; i<clist.size(); i++){
    				ProductBean pb = clist.get(i);
   				%>

				<%-- プルダウン用の変数に情報を格納している --%>
				<%
					int n = pb.getZaiko();
				%>
				<%-- 格納した個数分ループさせて、プルダウンで表示させている --%>
				<%
					for (int j = 1; j <= n; j++) {
				%>
				<option value=<%= j%>>
					<%= j%>
				</option>
				<%
					}
				%>

				<% } %>
			</select>
		</div>

     <div style="float:left;">
		<% for(int i=0; i<clist.size(); i++){
    				ProductBean pb = clist.get(i);
   		%>
   		<%-- 価格と商品名を非表示で値の送信 --%>
		<input type="hidden" value="<%= price %>" name="price">
		<input type="hidden" value="<%= name %>" name="name">
		<% } %>
		<input type="submit" value="カートへ" name="cart">
	</div>
	</form>

	<form action="http://localhost:8080/web/kensaku" method="POST">
		<input type="submit" value="戻る" name="back">
	</form>


</body>
</html>