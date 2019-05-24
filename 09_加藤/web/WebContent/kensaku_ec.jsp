<%@page import="web.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>検索ページ</title>
</head>
<body>

<%-- セッションに登録したアレイリストを取得する --%>
<%-- 取得したアレイリストを変数に格納する --%>
<% ArrayList<CategoryBean> list = (ArrayList<CategoryBean>)session.getAttribute("catlist"); %>

<h1><p align="center">検索</p></h1><br>

<form action="http://localhost:8080/web/kensaku" method="POST">

<p align="center"><input type="text" size="40" name="text"></p><br>
<p align="center">カテゴリ<select name="category">
<%-- アレイリストから得た情報をリストの個数分ループする --%>
<%-- その情報をプルダウンで表示させる --%> %>
<option></option>
	<% for(int i=0; i<list.size(); i++){
		CategoryBean cb = list.get(i);
	%>
	<option value="<%=cb.getCateid()%>"><%=cb.getCatename()%></option>
	<% } %>

</select>
</p>
<p align="center"><input type="submit" value="検索" name="kensaku">
</p>

</form>
</body>
</html>