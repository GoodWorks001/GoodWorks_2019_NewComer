<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="web1.CatBean"%>
<%@page import="web1.ProBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
	<%
		ArrayList<CatBean> catlist = (ArrayList<CatBean>) session.getAttribute("catlist");
		ArrayList<ProBean> prolist = (ArrayList<ProBean>) session.getAttribute("prolist");
	%>
	<center>
	<FORM method="POST" action="http://localhost:8080/web1/Search">
	<h1>検索</h1>
		<input type="text" name="kensaku"><br> <br> <br>
		カテゴリ<select name="cat">
			<option></option>
			<%
				for (int i = 0; i < catlist.size(); i++) {
					CatBean cb = catlist.get(i);
			%>
			<option value="<%=cb.getCat_id()%>"><%=cb.getCat_name()%></option>
			<%
				}
			%>
		</select> <br> <br> <input type="submit" value="SEARCH">
	</form><br>
	</center>
</body>
</html>


