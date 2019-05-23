<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:useBean id="result" scope="request" class="web.ResultBean"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占いアプリ</title>
</head>
<body>
<h1><%= request.getParameter("name") %>さんの運勢</h1>
<table border>
    <tr>
        <th>金運</th>
        <%-- リクエストオブジェクトに格納されている
        beanの中のプロパティー名がmoneyの値を取得している
         --%>
        <td><jsp:getProperty name="result" property="money"/></td>
     </tr>

     <tr>
         <th>恋愛運</th>
         <%-- リクエストオブジェクトに格納されている
        beanの中のプロパティー名がloveの値を取得している
         --%>
         <td><jsp:getProperty name="result" property="love"/></td>
     </tr>

     <tr>
         <th>仕事運</th>
         <%-- リクエストオブジェクトに格納されている
        beanの中のプロパティー名がworkの値を取得している
         --%>
         <td><jsp:getProperty name="result" property="work"/></td>
     </tr>

     <tr>
         <th>健康運</th>
         <%-- リクエストオブジェクトに格納されている
        beanの中のプロパティー名がhealthの値を取得している
         --%>
         <td><jsp:getProperty name="result" property="health"/></td>
     </tr>

     <tr>
         <th>全体運</th>
         <%-- リクエストオブジェクトに格納されている
        beanの中のプロパティー名がtotalの値を取得している
         --%>
         <td><jsp:getProperty name="result" property="total"/></td>
     </tr>

</table>
</body>
</html>