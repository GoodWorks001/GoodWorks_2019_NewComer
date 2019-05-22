<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索ページ</title>
</head>
<body>
	<h3 align="right"><%="ログイン中：" + session.getAttribute("login_name")%></h3>
	<h1 align="center">検索ページ</h1>
	<form action="/Ex/kensaku" method="Post">
		<%
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();

			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> priceList = new ArrayList<String>();
			ArrayList<String> idList = new ArrayList<String>();
			ArrayList<String> cat_name_List = new ArrayList<String>();
			ArrayList<String> cat_id_List = new ArrayList<String>();

			nameList = (ArrayList<String>) request.getAttribute("nameList");
			priceList = (ArrayList<String>) request.getAttribute("priceList");
			idList = (ArrayList<String>) request.getAttribute("idList");
			cat_name_List = (ArrayList<String>) session.getAttribute("cat_name");
			cat_id_List = (ArrayList<String>) session.getAttribute("cat_id");

		%>
		<br> <br>
		<div style="text-align: center">
			<input type="text" name="searchPass" size="50"><br> <br>
			カテゴリ <select name="category">
				<%
					for (int i = 0; i < cat_name_List.size(); i++) {
						out.println(cat_name_List.get(i));
						out.println("<option value= " + cat_id_List.get(i) + " ");
						if (cat_id_List.get(i).equals(request.getAttribute("selectCat")))
							out.println("selected");
						out.println(">" + cat_name_List.get(i) + "</option>");
					}
				%>
			</select> <br> <br> <input type="submit" name="update" value="検索">
			<br> <br>
			<%
				if (nameList != null) {
			%>
			<table border="1" width="500" cellspacing="0" align="center"
				cellpadding="5" bordercolor="black">
				<tr>
					<td><b>商品名</b></td>
					<td><b>価格</b></td>
					<td><b>詳細</b></td>
				</tr>
				<%
					if ((nameList != null && priceList != null)) {

							for (int i = 0; i < nameList.size(); i++) {
								out.println("<tr>");
								out.println("<td>" + nameList.get(i) + "</td>");
								out.println("<td>" + nfCur.format(Integer.parseInt((priceList.get(i)))) + "</td>");
								out.println("<td><button type=\"submit\" name=\"syousai\" value=\"" + idList.get(i)
										+ "\">詳細</button></td>");
								out.println("<tr>");
							}
						}
				%>
			</table>
			<%
				}else{
					out.println("<br>");
					out.println("<div style=\"text-align:center\"><font size=\"3\" color=\"red\"><b>検索結果がありません。</b></font>");
				}
			%>
		</div>
	</form>
</body>
</html>