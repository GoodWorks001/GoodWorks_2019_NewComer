<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Ec.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Ecp.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>

</head>
<body>




	<center>

	<h1>ECサイトへようこそ</h1>

		<h1>ログイン</h1>
		<br>
		<form action="ECservlet" method="POST" >
<div class="cp_iptxt">

		 <input class="ef" type="text" placeholder=""  name="name2"  ><br>
		 	<label>名前</label>
<span class="focus_line"><i></i></span>

</div>


			<br> パスワード <input type="password" name="pass2"><br>
			<br>

			<!-- ログインボタン -->
			<input type="submit" value="LOGIN">

		</form>
	</center>
</body>
</html>