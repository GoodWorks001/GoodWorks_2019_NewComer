<%@page import="web.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<style>

div{
     width:300px;
     padding:10px;
     text-align:center;
     text-align:center;
     margin:30px aouto;

}

</style>

<script type="text/javascript">
function btnLink(){
	location.href="item.jsp"
}
</script>



<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>

<%@include file="/kensaku.jsp" %>


<!--検索結果  -->
<div>
       <table border="1" cellspacing="0">
           <tr>
              <td>商品名</td>
              <td>価格</td>
              <td>詳細</td>
           </tr>
           <%ArrayList<ProductBean> array = (ArrayList<ProductBean>)session.getAttribute("Product"); %>

           <% for(int i = 0; i < array.size(); i++) { %>
           <tr>
           <!--商品名  -->
             <td>
             <%= array.get(i).getName() %>
             </td>
           <!-- 価格 -->
             <td>
             <%= array.get(i).getPrice() %>
             </td>
           <!-- 詳細 -->
             <td>
             <input type="hidden" name="itemNum" value=<%=i %>>
             <button type="submit" onclick="btnLink()">詳細</button>

             </td>
             </tr>
             <% } %>
             </table>



</div>






</body>
</html>