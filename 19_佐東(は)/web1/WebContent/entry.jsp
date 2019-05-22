<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FottuneRoll</title>
</head>
<body>
<form action = "http://localhost:8080/web1/fortune" method = "post">
<h1>占いアプリケーション</h1>
<table><tr>

<td>氏名</td>
  <td><input type = "text" name = "name"></td></tr>

   <tr>
      <td>生年月日</td>
      <td><select name="year">
      <option value=""></option>
      <option value="1990">1990</option>
      <option value="1991">1991</option><option value="1991">1992</option>
      <option value="1991">1993</option><option value="1991">1994</option>
      <option value="1991">1995</option><option value="1991">1996</option>
      <option value="1991">1997</option><option value="1991">1998</option>
      <option value="1991">1999</option><option value="1991">2000</option>
      <option value="1991">2001</option><option value="1991">2002</option>
      <option value="1991">2003</option><option value="1991">2004</option>
      <option value="1991">2005</option><option value="1991">2006</option>
      <option value="1991">2007</option><option value="1991">2008</option>
      <option value="1991">2009</option><option value="1991">2010</option>
      <option value="1991">2011</option><option value="1991">2012</option>
      <option value="1991">2013</option><option value="1991">2014</option>
      <option value="1991">2015</option><option value="1991">2016</option>
      <option value="1991">2017</option><option value="1991">2018</option>
      <option value="1991">2019</option><option value="1991">2020</option>
      </select></td>
      <td>月</td>
      <td><select name="month">
      <option value=""></option>
      <option value="01">01</option><option value="02">02</option>
      <option value="03">03</option><option value="04">04</option>
      <option value="05">05</option><option value="06">06</option>
      <option value="07">07</option><option value="08">08</option>
      <option value="09">09</option><option value="10">10</option>
      <option value="11">11</option><option value="12">12</option>
      </select></td>
      <td>日</td>
      <td><select name="date">
      <option value=""></option>
      <option value="01">01</option><option value="02">02</option>
      <option value="04">04</option><option value="05">05</option>
      <option value="06">06</option><option value="07">07</option>
      <option value="08">08</option><option value="09">09</option>
      <option value="10">10</option><option value="11">11</option>
      <option value="12">12</option><option value="13">13</option>
      <option value="14">14</option><option value="15">15</option>
      <option value="16">16</option><option value="17">17</option>
      <option value="18">18</option><option value="19">19</option>
      <option value="20">20</option><option value="21">21</option>
      <option value="22">22</option><option value="23">23</option>
      <option value="24">24</option><option value="25">25</option>
      <option value="26">26</option><option value="27">27</option>
      <option value="28">28</option><option value="29">29</option>
      <option value="30">30</option><option value="31">31</option>
      </select></td>
</tr>

   <tr>
   <td><input type = "submit" value = "占う"></td>
   </tr>

</table>
</form>
</body>
</html>