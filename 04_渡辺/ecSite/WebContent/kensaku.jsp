<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="java.sql.SQLException"%>
<%@page import="web.DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="sample.css">
<meta charset="UTF-8">
<title>商品検索画面</title>
</head>
<%--requestからArrayListを取り出す --%>
<%
  ArrayList<ProductBean> pList = (ArrayList<ProductBean>)request.getAttribute("pro");
 System.out.println(pList.size());
 try{
    DAO d = new DAO();
    ResultSet rs = d.getCat();
%>


<body>
  <h1>検索</h1>
  <br>
  <br>

  <form action="KensakuServlet" method="post">
    <input type="text" name="word" size="40"> <br> <br> <br>
    カテゴリ <select name="cat">
      <option selected="selected"></option>
      <%
        while(rs.next()){
      %>
      <option value=<%=rs.getString("cat_id")%>><%=rs.getString("cat_name")%></option>
      <%
        }
      %>


    </select>
    <br><br>

    <input type="submit" value="検索">
  </form>

  <br>
  <%
    if(pList.size()!= 0){
  %>
  <table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
    <tr>
      <th>商品名</th>
      <th>価格</th>
      <th>詳細</th>
    </tr>
    <%--商品の数分繰り返す --%>
    <%for(int i = 0;i<pList.size();i++){
                 ProductBean p = pList.get(i);%>
    <tr>
      <td><%=p.getPro_name() %></td>
      <td>￥<%=p.getPro_price() %></td>
      <td>
        <form action="SyoukaiServlet" method="post">
          <input type="hidden" name="pro_cd" value=<%=p.getPro_cd() %>>
          <input type="submit" value="詳細">
        </form>
      </td>
    </tr>
    <%} %>

  </table>
  <%}else{%>
  <p>検索結果がありません</p>
  <%}%>

  <% }catch(Exception ex){
  ex.printStackTrace();
 }
%>
</body>
</html>
