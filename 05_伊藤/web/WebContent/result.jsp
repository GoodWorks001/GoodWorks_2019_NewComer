<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- ResultBean.javaにつなげる  --%>
<jsp:useBean id="result" class="web.ResultBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%-- servletで格納した値をキャッチ --%>
	<h1><%=request.getAttribute("name")%>さんの運勢
	</h1>
	<%--罫線付きのテーブル --%>
	<table border>
		<tr>
			<%-- --%>
			<td>金運</td>
			<%-- servletでresultに格納したmoneyをキャッチ --%>
			<td><jsp:getProperty property="money" name="result" /></td>
		<tr>
			<td>恋愛運</td>
			<%-- servletでresultに格納したloveをキャッチ --%>
			<td><jsp:getProperty property="love" name="result" /></td>
		<tr>
			<td>仕事運</td>
			<%-- servletでresultに格納したworkをキャッチ --%>
			<td><jsp:getProperty property="work" name="result" /></td>
		<tr>
			<td>健康運</td>
			<%-- servletでresultに格納したhealthをキャッチ --%>
			<td><jsp:getProperty property="health" name="result" /></td>
		<tr>
			<td>全体運</td>
			<%-- servletでresultに格納したtotalをキャッチ --%>
			<td><jsp:getProperty property="total" name="result" /></td>

		</tr>
</body>
</html>