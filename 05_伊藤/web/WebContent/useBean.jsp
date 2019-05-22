<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- EmpBean.javaにつなげる --%>
    <%-- webパッケージのEmpBeanクラスを使うよっていう定義 --%>
    <jsp:useBean id="emp" scope="request" class="web.EmpBean"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>UseBean</h1>
<%-- borderにしないと罫線がない --%>
<table border>
  <tr>
    <td>Name</td>
    <%-- リクエストオブジェクトに格納されている
   beanの中のプロパティー名がnameの値を取得している --%>
    <td><jsp:getProperty name="emp" property="name" /></td>
  <tr>
    <td>Age</td>
    <%-- リクエストオブジェクトに格納されている
   beanの中のプロパティー名がageの値を取得している --%>
    <td><jsp:getProperty name="emp" property="age" /></td>
    <%--setPropertyは値を書き換えられる --%>
  </tr>
</table>
</body>
</html>