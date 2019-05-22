<%@page import="java.util.ArrayList"%>
<%@page import="web.CartBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート画面</title>
</head>
<body>
<%

ArrayList <String>Nlist =(ArrayList)session.getAttribute("cart");
ArrayList <Integer>Klist =(ArrayList)session.getAttribute("cart1");
ArrayList <Integer>KOlist =(ArrayList)session.getAttribute("cart2");
ArrayList <Integer>ZAlist =(ArrayList)session.getAttribute("cart3");
ArrayList <Integer>CDlist =(ArrayList)session.getAttribute("cart4");

%>

	<h1>
		<p align="center">カート</p>
	</h1>
	<br>

	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>数量</th>
		</tr>

		<%for(int i=0;i<Nlist.size();i++){ %>

       <tr>
			<td><%=Nlist.get(i)%></td>
			<td>￥<%=Klist.get(i) %></td>
			<td><%=KOlist.get(i)%></td>
		</tr>

		<%} %>

		<tr>
		<%
		int zei=0;
		%>

		<%
		for(int i=0;i<Klist.size();i++){
			int a=0;
			int b=0;
			double c=0.08;
			a+=Klist.get(i);
			b+=KOlist.get(i);

			zei+=(int)((a*b)*c);
		}


		%>

			<th colspan="2">消費税

			</td>
			<td>￥<%=zei %></td>

			<%
		int gou=0;
		%>

		<%
		for(int i=0;i<Klist.size();i++){
			int a=0;
			int b=0;
			double c=1.08;
			a+=Klist.get(i);
			b+=KOlist.get(i);

			gou+=(int)((a*b)*c);
		}


		%>


</td>
		</tr>
		<tr>
			<th colspan="2">合計金額
			</td>
			<td>￥<%=gou %></td>
		</tr>
	</table>

	<div align="center">
		<table>
			<tr>
				<td>
					<form action="http://localhost:8080/web/Kensaku" method="post">
						<input type="submit" align="center" value="買い物を続ける">
					</form>
				</td>
				<td>
					<form action="Kakunin.jsp">
						<input type="submit" value="購入">
					</form>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>