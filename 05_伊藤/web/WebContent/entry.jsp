<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>占いアプリケーション</title>
</head>
<body>
	<h1>占いアプリケーション</h1>
	<br>
	<br>
	<%--xmlに飛ばす --%>
	<form action="http://localhost:8080/web/fortune" method="post">
		<tr>
			<td>氏名</td>
			<input type="text" name="name">
			<br>
			<br>

			<td>生年月日</td>
		<tr>年
		</tr>
		<select name="year">
			<%-- 始めは表示しない --%>
			<option value="0"></option>
			<%--コンボボックスに１９００年～２０１９年を表示 --%>
			<%
				for (int i = 1900; i <= 2019; i++) {
			%>
			<option value="<%=i%>"><%=i%></option>
			<%
				}
			%>
		</select>


		<tr>月
		</tr>
		<select name="month">
			<%-- 始めは表示しない --%>
			<option value="0"></option>
			<%--コンボボックスに１月～１２月を表示 --%>
			<%
				for (int i = 1; i <= 12; i++) {
			%>
			<option value="<%=i%>"><%=i%></option>
			<%
				}
			%>
		</select>

		<tr>日
		</tr>
		<select name="date">
			<%-- 始めは表示しない --%>
			<option value="0"></option>
			<%--コンボボックスに１日～３１日を表示 --%>
			<%
				for (int i = 1; i <= 31; i++) {
			%>
			<option value="<%=i%>"><%=i%></option>
			<%
				}
			%>
		</select> <br>
		<br> <input type="submit" value="占う">

	</form>
</body>
</html>