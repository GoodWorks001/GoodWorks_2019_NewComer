<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>カート</title>
</head>
<body>
<h1><p align="center">カート</p></h1><br>

<table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
<tr>
<th>商品名</th>
<th>単価</th>
<th>数量</th>
</tr>
<tr>
<td>炊飯器</td>
<td>\14,800</td>
<td>1</td>
</tr>
<tr>
<td>GOD</td>
<td>\10</td>
<td>1</td>
</tr>
<tr>
<td>パソコン</td>
<td>\99,800</td>
<td>1</td>
</tr>
<tr>
<th colspan="2">消費税</th>
<td>\9,158</td>
</tr>
<tr>
<th colspan="2">合計金額</th>
<td>\123,768</td>
</tr>
</table>

<div align="center">
<table><tr>
<td>
<form action = "kensaku.jsp">
<input type="submit" align="center" value="買い物を続ける">
</form>
</td>
<td>
<form action = "kounyu.jsp">
<input type="submit" value="購入">
</form>
</td>
</tr></table>
</div>
</body>
</html>