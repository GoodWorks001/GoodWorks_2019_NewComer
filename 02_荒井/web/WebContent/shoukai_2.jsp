<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>商品紹介2</title>
</head>
<body>
<h1><p align="center">商品紹介</p></h1>

<image src= "god.jpg"align="left">
<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="black">
<tr>
<td>商品名</td>
<td>GOD</td>
</tr>
<tr>
<td>カテゴリ</td>
<td>非売品</td>
</tr>
<tr>
<td>価格</td>
<td>\10</td>
</tr>
<tr>
<td>在庫</td>
<td>1000</td>
</tr>
<tr>
<td>商品紹介</td>
<td>あ～、僕売り物だったんですね～。知らなかったな～。</td>
</tr>
</table></br>
<p >個数<select name="category">
<option value="個数1">1</option>
<option value="個数2">2</option>
<option value="個数1000">1000</option>
</p>

<input type="button" value="カートへ" onClick="location.href='cart.jsp'">
<input type="button" value="戻る" onClick="location.href='kensaku1.jsp'">









</body>
</html>