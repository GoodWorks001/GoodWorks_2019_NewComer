<%@page import="ec.SearchBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@page import="ec.categoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--<jsp:useBean id="emp" scope="request" class="web.EmpBean" />--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品検索画面</title>
<link rel="stylesheet" type="text/css" href="/ECs/css/style.css">
</head>
<body>
	<% ArrayList<categoryBean> cat_list = (ArrayList<categoryBean>)session.getAttribute("catlist");%>
	<% ArrayList<SearchBean> item_list = (ArrayList<SearchBean>)session.getAttribute("itemlist");%>
	<%-- SearchBean sb= new SearchBean(); --%>


	<h1 align="center">検索</h1>
	<br>
	<form action="http://localhost:8080/ECs/searchresult"  method="POST">
	<p align="center">
		<input type="text"  size="40"  name="kensaku" >
	</p>
	<br>
	<p align="center">
		カテゴリ<select name="catkensaku">
		<option value=""></option>
		<% for(int i=0;i<cat_list.size();i++){
			categoryBean c = cat_list.get(i);
		%>
			<option value=<%=c.getCatID()%>><%=c.getCatName() %></option>
		<% } %>
		</select>
	</p>


	   <center><input type="submit" value="検索" ></center>
	   <br>

    </form>


	<table border="1"  width="500" cellspacing="0" align="center" cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<% int i = 0; %>
		<% if( item_list != null){ %>
		  <% for( i=0;i < item_list.size();i++){
			  SearchBean s = item_list.get(i);
		  %>
		<tr>
			<td><%= s.getName() %></td>
			<td><%= s.getPrice() %></td>
			<td align="center"><form action="http://localhost:8080/ECs/sinasyousai" method="POST">
			<input type="hidden" value=<%= s.getId()%> name="syousai">
			<input type="submit" value="詳細" >
			</form></td>
		</tr>
		  <% } %>
		</table>

		<% if(i==0){ %>
		   <table align="center">
		      <tr>
	            <td>検索結果がありません。</td>
	          </tr>
		   </table>
		  <% }  %>

		<% } %>
</body>
</html>