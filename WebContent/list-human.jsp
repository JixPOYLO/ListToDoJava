<%@ page import="java.util.*,com.POYLO.web.jdbc.*" %>
<html>
<head>
<title>HUMANS</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<% List<Human> theHumans = (List<Human>)request.getAttribute("HUMAN_LIST"); %>
<body>
<%= theHumans %>
<div id="wrapper">
	<div id="header">
		<h2>ESILV Hellow </h2>
	</div>
</div>
<div id="container">
	<div id="content">
		<table>
			<tr>
				<th>First Name </th>
				<th>Last Name</th>
				<th>Statut </th>
			</tr>
			<% for(Human tempHuman:theHumans) { %>
			<tr>
				<td><%= tempHuman.getFirst_Name() %></td>
				<td><%= tempHuman.getLast_Name() %></td>
				<td><%= tempHuman.getStatut() %></td>
				<%} %>
		</table>
	</div>
</div>



</body>
</html>