<%@page import="web.detailBean"%>
<%@page import="web.SearchLogic"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>検索ページ</title>
</head>
<body>

  <%
    //セッションから登録したアレイリストを取得
    ArrayList<String> List = (ArrayList<String>) session.getAttribute("List");
  %>
  <h1>
    <p align="center">検索</p>
  </h1>
  <br>
  <form action="Search" method="POST">
    <p align="center">
      <INPUT type="text" size="40" name="search">
    </p>
    <br>
    <p align="center">
      カテゴリ<select name="category">
        <option value=""></option>
        <option value="1">神具</option>
        <option value="2">飲み物</option>
        <option value="3">寝具</option>
        <option value="4">人間</option>
      </select>
    </p>
    <p align="center">
      <input type="submit" value="検索">
    </p>
  </form>
  <table border="1" width="500" cellspacing="0" align="center"
    cellpadding="5" bordercolor="black">

    <tr>
      <th>商品名</th>
      <th>値段</th>
      <th>詳細</th>
    </tr>
    <tr>
      <%
        for (int i=0;i<List.size();i+=3) {
      %>

    <tr>
      <td><%=List.get(i)%></td>
      <td>&yen;<%=List.get(i+1)%></td>
      <form action="detailservlet" method="POST">
        <input type="hidden" value="<%=List.get(i+2)%>" name="id">
        <td><input type="submit" value="詳細"></td>
      </form>

    </tr>
    <% } %>

</body>
</html>