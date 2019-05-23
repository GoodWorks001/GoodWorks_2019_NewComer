<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="result" scope="request" class="web1.ResultBean"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Time.</title>
</head>
<body>
<h1><%= request.getParameter("name") %>さんの運勢</h1>

<table border=1>
<tr>
    <td>金運</td>
    <td><jsp:getProperty name="result" property="money"/></td>
</tr><tr>
    <td>恋愛運</td>
    <td><jsp:getProperty name="result" property="love"/></td>
</tr><tr>
    <td>仕事運</td>
    <td><jsp:getProperty name="result" property="work"/></td>
</tr><tr>
    <td>健康運</td>
    <td><jsp:getProperty name="result" property="health"/></td>
</tr><tr>
    <td>全体運</td>
    <td><jsp:getProperty name="result" property="total"/></td>
</tr>
</table>
</body>
</html>