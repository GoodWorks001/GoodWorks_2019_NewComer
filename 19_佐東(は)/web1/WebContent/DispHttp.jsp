<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title here!</title>
</head>
<body>

<h1>ごちとうたまでちたっ!</h1>
<%--JSP内での書き方 --%>
sessionで送られたname は「<%= session.getAttribute("name") %>」
requestで送られたageは「<%= request.getAttribute("age") %>」

</body>
</html>