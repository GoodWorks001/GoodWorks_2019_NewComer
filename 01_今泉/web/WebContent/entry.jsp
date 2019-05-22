<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>占いアプリケーション</h1>

<%-- form内を指定したURL（サーブレット）に渡す --%>
<form action="http://localhost:8080/web/Fortune" method="post">
<p>氏名<input type ="text" name="name"></p>
生年月日
<select name ="year">
      <option></option>
      <% for(int i=1900;i<2019;i++) {%>
      <option><%= i %> </option>
      <% } %>

    </select>

年
 <select name="month">
      <option></option>
      <% for(int x=1;x<13;x++){ %>
      <option><%= x %></option>
      <% } %>
    </select>

月 <select name="date">
      <option></option>
      <% for(int y=1;y<32;y++){ %>
      <option><%= y %></option>
      <% } %>
      </select>

日
<br>
<input type="submit" value="占う！">
</form>




</body>
</html>