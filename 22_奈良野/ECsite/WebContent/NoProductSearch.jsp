<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>検索ページ</title>
</head>
<body>
<h1><p align="center">検索</p></h1><br>
<form action="Search"method="POST">
<p align="center"><INPUT size="40" type="text" name="search"></p><br>
<p align="center">カテゴリ<select name="category">
<option></option>
<option value="1">神具</option>
<option value="2">飲み物</option>
<option value="3">寝具</option>
<option value="4">人間</option>
</select>
</p>
<p align="center"><input type="submit" value="検索">
</p>
</form>

<p align="center">検索結果がありません。
</body>
</html>