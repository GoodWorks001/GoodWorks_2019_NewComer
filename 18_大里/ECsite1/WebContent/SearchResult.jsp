<%@page import="search.SearchJDBCkekka"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import = "java.util.ArrayList" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
</head>
<body>
<center>
<h1>検索</h1>

<% HttpSession session = request.getSession(false);%>
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
<select name="category" onchange = "javascript:document.form1.submit();">
<option value="0" ></option>
<% for(int i = 1; i <= cat_name.size();i++) {%>
	<option value="<%= i %>"><%=cat_name.get(i - 1)%></option>
<% } %>
</select></p></form><br>


<table border = "1" cellpadding="10" cellspacing="0">
    <thead>
	    <tr height = "40">
		    <th>商品名</th>
		    <th>価格</th>
		    <th>詳細</th>
	    </tr>
    </thead>
    <tbody>
        <% for(int i = 0; i < listcd.size(); i++) { %>
	        <tr height = "40">
		        <td><%=listname.get(i) %></td>
		        <td>￥<%=listprice.get(i) %></td>
		        <td>
		        <form action = "Detail.jsp">
		        <input type="hidden" name="id" value= "<%=listcd.get(i) %>" >
		        <input type = "submit" value = "詳細" ></form>
		    </td>
	    </tr>
	    <% } %>
    </tbody>
    </table>
    <% if(listcd.size() < 1){%>
        <h3>検索結果がありません</h3>
    <% }%>
</center>
</body>
</html>


