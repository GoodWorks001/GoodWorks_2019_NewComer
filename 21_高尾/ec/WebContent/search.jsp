<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品検索画面</title>
</head>
<body>
<form method="POST" action="http://localhost:8080/ec/search">
<center>
<h1>検索</h1>
<input type ="text" name="kensaku">
<p>カテゴリ
<!-- カテゴリ一覧を作成 -->
<select name="category">
		<option selected value="null"> </option>
		<option value="1">食品</option>
		<option value="2">家電</option>
		<option value="3">家具</option>
		<option value="4">生活用品</option>
		<option value="5">その他</option>
</select>
</p>
<input type ="submit" name="kenbo" value="検索">


</center>
</form>

<%
String flg = (String)session.getAttribute("z");
%>
<form action = "http://localhost:8080/ec/search" method="post">
<center>
<%if(flg == "true"){ %>
	<!-- まだリストを取得していないので何もしない -->
<%}else{ %>
	<!--  リストを取得したのでテーブルの表示 -->
	<%ArrayList<String> list = (ArrayList)session.getAttribute("list"); %>
	<table border="1">
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
	<%for(int i = 0; i<list.size(); i+=3){ %>
		<tr>
			<td>
				<%=list.get(i) %>
			</td>
			<td>
				<%=list.get(i + 1) %>
			</td>
			<td>
				<button type="submit" name="syosai" value ="<%=list.get(i+2)%>" >詳細</button>
			</td>
		</tr>
	<%} %>
	</table>
<%} %>
</center>
</form>
</body>
</html>