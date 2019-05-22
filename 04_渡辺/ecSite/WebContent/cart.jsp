<%@page import="java.util.ArrayList"%>
<%@page import="web.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="sample.css">
<title>カート</title>
</head>

<%
	HttpSession ses = request.getSession();
   ArrayList<ProductBean> cList = (ArrayList<ProductBean>)ses.getAttribute("cart");
   //合計金額
   int sum = 0;
   int price = 0;//単価
   int count = 0;//個数
   int zei = 0;//税込価格
%>

<body>
  <h1>カート</h1>
  <table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
    <tr>
      <th>商品名</th>
      <th>単価</th>
      <th>数量</th>
    </tr>
    <%
    	for(int i=0;i<cList.size();i++){
          //リストからインスタンスを取り出す
          ProductBean p = cList.get(i);
          price = p.getPro_price();
          count = p.getCount();
    %>
    <tr>
      <td><%=p.getPro_name() %></td>
      <td>￥<%= price%></td>
      <td><%= count%></td>
    </tr>
    <%
          sum = sum + (price*count);
      }

      zei = (int)(sum * 0.08);

    %>
    <tr>
      <th colspan="2">消費税</th>
      <td>￥<%=zei %></td>
    </tr>
    <tr>
      <th colspan="2">合計金額</th>
      <td>￥<%=sum + zei %></td>
    </tr>
  </table>
  <div style="display: inline;">
    <form action="KensakuServlet" style="display: inline;" method="post">
        <input type="submit" value="買い物を続ける">
    </form>
    　
    <form action="kakunin.jsp" style="display: inline;" method="post">
        <input type="submit" value="購入">
    </form>
  </div>
</body>
</html>