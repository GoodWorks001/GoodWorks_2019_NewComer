<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import ="web.ItemBean" %>
<html>
<head>
<style>

div {
	width: 300px;
	padding: 10px;
	text-align: center;
	text-align: center;
	margin: 30px auto;
}
</style>
<script type="text/javascript">
function btnLink(){
	location.href="detail.jsp"
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="login.jsp" %>

<!-- 以下検索結果 -->

<div>
		<table border="1"cellspacing="0">
			<tr>
			  <td>商品名</td>
			  <td>価格</td>
			  <td>詳細</td>
			</tr>
			<%ArrayList<ItemBean> itemList = (ArrayList<ItemBean>)request.getAttribute("Item"); %>

             <%
			// 商品位置格納用リスト
			ArrayList<Integer> numList = new ArrayList<Integer>();
			%>



			<% for(int i = 0;i<itemList.size();i++){ %>
			<tr>
			<!-- 商品名 -->
			  <td>
			  <%=itemList.get(i).getpro_name() %>
			  </td>
			<!-- 価格 -->
			  <td>
			  <%=itemList.get(i).getpro_price() %>
			  </td>
			<!-- 詳細 -->
			  <td>
			  <input type="hidden" name ="itemNum" value=<%=i %>>
			  <button type="button" onclick="btnLink()">詳細</button>

			  </td>
			</tr>
			<% } %>
		</table>
</div>


</body>
</html>