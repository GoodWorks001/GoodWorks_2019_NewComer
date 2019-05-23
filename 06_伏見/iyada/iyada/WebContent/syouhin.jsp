<%@page import="java.text.NumberFormat"%>
<%@page import="iyada.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="pro" scope="session" class="iyada.ProductBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品紹介ページ</title>
<link rel="stylesheet" type="text/css" href="/iyada/ec.css">
</head>
<body>
	<%
		NumberFormat nfNum = NumberFormat.getNumberInstance();
	%>
	<h1 align="center">商品紹介</h1>
	<form action="http://localhost:8080/iyada/cart" method="post">
		<img src="<jsp:getProperty name="pro" property="pro_image"/>"
			align="left" width="350" height="500">
		<table border="1" width="500" cellspacing="0" cellpadding="5"
			bordercolor="black">
			<%
				ProductBean p = (ProductBean) session.getAttribute("pro");
			%>
			<tr>
				<td>商品名</td>
				<td><jsp:getProperty name="pro" property="pro_name" /></td>
			</tr>
			<tr>
				<td>カテゴリ</td>
				<td><jsp:getProperty name="pro" property="cat_name" /></td>
			</tr>
			<tr>
				<td>価格</td>
				<td><%=nfNum.format(p.getPro_price()) %></td>
			</tr>
			<tr>
				<td>在庫</td>
				<td><jsp:getProperty name="pro" property="stock_no" /></td>
			</tr>
			<tr>
				<td>商品紹介</td>
				<td><jsp:getProperty name="pro" property="pro_msg" /></td>
			</tr>
		</table>
		</br>
		<%--セッションに保存した在庫数 --%>
		<%
			int zaiko = (Integer) session.getAttribute("zaiko");
		%>
		<%--在庫に比例したセレクトボックスを画面に表示 --%>
		<table>
			<tr>
				<td>
					<div>
						個数<select name="kosu">
							<option value="1">1</option>
							<%
								for (int i = 2; i <= zaiko; i++) {
							%>
							<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>

					</div>
				</td>
				<td>
					<!-- 	次のサーブレットに値を渡すためのhiddenボックス作成 --> <input type="hidden"
					value="<jsp:getProperty name="pro" property="pro_name"/>"
					name="name"> <input type="hidden"
					value="<jsp:getProperty name="pro" property="pro_price"/>"
					name="price"> <input type="hidden"
					value="<jsp:getProperty name="pro" property="pro_id"/>" name="ids">
					<input type="hidden" value=<%=zaiko%> name="zaizaiko">
					<div>
						<input type="submit" value="カートへ">
					</div>
				</td>
				</form>
				<td>
					<div>
						<form action="Kensaku.jsp">
							<input type="submit" value="戻る">
						</form>
					</div>
				</td>
			</tr>
		</table>
</html>