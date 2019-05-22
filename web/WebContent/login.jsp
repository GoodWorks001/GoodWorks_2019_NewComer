<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList" %>

<html>
<head>
<style>

div {
	padding: 10px;
	text-align: center;
	text-align: center;
	margin: 30px auto;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>

<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link href="ecentry.css" rel="stylesheet" type="text/css">
</head>

<body">
<article>
	<%-- ArrayList<String> list = (ArrayList<String>)request.getAttribute("CategoryList"); --%>

	<h1>検索</h1>
		<form action="http://localhost:8080/web/kensaku" method="POST">
			<input type="text" name="search" >
				<br>
				<br>
					カテゴリ
					<select name="category">
					<option value=""></option>
						<option value="1">炊飯器</option>
						<option value="2">GOD</option>
						<option value="3">PC</option>

						</select>

			<input type="submit" value="検索" class="btn">
		</form>



	<% String aa = (String)session.getAttribute("flg");  %>

	<% ArrayList<String> list = (ArrayList<String>)session.getAttribute ("list"); %>

	<%  if(aa == "true"){ %>

<% }else{ %>
<br>

    <table border="1" align="center">

    	     <tr>
			  <td>商品名</td>
			  <td>価格</td>
			  <td>詳細</td>
			</tr>

    			<% for(int i = 0; i<list.size(); i+=3){
    				System.out.println("サイズは"+list.size());  %>
			<tr>
			<!-- 商品名 -->
			  <td>
			  <%=list.get(i) %>
			  </td>
			<!-- 価格 -->
			  <td>
			  <%=list.get(i+1)%>
			  </td>
			<!-- 詳細 -->
			  <td>
			  <form action="http://localhost:8080/web/syousai" method="POST">
			   <input type="submit" value="詳細"<%=i %> class="btn">
			  <input type="hidden" value="<%=list.get(i+2) %>" name="ID"></form>
			  </td>
			  </tr>
    <% } %>
    </table>
    <%-- </form>--%>

    <% } %>
</article>

</body>

</html>