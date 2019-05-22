<%--使用するクラスのインポート --%>
<%@page import="web.ProductBean,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	location.href="kensaku.jsp"
}
</script>


<meta charset="UTF-8">
<title>商品紹介</title>
</head>
<body>
      <%--リクエストオブジェクト内の商品を取得 --%>
      <%
		ArrayList<ProductBean> array = (ArrayList<ProductBean>) request.getAttribute("product");
	%>

	<%-- リスト内から商品を取得--%>
		<%
		ProductBean mItem = array.get(Integer.parseInt(request.getParameter("itemNum")));
	%>

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

	<form action="cart" method="post">
	  個数 <select name="order">
			<%
				for (int i = 1; i <= mItem.getStock(); i++) {
			%>
			<option value=<%=i %>><%= i%></option>
			<%} %>

	  </select>
	  <input type="submit" value="カートへ">
       </form>

   <button type="submit" onclick="btnLink()">戻る</button>

</body>
</html>