<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%-- ResultBeanを使うよという定義 --%>
    <jsp:useBean id="result" scope="request" class="web.ResultBean"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 入力した値を取得している --%>
<h1><%= request.getParameter("name") %>さんの運勢</h1>

<%-- form内の値をサーブレットに渡す --%>
<form action="http://localhost:8080/web/FortuneServlet.java" method="post">

<table border>

 <tr>
  <td>金運</td>
  <%--setAtrributeで代入したresultの中のmoneyの値を取得 --%>
  <td><jsp:getProperty name="result" property="money"/></td>
 </tr>

<tr>
  <td>恋愛運</td>
  <%--setAtrributeで代入したresultの中のloveの値を取得 --%>
  <td><jsp:getProperty name="result" property="love"/></td>
 </tr>

 <tr>
  <td>仕事運</td>
  <%--setAtrributeで代入したresultの中のworkの値を取得 --%>
  <td><jsp:getProperty name="result" property="work"/></td>
 </tr>

 <tr>
  <td>健康運</td>
  <%--setAtrributeで代入したresultの中のhealthの値を取得 --%>
  <td><jsp:getProperty name="result" property="health"/></td>
 </tr>

 <tr>
  <td>全体運</td>
  <%--setAtrributeで代入したresultの中のtotalの値を取得 --%>
  <td><jsp:getProperty name="result" property="total"/></td>
 </tr>



</table>

</form>
</body>
</html>