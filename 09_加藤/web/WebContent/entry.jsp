<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占いアプリ</title>
</head>
<body>
<h1>占いアプリケーション</h1>
<%-- post指定して、doPostを使用することを宣言している --%>
<form action="http://localhost:8080/web/fortune" method="POST">

   <table>
       <tr>
           <th>氏名</th>
           <%-- テキストタイプの空欄バーの作成 --%>
           <td><input type="text" name="name"></td>
       </tr>

       <tr>
           <th>生年月日</th>
           <td>
           <select name="year">
           <option>
           <%  %>
           </option>
           <%-- 年をfor文により表している --%>
           <% for(int i=1900; i<=2019; i++){ %>
           <option>
           <%= i%>
           </option>
           <% } %>
           </select>年

           <select name="month">
           <option>
           <%  %>
           </option>
           <%-- 月をfor文により表している --%>
           <% for(int i=1; i<=12; i++){ %>
           <option>
           <%= i%>
           </option>
           <% } %>
           </select>月

           <select name="date">
           <option>
           <%  %>
           </option>
           <%-- 日をfor文により表している --%>
           <% for(int i=1; i<=31; i++){ %>
           <option>
           <%= i%>
           </option>
           <% } %>
           </select>日
           </td>
       </tr>
       <tr>
           <%-- ボタンがタップされたら入力データを送信する --%>
           <td><input type="submit" value="占う"></td>
       </tr>
   </table>
</form>
</body>
</html>