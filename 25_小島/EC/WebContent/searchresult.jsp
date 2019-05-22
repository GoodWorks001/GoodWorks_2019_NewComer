<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import ="ec.ItemBean" %>
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
<script type="text/javascript">
function btnLink(){
	location.href="shoukai2.jsp"
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
</head>
<body>

<% System.out.println("結果にきたよ"); %>

 <%@ include file="search2.jsp" %>

<!-- 以下検索結果 -->

<div>
<center>
		<table border="1"cellspacing="0">
			<tr>
			  <td>商品名</td>
			  <td>価格</td>
			  <td>詳細</td>
			</tr>
			<%ArrayList<ItemBean> itemList = (ArrayList<ItemBean>)session.getAttribute("Item"); %>

			<% for(int i = 0;i<itemList.size();i++){ %>
			<tr>
			<!-- 商品名 -->
			  <td>
			  <%=itemList.get(i).getName() %>
			  </td>
			<!-- 価格 -->
			  <td>
			  <%=itemList.get(i).getPrice() %>
			  </td>
			<!-- 詳細 -->
			  <td>

			  <form action="shousai10" method="post">
			  <input type="hidden" name ="itemNum" value=<%=i %>>
			  <button type="submit">詳細</button>
			   </form>
</center>
			  </td>

			</tr>
			<% } %>
		</table>
</div>


</body>
</html>

