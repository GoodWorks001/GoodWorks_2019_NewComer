<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body "bgcolor="#99FFCC">
<h1>お買い上げありがとうございました!</h1><br>
<br>
<div align="center">
<form action = "Kensaku.jsp">
<input type="submit" value="続ける">
</form>

<form action="http://localhost:8080/iyada/logout" method="post">
<input type="submit" value="ログアウト">
</form>

</div>
</body>
</html>