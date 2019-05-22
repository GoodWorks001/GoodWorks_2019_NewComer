<%@page import="web.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認</title>
</head>
<body>

	<h1>
		<p align="center">購入してよろしいでしょうか??</p>
	</h1>
	<br>

	<%
		ArrayList<ProductBean> array = (ArrayList<ProductBean>) session.getAttribute("cart");
		int sum = 0; //合計金額
		int price = 0;
		int count = 0;
		int shouhizei = 0;
	%>


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
				//リストからインスタンス取り出す
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
			sum = sum + (price * count); //合計金額の計算(税抜き)
		%>

		<%
			}
			shouhizei = (int) (sum * 0.08);    //税だけ計算
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

	<br>


	<div align="center">
		<table>
			<tr>
				<td>
					<form action="Kensaku" method="post">
						<input type="submit" align="center" value="いいえ">
					</form>
				</td>


				<td>
					<form action="Kounyu" method="post">
						<input type="submit" value="はい">
					</form>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>