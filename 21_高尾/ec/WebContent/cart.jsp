<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.util.ArrayList" %>
    <%@page import = "java.text.NumberFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート画面</title>
</head>
<body>
<%NumberFormat nfCur = NumberFormat.getCurrencyInstance(); %>
<center>


<h1>カート</h1>
<%
   ArrayList<String> names = (ArrayList<String>)session.getAttribute("names");
   ArrayList<String> prices = (ArrayList<String>)session.getAttribute("prices");
   ArrayList<Integer> kosuus = (ArrayList<Integer>)session.getAttribute("kosuus");

   int yen = 0,goukei=0;
   double rate = 0.08;
%>

<table border="1" align="center">
<tr>
<td>商品名</td>
<td>単価</td>
<td>数量</td>
</tr>

<%
 for(int i=0; i<names.size();i++){
	 out.println("<tr>");
	 out.println("<td>" + names.get(i) + "</td>");
	 out.println("<td>" + nfCur.format(Integer.parseInt(prices.get(i))) + "</td>");
	 out.println("<td>" + kosuus.get(i) +"</td>");
	 out.println("</tr>");
 }
%>
<tr>
   <td colspan="2">消費税</td>
   <td>
      <%
         int price_zei =0;
         for(int i=0;i<prices.size(); i++){
        	 for(int j=0;j<kosuus.get(i);j++){
        		 yen = (int) ((Integer.parseInt(prices.get(i)))*rate);
        		 price_zei += yen;
        	 }
         }
         out.println(nfCur.format(price_zei));
      %>
   </td>
 </tr>
 <tr>
   <td colspan ="2">合計金額</td>
   <td>
     <%
       int price_goukei =0;
       for(int i=0;i<prices.size(); i++){
    	   for(int j=0;j<kosuus.get(i);j++){
    		   goukei = (int) ((Integer.parseInt(prices.get(i)))*(rate + 1.00));
    		   price_goukei += goukei;
    	   }
       }
       out.println(nfCur.format(price_goukei));
     %>
   </td>
 </tr>
 </table>
 </center>
<form method="POST" action="http://localhost:8080/ec/cart">
<table align="center">
<tr><td>
<button type="submit" name="next" value="next">購入</button>
</td><td>
<button type="submit" name="back" value="back">買い物を続ける</button>
</td></tr>
</table>
</form>
</body>
</html>