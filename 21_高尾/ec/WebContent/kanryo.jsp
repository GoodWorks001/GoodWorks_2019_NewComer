<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入完了画面</title>
</head>
<body>
<form action ="/ec/kanryo" method="post">
<center>
<h1>お買い上げありがとうございました!</h1>

<table align="center">
<tr><td>
<button type="submit" name="logout" value="logout">ログアウト</button>
</td><td>
<button type="submit" name="back" value="back">買い物を続ける</button>
</td></tr>
</table>

</center>
</form>
</body>
</html>