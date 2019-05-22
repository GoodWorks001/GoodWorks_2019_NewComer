<%@ page language="java" contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body style="text-align:center;">
<h1 align="center">ログイン</h1>
<form action ="http://localhost:8080/EC/EC" method ="POST">
    <span class="label label-danger">${message}</span><br>
    <table align="center">
        <tr>
            <td>名前</td>
            <!-- 名前入力フォーム -->
            <td><input type ="text" name ="name"></td>
        </tr>
        <tr>
            <td>パスワード</td>
            <!-- パスワード入力フォーム -->
            <td><input type ="text" name ="password"></td>
        </tr>
    </table>
    <br>
    <!-- 送信ボタン -->
    <input type ="submit" value ="LOGIN" >
</form>
</body>
</html>