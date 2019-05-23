<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "javax.servlet.http.HttpSession,java.util.*,cart.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>確認画面</title>
</head>
<body>
<center>
<h1>購入してよろしいでしょうか？</h1>
	<table border = "1" cellspacing="0" cellpadding="10">
		<thead>
			<tr height = "40">
				<th>商品名</th>
				<th>単価</th>
				<th>数量</th>
			</tr>
		</thead>
		<% HttpSession sess = request.getSession(false); %>
		<% HashMap <String,Integer[]>hp = (HashMap)sess.getAttribute("cart");%>
		<% Iterator it = hp.keySet().iterator(); %>
		<% Integer [] info = {0,0}; %>
<%-- 		<% getTable gt = new getTable(); %> --%>
		<% int total = 0; %>
		<% while(it.hasNext()) { %>
			<% String key = (String)it.next(); %>
			<% info = hp.get(key);%>
		<tbody>
			<tr height = "40">
				<td><%= key%></td>
				<td>￥
				<%= info[1]%>
				</td>
				<td><%= info[0]%></td>
			</tr>
		</tbody>
		<% total += info[1] * info[0]; %>
		<% } %>
		<tbody>
			<tr height = "40">
				<th colspan="2">消費税</th>
				<td>￥
				<%=Math.round(total * 0.08)%>
				</td>
			</tr>
		</tbody>
		<tbody>
			<tr height = "40">
				<th colspan="2">合計金額</th>
				<td>￥
				<%=Math.round(total * 1.08)%>
				</td>
			</tr>
		</tbody>
	</table><br>

<form action= "confirm" method = "post">
<a href = "confirm"><input type = "submit" value = "はい"></a>
</form><br>
<a href = "Search.jsp"><input type = "submit" value = "いいえ"></a>

</center>
</body>
</html>