<%@page import="web.CategoryBean"%>
<%@page import="web.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- 全体的な形は同じである --%>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<%-- セッションに登録したアレイリストを取得する --%>
<%-- 取得したアレイリストを変数に格納する --%>
<% ArrayList<ProductBean> alist = (ArrayList<ProductBean>)session.getAttribute("list"); %>
<% ArrayList<CategoryBean> catlist = (ArrayList<CategoryBean>)session.getAttribute("catlist"); %>
<form action="http://localhost:8080/web/kensaku" method="POST">
<h1 align="center">検索</h1><br>
<p align="center"><input type="text" size=40 name="text"></p><br>
<p align="center">カテゴリ<select name="category">

<%-- アレイリストから得た情報をリストの個数分ループする --%>
<%-- その情報をプルダウンで表示させる --%>
<option></option>
<%
	for(int i=0; i<catlist.size(); i++){
		CategoryBean cb = catlist.get(i);
%>
<option value="<%= cb.getCateid()%>"><%= cb.getCatename() %></option>

<% } %>

</select></p>

<p align="center"><input type="submit" value="検索" name="kensaku"></p>
</form>

<%-- 検索結果が表示されるのが以下の部分である --%>
<table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
<tr>
    <%-- 表示に必要なタイトルの表示 --%>
    <th>商品名</th>
    <th>価格</th>
    <th>詳細</th>
</tr>
<tr>

    	<%-- 検索結果の表示に必要なデータのみをアレイリストより取得して表示させるロジック --%>
    	<% for(int i=0; i<alist.size(); i++){
    		ProductBean pb = alist.get(i);
    	%>
		    <%-- ProductBeanに登録したgetNameメソッドを呼び出す --%>
		    <td align="center"><%= pb.getName() %></td>
		    <%-- ProductBeanに登録したgetPriceメソッドを呼び出す --%>
		    <td align="center"><%= pb.getPrice() %>円</td>
		    <td align="center"><form action="http://localhost:8080/web/shoukai" method="POST">
		   <%-- 非表示タイプのデータを送信する --%>
		   <input type="hidden" value="<%= alist.get(i).getId() %>" name="shousai">
		    <%-- 詳細というボタンを作成する --%>
		    <button type="submit" onclick="btnLink()">詳細</button></td>
		<% } %>
</tr>
</form>
</table>
</body>
</html>