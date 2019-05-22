<%@page import="web.detailBean"%>
<%@page import="web.SearchLogic"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="result" class="web.detailBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ProductDetails.css">
<meta charset="UTF-8">
<title>商品紹介</title>
</head>
<body>
<%
    //セッションから登録したアレイリストを取得
    ArrayList<String> cartList = (ArrayList<String>) session.getAttribute("cartList");
  %>
<h1 id="tag">商品紹介</h1>
<img id ="img" src= "<jsp:getProperty name="result" property="p_img" />">
<div  id="table">
<table>
<tr>
<td>
<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="black">
<tr>
<td>商品名</td>
<td><jsp:getProperty name="result" property="p_name" /></td>
</tr>
<tr>
<td>カテゴリ</td>
<td><jsp:getProperty name="result" property="cat_name" /></td>
</tr>
<tr>
<td>価格</td>
<td>&yen;<jsp:getProperty name="result" property="price" /></td>
</tr>
<tr>
<td>在庫</td>
<td><jsp:getProperty name="result" property="stock" /></td>
</tr>
<tr>
<td>商品紹介</td>
<td><jsp:getProperty name="result" property="p_msg" /></td>
</tr>
</table>
</td>

<td>
<form action="cartServlet"method="POST">

<div id="kosu">個数<select name="kosu">
<%
int num = ((Integer)session.getAttribute("zai"));
%>
<%for(int i=1;i<=num;i++){ %>
<option value=<%=i%>><%=i%>
</option>
<% }%>
</select>
<% int pcd = (Integer)session.getAttribute("pcd");%>
<input type="hidden"value="<%=pcd %>"name="pcd">
</div>
<input type="submit" id="cart" value="カートへ">

</form>
<input type="button" id="back" value="戻る"onclick="history.back()">
</td>

</tr>
</table>
</div>
</html>