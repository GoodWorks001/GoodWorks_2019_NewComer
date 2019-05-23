<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
<title>占い</title>
</head>
<body>

<h1>占いアプリケーション</h1>

<form action = "http://localhost:8080/web/six" method='POST'>


      氏名
      <input type = "text" name = "name">                    <!-- textbox -->

<br><br>


  生年月日

     <%--年を1850年から2019年までを表示できるようにするfor文 --%>
       <select name="year">
       <% for(int x = 1850; x < 2019; x++) { %>
       <option value = "<%= x %>"><%= x %></option>         <%--プルダウンメニュー --%>
       <% } %>
       </select>年



<%--月を1月から12月までを表示できるようにするfor文 --%>
       <select name = "month">
       <% for(int y = 1; y < 12; y++){ %>
        <option value = "<%= y %>"><%= y %></option>         <%--プルダウンメニュー --%>
        <% } %>
       </select>月



<%--日を1日から31日までを表示できるようにするfor文 --%>
       <select name = "date">
       <% for(int z = 1; z < 31; z++){ %>
        <option value = "<%= z %>"><%= z %></option>          <%--プルダウンメニュー --%>
        <% } %>
       </select>日


       <br><br>

<%--占うボタン --%>

<input type = "submit" value = "占う">
</form>




</body>
</html>