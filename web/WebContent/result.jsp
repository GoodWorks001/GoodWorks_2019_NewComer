<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
    
    <%--resultに入ってるrequest値を使えるように定義 --%>
    <jsp:useBean id="result" scope="request" class="web.ResultBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>運勢</title>
</head>
<body>

<h1><%= request.getParameter("name")  %>の運勢</h1>
<table border>
<tr>
    <td>金運</td>
    <%--リクエストオブジェクトに格納されているbean1のなかのプロパティ名がmoneyの値を取得している --%>
    <td><jsp:getProperty name="result" property="money"/></td>
</tr>
<tr>
    <td>恋愛運</td>
    <%--リクエストオブジェクトに格納されているbean1のなかのプロパティ名がloveの値を取得している --%>
    <td><jsp:getProperty name="result" property="love"/></td>
</tr>
<tr>
    <td>仕事運</td>
    <%--リクエストオブジェクトに格納されているbean1のなかのプロパティ名がworkの値を取得している --%>
    <td><jsp:getProperty name="result" property="work"/></td>
</tr>
<tr>
     <td>健康運</td>
     <%--リクエストオブジェクトに格納されているbean1のなかのプロパティ名がhealthの値を取得している --%>
     <td><jsp:getProperty name="result" property="health"/></td>
</tr>
<tr>
    <td>全体運</td>
    <%--リクエストオブジェクトに格納されているbean1のなかのプロパティ名がtotalの値を取得している --%>
    <td><jsp:getProperty name="result" property="total"/></td>
</tr>
</table>

</body>
</html>