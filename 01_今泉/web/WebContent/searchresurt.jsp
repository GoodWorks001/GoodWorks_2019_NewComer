<%@page import="web.ProductBean"%>
<%@page import="web.CategoryBean"%>
<%@page import="web.DAO2"%>
<%@page import="web.CateDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="second.css">
<title>検索結果ページ</title>

</head>
<body style="text-align: center;">
<%
//セッションから登録したアレイリストを取得
ArrayList<CategoryBean> catlist = (ArrayList<CategoryBean>)session.getAttribute("catlist");
System.out.println("こっち");

%>

   <form action="/web/Search" method="post">

		<h1>検索</h1>
		<input type="text" name="name"><br> <br> <br>
		カテゴリ<select name="aaaa">
			<option></option>
			<%System.out.println("ここ");
			//for文でアレイリスト文<option></option>を作成
			for(int i =0;i<catlist.size();i++){
				CategoryBean c = catlist.get(i);
			%>
			<option value="<%=c.getCat_id()%>"><%=c.getCat_name()%></option>
		<% System.out.println("こちら"); }%>

		</select>

		<br> <br> <input type="submit" value="検索">
		</form><br>




<div>


		<table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
			<tr>
			  <td>商品名</td>
			  <td>価格</td>
			  <td>詳細</td>
			</tr>
			<%ArrayList<ProductBean> itemList = (ArrayList<ProductBean>)session.getAttribute("Item"); %>

			<% for(int i = 0;i<itemList.size();i++){ %>
			<tr>
			<!-- 商品名 -->
			  <td>
			  <%=itemList.get(i).getPro_name() %>
			  </td>
			<!-- 価格 -->
			  <td>
			  ￥<%=itemList.get(i).getPro_price() %>
			  </td>
			<!-- 詳細 -->


			  <td><form action="Kaden" method="post">
			  <input type="hidden" name ="itemNum" value=<%=itemList.get(i).getPro_cd() %>>

			  <button type="submit" onclick="btnLink()">詳細</button>
			  </form>



			  </td>
			</tr>
			<% } %>
		</table>
</div>

</body>
</html>