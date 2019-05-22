<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="sample.css">
<title>ログイン画面</title>
</head>
<body>

  <h1>ログイン</h1>

  <%
  String msg = (String)request.getAttribute("msg");
  System.out.println("msg："+msg);
    if(msg == null){
    	msg = "";
    }
  %>
  <p style="color: red"><%= msg %></p>

  <form action="LoginServlet" method="post">
    <table align="center">
      <tr>
        <td>名前</td>
        <td><input type="text" name="logName"></td>
      </tr>
      <tr>
        <td>パスワード</td>
        <td><input type="password" name="logPW"></td>
      </tr>
    </table>
    <input type="submit" value="LOGIN">
  </form>
</body>
</html>