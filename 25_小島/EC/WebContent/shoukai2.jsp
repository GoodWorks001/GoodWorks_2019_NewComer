<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%--使用するクラスのインポート --%>
<%@page import="ec.ItemBean,java.util.ArrayList"%>
<html>
<head>
<%--スタイルシートの定義 --%>
<style>
h1 {
	text-align: center;
}
</style>
<%--関数の定義 --%>
<script type="text/javascript">
function btnLink(){
	location.href="cart.jsp"
}
</script>
<meta content="text/html; charset=UTF-8">
<title>商品紹介</title>
</head>
<body>
	<%--リクエストオブジェクト内の商品を取得 --%>
	<%
		ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) session.getAttribute("Item");
	String cd =(String)session.getAttribute("itemNum2");
	System.out.println("コードは"+cd);
	System.out.println(itemList.size());
	%>

<% System.out.println("詳細にきたよ"); %>

<!-- 	リスト内から商品を取得 -->
 	<%
 	System.out.println(Integer.parseInt(request.getParameter("itemNum")));
		ItemBean mItem = itemList.get(Integer.parseInt(request.getParameter("itemNum")));
	%>

<% System.out.println("詳細にきたよ２"); %>


	<h1>商品紹介</h1>
	<%--画像の表示 --%>
 	<img src=<%=mItem.getImg()%>>
	<table border>
		<tr>
			<td>商品名</td>
			<td><%=mItem.getName()%></td>
		</tr>
		<tr>
			<td>カテゴリ</td>
			<td><%=mItem.getCategory()%></td>
		</tr>
		<tr>
			<td>価格</td>
			<td><%=mItem.getPrice()%></td>
		</tr>
		<tr>
			<td>在庫</td>
			<td><%=mItem.getStock()%></td>
		</tr>
		<tr>
			<td>商品紹介</td>
			<td><%=mItem.getMsg()%></td>
		</tr>
	</table>
	<form action="shoukaiServlet" method="post">
		個数 <select name="order">
			<%
				for (int i = 1; i <= mItem.getStock(); i++) {
			%>
			<option value=<%=i %>><%= i%></option>
			<%}%>
	</select>



	<input type ="hidden" value = <%=mItem.getName() %> name = "name">
	<input type ="hidden" value = <%=mItem.getPrice() %> name = "price">
	<input type ="hidden" value = <%=cd %> name = "cd">
	<input type ="hidden" value = <%=mItem.getStock() %> name = "stock">

	<input type="submit" value="カートへ">
	</form>





	<input type="submit" value="戻る" onClick="location.href='search2.jsp'">


</body>
</html>