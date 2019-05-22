<%@page import="ec.DAO"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Data"%>
<%@page import="ec.Meisai"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ec.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入確認画面</title>
</head>
<body>
	<%
		//
		request.setCharacterEncoding("UTF-8");
		HttpSession ses = request.getSession(true);
		ArrayList<Product> cart = new ArrayList<Product>();
		cart = (ArrayList<Product>) session.getAttribute("CART");
		int sum = 0;
		int zei = 0;
		//明細アレイリスト作成
		ArrayList<Meisai> mlist = new ArrayList<Meisai>();
	%>
	<h1>
		<p align="center">購入しますか？</p>
	</h1>
	<br>

	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>注文数量</th>
		</tr>
		<%
			for (int i = 0; i < cart.size(); i++) {
				//商品インスタンス
				Product pro = cart.get(i);
				//合計計算
				sum = sum + (pro.getPro_price() * pro.getT_kazu());
				//明細インスタンス生成
				Meisai m = new Meisai();
				//インスタンスに税込み合計金額セット
				m.setMei_price((int) (pro.getPro_price() * pro.getT_kazu() * 1.08));
				//注文個数をセット
				m.setPro_stcok(pro.getT_kazu());
				//pro_cdをセット
				m.setPro_cd(pro.getPro_cd());
				//アレイリストに追加
				mlist.add(m);
		%>
		<tr>
			<td><%=pro.getPro_name()%></td>
			<td>\<%=pro.getPro_price()%></td>
			<td><%=pro.getT_kazu()%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<th colspan="2">消費税</th>
			<td>\<%=zei = ((int) (sum * 0.08))%></td>
		</tr>
		<tr>
			<th colspan="2">合計金額</th>
			<td>\<%=sum + zei%></td>
		</tr>
	</table>
	<%
		ses.setAttribute("MEISAI", mlist);
	%>
	<div align="center">
		<table>
			<tr>
				<td>
					<form action="CatServlet" method="post">
						<input type="submit" align="center" value="いいえ">
					</form>
				</td>
				<td>
					<form action="MaisaiServlet" method="post">
						<input type="submit" value="はい">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>