<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>転送されたよ</title>
</head>
<body>

<h1>ごちそうさまです。</h1>

<!-- getメソッドで値を取得  -->
sessionで送られたnameは「<%= session.getAttribute("name") %>」
requestで送られたnameは「<%= request.getAttribute("age") %>」

</body>
</html>