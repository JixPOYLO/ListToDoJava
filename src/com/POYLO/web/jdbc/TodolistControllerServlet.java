package com.POYLO.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TodolistControllerServlet
 */
@WebServlet("/TodolistControllerServlet")
public class TodolistControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodolistDBUtil todolistDBUtil;
	
	@Resource(name="jdbc/project1java")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try 
		{
			listTodo(request,response);
		 
		}
		catch (Exception e)
		{// TODO Auto-generated catch blocke.printStackTrace();
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private void listTodo(HttpServletRequest request, HttpServletResponse response)
			throws Exception
{
	List<Todolist> todos = todolistDBUtil.getTodolists();
	request.setAttribute("TODO_LIST", todos);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/Todolist-list.jsp");
	dispatcher.forward(request, response);
}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		todolistDBUtil = new TodolistDBUtil(dataSource);
	}
	
	

}
