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
		ArrayList<Integer> listprice = (ArrayList<Integer>) session.getAttribute("price");
		ArrayList<String> listname = (ArrayList<String>) session.getAttribute("name");
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
	<form action="http://localhost:8080/EC/syousai" method="POST">
		<table border="1" width="500" cellspacing="0" align="center"
			cellpadding="5" bordercolor="black">
			<tr>
				<td>���i��</td>
				<td>���i</td>
				<td>�ڍ�</td>
			</tr>
			<%
				for (int i = 0; i < listname.size(); i++) {
			%>
			<tr height="40">
				<td><%=listname.get(i)%></td>
				<td>��<%=listprice.get(i)%></td>
				<td><input type="hidden" name="syousai" value="<%=listname.get(i)%>">
					<input type="submit" value="�ڍ�"></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>