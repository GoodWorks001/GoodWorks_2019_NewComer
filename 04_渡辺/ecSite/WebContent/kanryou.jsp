<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="sample.css">
<title>購入完了画面</title>
</head>
<body>
  <h1>お買い上げありがとうございました！</h1>
  <div style="display: inline;">
    <form action="KensakuServlet" style="display: inline;" method="post">
      <input type="submit" value="買い物を続ける">
    </form>
    <form action="LogoutServlet" style="display: inline;" method="post">
      <input type="submit" value="ログアウト">
    </form>
  </div>
</body>
</html>