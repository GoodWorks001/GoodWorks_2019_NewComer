<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
    
    <%--result�ɓ����Ă�request�l���g����悤�ɒ�` --%>
    <jsp:useBean id="result" scope="request" class="web.ResultBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�^��</title>
</head>
<body>

<h1><%= request.getParameter("name")  %>�̉^��</h1>
<table border>
<tr>
    <td>���^</td>
    <%--���N�G�X�g�I�u�W�F�N�g�Ɋi�[����Ă���bean1�̂Ȃ��̃v���p�e�B����money�̒l���擾���Ă��� --%>
    <td><jsp:getProperty name="result" property="money"/></td>
</tr>
<tr>
    <td>�����^</td>
    <%--���N�G�X�g�I�u�W�F�N�g�Ɋi�[����Ă���bean1�̂Ȃ��̃v���p�e�B����love�̒l���擾���Ă��� --%>
    <td><jsp:getProperty name="result" property="love"/></td>
</tr>
<tr>
    <td>�d���^</td>
    <%--���N�G�X�g�I�u�W�F�N�g�Ɋi�[����Ă���bean1�̂Ȃ��̃v���p�e�B����work�̒l���擾���Ă��� --%>
    <td><jsp:getProperty name="result" property="work"/></td>
</tr>
<tr>
     <td>���N�^</td>
     <%--���N�G�X�g�I�u�W�F�N�g�Ɋi�[����Ă���bean1�̂Ȃ��̃v���p�e�B����health�̒l���擾���Ă��� --%>
     <td><jsp:getProperty name="result" property="health"/></td>
</tr>
<tr>
    <td>�S�̉^</td>
    <%--���N�G�X�g�I�u�W�F�N�g�Ɋi�[����Ă���bean1�̂Ȃ��̃v���p�e�B����total�̒l���擾���Ă��� --%>
    <td><jsp:getProperty name="result" property="total"/></td>
</tr>
</table>

</body>
</html>