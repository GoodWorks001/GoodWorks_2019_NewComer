<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索ページ</title>
</head>
<body>
<h1><p align="center">検索</p></h1><br>
<p align="center"><INPUT type size="40"="text" neme="kensaku"></p><br>
<p align="center">カテゴリ<select name="category">
<option value="調理家電">調理家電</option>
<option value="非売品">非売品</option>
<option value="その他">その他</option>
</select>
</p>
<p align="center"><input type="button" value="検索" onClick="location.href=''">
</p>

<table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">

<tr>
<th>商品名</th>
<th>価格</th>
<th>詳細</th>
</tr>
<tr>
<td>炊飯器</td>
<td>\14,800</td>
<td align="center"><form action="shoukai_1.jsp"><input type="submit" value="詳細"></td>
</tr></form>
<tr>
<td>GOD</td>
<td>\10</td>
<td align="center"><form action="shoukai_2.jsp"><input type="submit" value="詳細"></td>
</tr></form>
<tr>
<td>パソコン</td>
<td>\99,800</td>
<td align="center"><form action="shoukai_3.jsp"><input type="submit" value="詳細"></td>
</tr></form>

</body>
</html>