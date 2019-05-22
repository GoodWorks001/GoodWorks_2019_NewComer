<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Web1パッケージのEmpBeanクラスを使用する定義です。 --%>
<jsp:useBean id="emp" scope="request" class="web1.EmpBean"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Do not Enter.</title>
</head>
<body>
<%--見出しです。 --%>
<h1>UseBean</h1>
<%--テーブルを使う癖をつける --%>>
<table border>

<tr>
    <td>Name</td>
          <%--リクエストオブジェクトに格納されている
          rxの中のプロパティー名がnameの値を取得している --%>
      <td><jsp:getProperty name="emp" property="name"/></td></tr>
<tr>
    <td>Age</td>
          <%--リクエストオブジェクトに格納されている
          rxの中のプロパティー名がageの値を取得している --%>
      <td><jsp:getProperty name="emp" property="age"/></td></tr>

</table>
</body>
</html>