<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%--webパッケージのEmpBeanクラスを使うよって定義 --%>
<jsp:useBean id="emp" scope="request" class="web.EmpBean"/>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- jsp:useBeanとjsp:getPropertyを使ってJavaBeansの内容を表示するJSPのコード例 -->



<body>

<h1>UseBean</h1>

<!-- テーブルタグ -->

<table border>
<tr>
     <td>Name</td>
           <%--リクエストオブジェクトに格納されている
                beanの中のプロパティ名がnameの値を取得している
                 --%>
     <td><jsp:getProperty name = "emp" property = "name"/></td>   <!-- 内部で指定されたJavaBeansのsetterメソッドが実行され値が変更される -->
</tr>

     <tr>

      <%--リクエストオブジェクトに格納されている
                beanの中のプロパティ名がAgeの値を取得している
                 --%>
        <td>Age</td>
        <td><jsp:getProperty name = "emp" property = "age"/></td>
     </tr>
</table>
</body>
</html>