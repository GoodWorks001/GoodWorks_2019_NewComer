<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="/ECs/css/style.css">
</head>
<body>

 <div id="topL"></div>
	<div ><h1 align="center">ログイン</h1>

	 <div id="login_frame" align="center">
		<form action="http://localhost:8080/ECs/login" method="POST"><br><br>
			<table align="center">
				<tr>
					<td>
						<%
							String err1 = (String) request.getAttribute("errer1");
						%> <%
 	if (err1 != null) {
 %>
						<div id="errer_col" align="center">
							※<%=err1%></div> <%
 	}
 %> <%
 	String err2 = (String) request.getAttribute("errer2");
 %>
						<%
							if (err2 != null) {
						%>
						<div id="errer_col" align="center">
							※<%=err2%></div> <%
 	}
 %>
					</td>
				</tr>
			</table>

				<table align="center">
					<tr>
						<td>名前:</td>
						<td ><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>パスワード:</td>
						<td ><input type="password" name="pass" ></td>
					</tr>

				<tr>
				<td><br></td>
				<td align="right" ><input type="submit" name="buttom" value="LOGIN" ></td>
				</tr>
				</table>
		</form>
	  </div>
	</div>
</body>
</html>