<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<%--webパッケージのResultBeanクラスを使うよって定義 --%>
<jsp:useBean id = "result" class="web.ResultBean" scope="request"/>

<html>
<head>

<!-- jsp:useBeanとjsp:getPropertyを使ってJavaBeansの内容を表示するJSPのコード例 -->

<meta charset="UTF-8">
<title>占い</title>
</head>
<body>
<h1><%= request.getParameter("name") %>さんの運勢</h1>
<table border>

            <%--リクエストオブジェクトに格納されている
                beanの中のプロパティ名がmoneyの値を取得している
                 --%>
     <tr>
        <th>金運</th><td><jsp:getProperty name = "result" property = "money"/></td>
     </tr>


            <%--リクエストオブジェクトに格納されている
                beanの中のプロパティ名がloveの値を取得している
                 --%>
      <tr>
        <th>恋愛運</th><td><jsp:getProperty name = "result" property = "love"/></td>
     </tr>


          <%--リクエストオブジェクトに格納されている
                beanの中のプロパティ名がworkの値を取得している
                 --%>
      <tr>
        <th>仕事運</th><td><jsp:getProperty name = "result" property = "work"/></td>
     </tr>



            <%--リクエストオブジェクトに格納されている
                beanの中のプロパティ名がhealthの値を取得している
                 --%>
      <tr>
        <th>健康運</th><td><jsp:getProperty name = "result" property = "health"/></td>
     </tr>



            <%--リクエストオブジェクトに格納されている
                beanの中のプロパティ名がtotalの値を取得している
                 --%>
      <tr>
        <th>全体運</th><td><jsp:getProperty name = "result" property = "total"/></td>
     </tr>

</table>

</body>
</html>