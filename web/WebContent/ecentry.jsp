<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link href="ecentry.css" rel="stylesheet" type="text/css">

</head>
<body>
<article>

<h1>ログイン</h1>
<form action="http://localhost:8080/web/login" method="POST">

<table align="center">
<tr><td>名前</td><td><input type="text" name="name"></td></tr>
<tr><td>パスワード</td><td><input type="text" name="pass"></td></tr>
</table>

<br>

<a>
<input type="submit" value="LOGIN" class="btn"></a>
</form>


</article>

    <%-- String session = (String)session.getAttribute("zyouhou"); --%>
	<%if(session.equals("true")){ %>

	<%}else if(session.equals("")){ %>
		<h3>*名前またはパスワードを入力してください</h3>
	<%}else if(session.equals("!=")){ %>
		<h3>*名前またはパスワードが一致しません</h3>
	<%} %>


</body>
</html>