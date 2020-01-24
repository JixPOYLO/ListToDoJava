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
 * Servlet implementation class HumanControllerServlet
 */
@WebServlet("/HumanControllerServlet")
public class HumanControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HumanDBUtil humanDBUtil;
	
	@Resource(name="jdbc/project1java")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try 
		{
			listHumans(request,response);
		 
		}
		catch (Exception e)
		{// TODO Auto-generated catch blocke.printStackTrace();
			e.printStackTrace();
		}
		
	}
	
	private void listHumans(HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
	List<Human> humans = humanDBUtil.getHumans();
	request.setAttribute("HUMAN_LIST", humans);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/list-human.jsp");
	dispatcher.forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		humanDBUtil = new HumanDBUtil(dataSource);

	}
	

	
	

}
