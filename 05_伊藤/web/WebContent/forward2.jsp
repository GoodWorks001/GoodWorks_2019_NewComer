<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<body>
<jsp:forward page ="destination2.jsp">
<%--param2にnameとvalreを格納 --%>
<jsp:param name="param2" value="ABCDE"/>
</jsp:forward>
</body>
</html>