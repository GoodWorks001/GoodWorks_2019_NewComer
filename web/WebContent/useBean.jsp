<%@page contentType="text/html;charset=Windows-31J" %>
<jsp:useBean id="emp" scope="request" class="web.EmpBean"/>
<%--web�p�b�P�[�W��empbean�N���X���g����` --%>
<html>
<body>
<h1>UseBean</h1>
<table border>
<tr>
<td>Name</td>

<%--���N�G�X�g�I�u�W�F�N�g�Ɋi�[����Ă���bean�쒆�̃v���p�e�B����name�̒l������Ƃ����Ă��� --%>
<td><jsp:getProperty name="emp" property="name"/></td>
</tr>
<tr>
<td>Age</td>

<%--���N�G�X�g�I�u�W�F�N�g�Ɋi�[����Ă���bean�쒆�̃v���p�e�B����age�̒l������Ƃ����Ă��� --%>
<td><jsp:getProperty name="emp" property="age"/></td>
</tr>
</table>
</body>
</html>