<%@ page language="java" contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>���O�C��</title>
</head>
<body style="text-align:center;">
<h1 align="center">���O�C��</h1>
<form action ="http://localhost:8080/EC/EC" method ="POST">
    <span class="label label-danger">${message}</span><br>
    <table align="center">
        <tr>
            <td>���O</td>
            <!-- ���O���̓t�H�[�� -->
            <td><input type ="text" name ="name"></td>
        </tr>
        <tr>
            <td>�p�X���[�h</td>
            <!-- �p�X���[�h���̓t�H�[�� -->
            <td><input type ="text" name ="password"></td>
        </tr>
    </table>
    <br>
    <!-- ���M�{�^�� -->
    <input type ="submit" value ="LOGIN" >
</form>
</body>
</html>