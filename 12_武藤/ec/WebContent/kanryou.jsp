<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入完了画面</title>
</head>
<body>
<h1>お買い上げありがとうございました!</h1><br>
<br>
<div align="center">
<form action = "Kensaku.jsp">
<input type="submit" value="続ける">
</form>

<form action="http://localhost:8080/ec/logout" method="post">
<input type="submit" value="ログアウト">
</form>

</div>
</body>
</html>