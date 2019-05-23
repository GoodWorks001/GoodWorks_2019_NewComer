<%@page import="Search.ProductBean"%>
<%@page import="Search.CtBean"%>
<%@page import="Search.JDBC"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索</title>
</head>
<body style="text-align: center;">
<%
//セッションから登録したアレイリストを取得
ArrayList<CtBean> catlist = (ArrayList<CtBean>)session.getAttribute("CATLIST");
%>

<form action="KensakuServlet" method="POST">

		<h1>検索</h1>
		<input type="text" name="kensaku"><br> <br> <br>
		カテゴリ<select name="cat">
			<option></option>
			<%
			//fro文でアレイリスト文<option></option>を作成
			for(int i =0;i<catlist.size();i++){
				CtBean ctb = catlist.get(i);
			%>
			<option value="<%=ctb.getCat_id()%>"><%=ctb.getCat_name()%></option>
		<% }%>
		</select>

		<br> <br> <input type="submit" value="検索">
		</form>


<%
//セッションから登録したアレイリストを取得
ArrayList<ProductBean> prolist = (ArrayList<ProductBean>)session.getAttribute("PROLIST");
%>
		<% if(prolist != null) {%>

		<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">

		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<% for(int i=0; i< prolist.size(); i++){
			ProductBean pb = prolist.get(i);%>
		<tr>
			<td><%= pb.getPro_name() %></td>
			<td><%=pb.getPro_price() %></td>
			<td align="center"><form action="SyousaiServlet" method="post">
					<input type="hidden" name="pro_cd" value="<%= pb.getPro_id()%>">
					<input type="submit" value="詳細"></form></td>
		</tr>
		<%} %>
		</table>
		<% %>
		<%}else if(prolist ==null || prolist.size()<=0){ %>
		<p>検索結果は0です。
		<%} %>

</body>
</html>