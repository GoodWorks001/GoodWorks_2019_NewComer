<%@page import="web.detailBean"%>
<%@ page import="web.cartBean"%>
<%@ page import="web.cartDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認</title>
</head>
<body>

<%
    //セッションから登録したアレイリストを取得
    ArrayList<detailBean> cartList = (ArrayList<detailBean>) session.getAttribute("cart2");
	ArrayList<Integer> koslist = (ArrayList)session.getAttribute("cart3");

  %>

<h1><p align="center">購入してよろしいでしょうか？？</p></h1><br>

<table border="1" width="500" cellspacing="0" align="center"
    cellpadding="5" bordercolor="black">
    <tr>
      <th>商品名</th>
      <th>単価</th>
      <th>数量</th>
    </tr>
    <tr>

      <% int total = 0; %>
     <%
        for (int i=0;i<cartList.size()||i<koslist.size();i++) {
      %>

      <td><%=cartList.get(i).getP_name()%></td>
      <td>&yen;<%=cartList.get(i).getPrice()%></td>
      <td><%=koslist.get(i) %></td>
      <%--合計金額の計算 --%>
		<% total = total + cartList.get(i).getPrice()*koslist.get(i);%>
    </tr>
    <% } %>

    <tr>
      <th colspan="2">消費税</th>
      <%--消費税を計算し表示 --%>
		<% int zei = (int)(total * 0.08); %>
      <td>&yen;<%=zei %></td>
	</tr>

    <tr>
      <th colspan="2">合計金額</th>
      <td>&yen;<%= total + zei%></td>
    </tr>
  </table>

<div align="center">
<table><tr>
<td>
<form action = "UpDateServlet" method="POST">
<input type="submit" value="はい">
</form>
</td>
<td>
<form action = "ProductSearch.jsp">
<input type="submit"  value="いいえ">
</form>
</td>

</tr></table>
</div>
</body>
</html>