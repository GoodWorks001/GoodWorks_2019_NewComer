<%@page contentType="text/html;charset=Windows-31J" %>
<jsp:useBean id="emp" scope="request" class="web.EmpBean"/>
<%--webパッケージのempbeanクラスを使う定義 --%>
<html>
<body>
<h1>UseBean</h1>
<table border>
<tr>
<td>Name</td>

<%--リクエストオブジェクトに格納されているbean野中のプロパティ名がnameの値をしゅとくしている --%>
<td><jsp:getProperty name="emp" property="name"/></td>
</tr>
<tr>
<td>Age</td>

<%--リクエストオブジェクトに格納されているbean野中のプロパティ名がageの値をしゅとくしている --%>
<td><jsp:getProperty name="emp" property="age"/></td>
</tr>
</table>
</body>
</html>