<%@page import="ec.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		ArrayList<ProductBean> array = (ArrayList<ProductBean>) session.getAttribute("cart");

		int sum = 0;
		int price = 0;
		int count = 0;
		int shouhizei = 0;
	%>

	<h1>
		<p align="center">カート</p>
	</h1>
	<br>

	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>数量</th>
		</tr>

		<%
			for (int i = 0; i < array.size(); i++) {
				ProductBean pro = array.get(i);
				price = pro.getPrice();
				count = pro.getBuy();
		%>
		<tr>
			<td><%=pro.getName()%></td>
			<td><%=price%></td>
			<td><%=count%></td>
		</tr>

		<%
			sum = sum + (price * count);
		%>

		<%
			}
			shouhizei = (int) (sum + 0.08);
		%>

		<tr>
			<th colspan="2">消費税</th>
			<td>￥<%=shouhizei%></td>
		</tr>

		<tr>
			<th colspan="2">合計金額</th>
			<td>￥<%=sum + shouhizei%></td>
		</tr>

	</table>

	<div align="center">
		<table>
			<tr>
				<td>
					<form action="kensaku" method = "post">
						<input type="submit" align="center" value="買い物を続ける">
					</form>
				</td>

				<td>
					<form action="kounyuu.jsp">
						<input type="submit" value="購入">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>