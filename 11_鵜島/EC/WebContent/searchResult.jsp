<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>

	<%@ include file="search.jsp"%>

	<div align="center">
		<table border=1 style = width:300px>
			<tr>
				<td style = width:150px align="center">商品名</td>
				<td style = width:75px align="center">価格</td>
				<td style = width:75px align="center">詳細</td>
			</tr>

			<%ArrayList<String> itemList = (ArrayList<String>)session.getAttribute("search"); %>

			<% for(int i = 0;i<itemList.size();i+= 3){ %>
			<tr>
				<!-- 商品名 -->
				<td style = width:150px align="center"><%=itemList.get(i)%></td>
				<!-- 価格 -->
				<td style = width:75px align="center"> &yen; <%=itemList.get(i + 1)%></td>
				<!-- 詳細 -->
				<td style = width:75px align="center">
					<form action="http://localhost:8080/EC/detail" method="post">
						<input type="hidden" name="pro_cd" value=<%= itemList.get(i + 2)%>>

						<input type="submit" value="詳細">
					</form>

				</td>
			</tr>
			<% } %>

		</table>
	</div>

</body>
</html>