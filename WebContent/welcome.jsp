<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">

<title>WELCOME </title>
</head>

<body>
<div id="wrapper">
	<div id="header">
		<h2>WELCOME PAGE</h2>
	</div>
</div>
<div id="container">
	<h3> Login </h3>
<form action="LoginServlet" method = "post">
	<table>
		<tbody>
			<tr>
				<td><label> Username = first_Name: </label> </td>
				<td><input type="text" name = "uname"/></td>
			</tr>
			<tr>
				<td><label> Password = last_Name: </label> </td>
				<td><input type="password" name = "psw"/></td>
			</tr>
			<tr>
				<td><label></label> </td>
				<td><input type="submit" value = "Go"/></td>
			</tr>
		</tbody>
	</table>
</form>


</body>

</html>