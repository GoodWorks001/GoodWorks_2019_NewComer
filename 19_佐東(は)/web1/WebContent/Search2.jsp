<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="web1.CatBean"%>
<%@page import="web1.ProBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
	<%
		ArrayList<CatBean> catlist = (ArrayList<CatBean>) session.getAttribute("catlist");
		ArrayList<ProBean> plist = (ArrayList<ProBean>) session.getAttribute("prolist");
	%>
	<FORM method="POST" action="http://localhost:8080/web1/Search">
	<center>	<h1>検索</h1>
		<input type="text" name="kensaku"><br> <br> <br>
		カテゴリ<select name="cat">
			<option></option>
			<%
				for (int i = 0; i < catlist.size(); i++) {
					CatBean cb = catlist.get(i);
			%>
			<option value="<%=cb.getCat_id()%>"><%=cb.getCat_name()%></option>
			<%
				}
			%>
		</select> <br> <br> <input type="submit" value="SEARCH">
	</center></form>
<%
		if (plist.size() == 0) {
	%>
	<p align="center">検索結果0</p>
	<%
		}
	%>
	<%
		if (plist.size() != 0) {
	%>
	<br>
	<br>
	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<%
			for (int i = 0; i < plist.size(); i++) {
					ProBean pro = new ProBean();
					pro = plist.get(i);
		%>
		<tr>
			<td><%=pro.getPro_name()%></td>
			<td><%=pro.getPro_price()%></td>
			<td align="center">
			<form action="ShousaiServlet" method="post">
						<input type="hidden" name="pro_cd" value="<%=pro.getPro_cd()%>">
					<input type="submit" value="詳細">
				</form></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
</body>
</html>


