<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="pro" scope="session" class="ec.ProductBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品情報表示画面</title>
</head>
<body>
<h1 align="center">商品紹介</h1>
<form action = "http://localhost:8080/ec/cart" method = "post">
	<img src= "<jsp:getProperty name="pro" property="pro_image"/>"align="left">
	<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="black">
		<tr>
			<td>商品名</td>
			<td><jsp:getProperty name="pro" property="pro_name"/></td>
		</tr>
		<tr>
			<td>カテゴリ</td>
			<td><jsp:getProperty name="pro" property="cat_id"/></td>
		</tr>
		<tr>
			<td>価格</td>
			<td><jsp:getProperty name="pro" property="pro_price"/></td>
		</tr>
		<tr>
			<td>在庫</td>
			<td><jsp:getProperty name="pro" property="stock_no"/></td>
		</tr>
		<tr>
			<td>商品紹介</td>
			<td><jsp:getProperty name="pro" property="pro_msg"/></td>
		</tr>
	</table></br>
	<%--セッションに保存した在庫数 --%>
	<% int zaiko = (Integer)session.getAttribute("zaiko");%>
	<%--在庫に比例したセレクトボックスを画面に表示 --%>
	<div>個数<select name="kosu">
	<option value="1">1</option>
	<%if(zaiko >=11){ %>
		<option value="2">2</option>
		<option value="5">5</option>
		<option value="10">10</option>
		<option value="<%=zaiko%>"><%=zaiko %></option>
	<%}else if(zaiko >=6){ %>
		<option value="2">2</option>
		<option value="5">5</option>
		<option value="<%=zaiko%>"><%=zaiko %></option>
	<%}else{ %>
		<option value="<%=zaiko%>"><%=zaiko %></option>
	<%} %>
	</div></br>
<!-- 	次のサーブレットに値を渡すためのhiddenボックス作成 -->
	<input type = "hidden" value = "<jsp:getProperty name="pro" property="pro_name"/>" name = "name">
	<input type = "hidden" value = "<jsp:getProperty name="pro" property="pro_price"/>" name = "price">
	<input type = "hidden" value = "<jsp:getProperty name="pro" property="pro_id"/>" name = "id">
	<input type = "hidden" value = <%=zaiko %> name = "zaizaiko">
	<div>
	<input type = "submit" value = "カートへ">
	</div>
</form>
<div>
<form action = "Kensaku.jsp">
<input type = "submit" value = "戻る">
</form>
</div>
</body>
</html>