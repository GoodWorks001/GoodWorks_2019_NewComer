<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- CSS同機 -->
      <link rel="stylesheet" 
       type="text/css"
       href="PSmain.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<center>
<h1>検索</h1>

	<form action="http://localhost:8080/ec/kensaku" method="POST">
	<input type="text" name="p_name"><br><br><br>

	カテゴリ:

	<select name="category" size="1">
		<option value=""></option>
		<option value="1">家電</option>
		<option value="2">PC系</option>
		<option value="3">雑貨</option>
	</select>

	<input type = "submit" value = "検索">
</form>

<% String kanri = (String)session.getAttribute("flg"); %>
<% ArrayList<String> list = (ArrayList<String>)session.getAttribute("list"); %>
<!-- ここからテーブル記述 -->

<% if(list != null && list.size()>0){ %>
<table border = "1">
	<tr>
		<td>
			商品名
		</td>
		<td>
			価格
		</td>
		<td>
			詳細
		</td>
	</tr>

	<%for(int i=0; i<list.size();i+=3) {
		System.out.println("サイズは"+list.size()); %>


		<tr>
		<td>
			<%=list.get(i) %>
		</td>
		<td>
			<%=list.get(i+1) %>
		</td>
		<td>
			<form action = "result" method="post">
			<input type ="submit" value="詳細">
			<input type = "hidden" value="<%=list.get(i+2) %>" name="id">
			</form>
		</td>
	</tr>

		<%} %>

</table>
<!-- 何もしない -->
<%}%>
<br>


</center>
</html>