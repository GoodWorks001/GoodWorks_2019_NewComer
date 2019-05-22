<%@page import="web.CategoryBean"%>
<%@page import="web.CateDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="first.css">
<title>検索ページ</title>
</head>
<body style="text-align: center;">
<%
//セッションから登録したアレイリストを取得
ArrayList<CategoryBean> catlist = (ArrayList<CategoryBean>)session.getAttribute("catlist");
System.out.println("こっち");

%>

   <form action="/web/Search" method="post">

		<h1>検索</h1>
		<input type="text" name="name"><br> <br> <br>
		カテゴリ<select name="aaaa">
			<option></option>
			<%System.out.println("ここ");
			//for文でアレイリスト文<option></option>を作成
			for(int i =0;i<catlist.size();i++){
				CategoryBean c = catlist.get(i);
			%>
			<option value="<%=c.getCat_id()%>"><%=c.getCat_name()%></option>
		<% System.out.println("こちら"); }%>

		</select>

		<br> <br> <input type="submit" value="検索">
		</form>




</body>
</html>