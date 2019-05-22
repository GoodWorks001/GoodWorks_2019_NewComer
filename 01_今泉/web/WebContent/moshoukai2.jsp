<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品紹介1</title>
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
<div>個数<select name="category">
<option></option>
<% for(int i=1; i<1001; i++){ %>
<option value="i"><%= i %></option>
<% } %>
</div></br>

<input type="button" value="カートへ" onClick="location.href='mocart.jsp'">
<input type="button" value="戻る" onClick="location.href='mokensakuresult.jsp'">

</body>
</html>