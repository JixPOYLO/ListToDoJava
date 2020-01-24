<%@ page import="java.util.*,com.POYLO.web.jdbc.*" %>
<html>
<head>
<title>TODOS</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<% List<Todolist> theTodos = (List<Todolist>)request.getAttribute("TODO_LIST"); %>
<body>
<%= theTodos %>
<div id="wrapper">
	<div id="header">
		<h2>MY TODOOOO </h2>
	</div>
</div>
<div id="container">
	<div id="content">
		<table>
			<tr>
				<th>Description </th>
				<th>Task done ?</th>
			</tr>
			<% for(Todolist tempTodo:theTodos) { %>
			<tr>
				<td><%= tempTodo.getDescription() %></td>
				<td><%= tempTodo.isDone() %></td>
				<%} %>
		</table>
	</div>
</div>

</body>
</html>
</body>
</html>