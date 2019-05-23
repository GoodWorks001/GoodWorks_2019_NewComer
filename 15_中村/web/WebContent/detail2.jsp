<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.ResultSet,Detail.*,java.util.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品紹介</title>
</head>

<body>
<%-- getTable gt = new getTable();--%>
<% String [] rs = gt.getProductDetail(Integer.parseInt(request.getParameter("ID")));%>

<!-- <img src = "image/senpuki.png"> -->
<center>
	<h1>商品紹介</h1>
	<img src ="<%=rs[3] %>" width = "128" height= "128">
<form action = "cart" method = "POST"><br>

<table border = "1" cellspacing="0" cellpadding="10">
<tbody>
	<tr height = "40">
		<th>商品名</th>
		<td>
		<%= rs[0]%></td>
	</tr>
</tbody>
<tbody>
	<tr height = "40">
		<th>カテゴリ</th>
		<td><%= rs[5]%></td>
	</tr>
</tbody>
<tbody>
	<tr height = "40">
		<th>価格</th>
		<td>￥<%= rs[2]%></td>
	</tr>
</tbody>
<tbody>
	<tr height = "40">
		<th>在庫</th>
		<td><%= rs[1]%></td>
	</tr>
</tbody>
<tbody>
	<tr height = "40">
		<th>商品紹介</th>
		<td><%= rs[4]%></td>
	</tr>
</tbody>
</table>
		<br>
	<% HttpSession sess = request.getSession(false); %>
		<% int order = 0;%>
		<% HashMap <String,Integer[]>hm = (HashMap)sess.getAttribute("cart");%>
		<% if(hm.get("init") != null){ %>
			<% order = 0;%>
		<% } else { %>
			<% Integer [] info = hm.get(rs[0]);%>
				<% if(info == null) {%>
					<% order = 0;%>
				<% } else {%>
					<% order = info[0];%>
				<% }%>
		<% }%>

		個数<select id = "quantity" name = "quantity">
		<% for (int i = 0; i <= (Integer.parseInt(rs[1]) - order); i++){ %>
		<option value = <%= i%>><%= i %></option>
		<% } %>
 		</select>
 		<input type = "hidden" name = "pro_name" value = <%=rs[0] %> >
 		<input type = "hidden" name = "pro_price" value = <%= rs[2] %>>
		<input type = "submit" value = "カートへ">
	</form>
	<br>

	<a href = "Search.jsp"><input type = "button" value = "戻る"></a>
	</center>
</body>
</html>