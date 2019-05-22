<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
	<h1 align="center">商品紹介</h1>
	<form action="/Ex/syousai" method="Post">
		<h3 align="right"><%="ログイン中：" + session.getAttribute("login_name")%></h3>
		<%
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();
			String pass = (String) request.getAttribute("img");
			String stock = (String) request.getAttribute("stock");
		%>
		<table border="0">
			<tr>
				<td>
					<table border="0">
						<tr>
							<td><img src=<%=pass%>></td>
						</tr>
					</table>
				</td>
				<td>
					<table border="1" width="500" cellspacing="0" cellpadding="5"
						bordercolor="black">
						<tr>
							<td width="50">商品名</td>
							<td width="200">
								<%
									out.println(request.getAttribute("name"));
								%>
							</td>
						</tr>
						<tr>
							<td>カテゴリー</td>
							<td>
								<%
									out.println(request.getAttribute("cat_name"));
								%>
							</td>
						</tr>
						<tr>
							<td>価格</td>
							<td>
								<%
									String s = (String) request.getAttribute("price");
									out.println(nfCur.format(Integer.parseInt((s))));
								%>
							</td>
						</tr>
						<tr>
							<td>在庫</td>
							<td>
								<%
									out.println(stock);
								%>
							</td>
						</tr>
						<tr>
							<td>商品紹介</td>
							<td>
								<%
									out.println(request.getAttribute("msg"));
								%>
							</td>
						</tr>
					</table>
					<table border="0">
						<tr>
							<td><br><% if(Integer.parseInt(stock) != 0){ %>
							 個数 <select name="kosuu">
									<%
 										for (int i = 1; i <= Integer.parseInt(stock); i++) {
 											out.println("<option value=" + i + ">" + i + "</option>");
 										}
									%>
									<% } else{out.println("購入できません");};%>
							</select></td>
							<td><br> <% 	if (Integer.parseInt(stock) != 0)
								out.print("<button type=\"submit\" name=\"next\" value=\"cart\">カートへ</button></td>");
								%>
							<td><br>
								<button type="submit" name="back" value="back">戻る</button></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>