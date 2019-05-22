<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <jsp:useBean id="pro" class = "web.ProductBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="sample.css">
<title>商品紹介画面</title>
</head>

<%int cnt = pro.getStock_no();
 String img = pro.getPro_img();%>

<body style="text-align: center;">
  <h1>商品紹介</h1>
  <img alt="商品画像" src="<%=img %>" align="left">

   <table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="black">
    <tr>
      <th>商品名</th>
      <td><jsp:getProperty property="pro_name" name="pro"/></td>
    </tr>
    <tr>
      <th>カテゴリ</th>
      <td><jsp:getProperty property="cat_name" name="pro"/></td>
    </tr>
    <tr>
      <th>価格</th>
      <td>￥<jsp:getProperty property="pro_price" name="pro"/></td>
    </tr>
    <tr>
      <th>在庫</th>
      <td><jsp:getProperty property="stock_no" name="pro"/></td>
    </tr>
    <tr>
      <th>商品紹介</th>
      <td><jsp:getProperty property="pro_msg" name="pro"/></td>
    </tr>
  </table>
  <br>
  <div style="display:inline;">
    <form action="CartServlet" style="display:inline;" method="post">
    個数
    <select name="count">
    <%for(int i=1;i<=cnt;i++){%>
      <option><%=i %></option>
     <%} %>
    </select>
    <input type="submit" value="カートへ">
  </form>

  <form action="KensakuServlet" style="display:inline;" method="post">
    <input type="submit" value="戻る">
  </form>
  </div>




</body>
</html>