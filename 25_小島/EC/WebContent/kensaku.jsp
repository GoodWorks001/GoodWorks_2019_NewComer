<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="result" class="ec.productbean" scope="request"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索ページ</title>
</head>
<body>



<h1><p align="center">検索</p></h1><br>
<p align="center"><INPUT type size="40"="text" neme="search"></p><br>


<p align="center">カテゴリ<select name="category">
<option value="サンプル1"></option>
<option value="サンプル2">調理家電</option>
<option value="サンプル3">家電</option>
</select>
</p>
<form action ="searchServlet" method ="POST">
<p align="center"><input type="submit" value="検索" >
</p>

</form>




</body>
</html>