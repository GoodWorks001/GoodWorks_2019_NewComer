<%@page import="ec.Product"%>
<%@page import="ec.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		HttpSession ses = request.getSession(true);
		ArrayList<Category> catlist = new ArrayList<Category>();
		catlist = (ArrayList<Category>) ses.getAttribute("CATLIST");
		ArrayList<Product> plist = new ArrayList<Product>();
		plist = (ArrayList<Product>) session.getAttribute("PLISIT");
	%>
	<form action="KensakuServlet" method="post">
		<h1>
			<p align="center">検索</p>
		</h1>
		<br>
		<p align="center">
			<input type="text" name="kensaku">
		</p>
		<br>
		<p align="center">
			カテゴリ<select name="category">
				<option value=""></option>
				<%
					for (int i = 0; i < catlist.size(); i++) {
						Category cat = new Category();
						cat = catlist.get(i);
				%>
				<option value="<%=cat.getCat_id()%>"><%=cat.getCat_name()%></option>
				<%
					}
				%>
			</select>
		</p>
		<p align="center">
			<input type="submit" value="検索">
		</p>
	</form>
	<%
		if (plist.size() == 0) {
	%>
	<p align="center">検索結果は0です</p>
	<%
		}
	%>
	<%
		if (plist.size() != 0) {
	%>
	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<%
			for (int i = 0; i < plist.size(); i++) {
					Product pro = new Product();
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