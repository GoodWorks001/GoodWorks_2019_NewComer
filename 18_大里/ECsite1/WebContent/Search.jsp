<%@page import="search.SearchJDBCkekka"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
</head>
<body>
<center>
<h1>検索</h1>
<% HttpSession Session = request.getSession(false);%>
<% ArrayList<Integer> listprice = (ArrayList<Integer>)session.getAttribute( "price" );
ArrayList<String> listname = (ArrayList<String>)session.getAttribute( "name" );
ArrayList<Integer> listcd = (ArrayList<Integer>)session.getAttribute( "cd" );%>

<form action="Keyword" method = "post">
<input type = "text" name = "keyword">
<input type = "submit" value = "検索">
</form>

<% SearchJDBCkekka jd = new SearchJDBCkekka();%>
<% ArrayList<String> cat_name = jd.getCategoryName();%>
<form name = "form1" action="Search2" method="post">
<p>カテゴリー
	<%-- カテゴリ選んだら直接遷移する、ヒントからぱくったやつ--%>
<select name="category" onchange = "document.form1.submit();">
<option value="0"></option>
<% for(int i = 1; i <=cat_name.size();i++) {%>
	<option value="<%=i %>"><%=cat_name.get(i- 1)%></option>
<% } %>
</select></form><br>


</center>
</body>
</html>