<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import = "java.util.ArrayList"  import = "JDBC_SR" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
</head>
<body>
<center>
<h1>はじめてのPショップへようこそ</h1>
<h1>検索</h1>
<% HttpSession session = request.getSession(false);%>
<% ArrayList<Integer> listprice = (ArrayList<Integer>)session.getAttribute( "price" );
ArrayList<String> listname = (ArrayList<String>)session.getAttribute( "name" );
ArrayList<Integer> listcd = (ArrayList<Integer>)session.getAttribute( "cd" );%>

<% if(listcd.size() < 1){ %>
<h3>検索結果がありません</h3>
<% }%>

<form action="Keyword" method = "post">
<input type = "text" name = "keyword">
<input type = "submit" value = "検索">
</form>

<% JDBC_SR jd = new JDBC_SR(); %>
<% ArrayList<String> cat_name = jd.getCategoryName();%>
<form name = "form1" action="Search1" method="post">
<p>カテゴリー
<select name="category" onchange = "javascript:document.form1.submit();">
<option value="0"></option>
<% for(int i = 1; i <=cat_name.size();i++) {%>
	<option value="<%=i %>"><%=cat_name.get(i- 1)%></option>
<% } %>
</select></form><br>


</center>
</body>
</html>
