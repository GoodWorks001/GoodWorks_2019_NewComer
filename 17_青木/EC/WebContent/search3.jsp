<%@ page language="java" contentType="text/html; charset=Windows-31J"
	import="java.util.ArrayList"%>
<jsp:useBean id="result" class="EC.SyouhinBean" scope="request" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>���i����</title>
</head>
<body style="text-align: center;">
	<%
		ArrayList<String> listcat = (ArrayList<String>) session.getAttribute("category");
		ArrayList<Integer> listcat_id = (ArrayList<Integer>) session.getAttribute("category_id");
	%>
	<h1>����</h1>
	<form action="http://localhost:8080/EC/syouhin" method="POST">
		<input type="text" name="p_name"> <br> <br> <br>

		�J�e�S���F

		<select name="category" size="1">
		    <option value= 0></option>
		    <%
			    for (int i = 0; i < listcat.size(); i++) {
		    %>
			    <option value=<%=listcat_id.get(i)%>><%=listcat.get(i)%></option>
			<%
			    }
		    %>
		</select>
 <br> <br>
		<!-- ���M�{�^�� -->
		<input type="submit" value="����"> <br> <br>
	</form>
	<br>
	<br>
	<p align="center">�������ʂ�0���ł���</p>

</body>
</html>