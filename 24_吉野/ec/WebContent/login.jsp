<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en-US">
<head>
<link href="https://fonts.googleapis.com/css?family=Lato:100" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/background.css">
 <link rel="stylesheet" href="/css/background.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body style="text-align:center;">

	<form action = "http://localhost:8080/ec/login" method = "post">
		<div align="center">
		<div id="wrapper">
    <div id="container">
		<h1>Login</h1>
		</div>
</div>
		</div>
		<br>
		<div align="center"><table align="center">


			<tr><td><div class="cp_iptxt">




					<input class="ef" type = "text" placeholder="" name = "name">
<label>お名前</label>
<span class="focus_line"><i></i></span></div>

				</td>

			</tr>

			<tr>
				<td><div class="cp_iptxt">



					<input class="ef" type = "password" placeholder="" name = "pw" size="24%">
<label>パスワード</label>
<span class="focus_line"><i></i></span></div>
				</td>
			</tr>

		</table></div>
		<br>

		<button class="button7" type =  "submit">Login</button><br>
		<br>

	</form>

	<% String ses = (String)session.getAttribute("zyouhou"); %>
	<%if(ses.equals("true")){ %>

	<%}else if(ses.equals("null")){ %>
		<p class="border02">*名前またはパスワードを入力してください</p>
	<%}else if(ses.equals("!=")){ %>
		<h3>*名前またはパスワードが一致しません</h3>
	<%} %>

</body>

</body>
</html>