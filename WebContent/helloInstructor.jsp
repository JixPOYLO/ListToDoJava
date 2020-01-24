<html>
<head>
<metahttp-equiv="Content-Type"content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css">

<title>Hello Instructor</title>
</head>

<body>
<c:if test="${!empty sessionScope.uname && !empty sessionScope.psw}">
<h2> Hello instructor : ${sessionScope.uname} ${sessionScope.psw} </h2>
</c:if>

<div style="clear:both;"></div>
	<a href="TodolistControllerServlet"> Access to all TODO </a>
</div>

</body>
</html>