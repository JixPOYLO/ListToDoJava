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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.mysql.cj.Session;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HumanDBUtil humanDBUtil;
	
	@Resource(name="jdbc/project1java")
	private DataSource dataSource;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ptnn");System.out.println("laaaa");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/New.jsp");
		dispatcher.forward(request, response);
		//request.getRequestDispatcher("/New.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	String username= request.getParameter("uname");
	String password = request.getParameter("psw");
	//System.out.print(first_Name);
	
	HttpSession session = request.getSession();
	session.setAttribute("uname", username);
	session.setAttribute("psw", password);
	System.out.println("laaaa");
	
	try 
	{
		//check(request,response);
		System.out.println("iciippppp ");
		int checkk = humanDBUtil.checkHuman(username, password);

		//List<Human> humans = humanDBUtil.getHumans();
		//request.setAttribute("HUMAN_LIST", humans);
		if(checkk == 1)
		{

			request.getRequestDispatcher("/helloStudent.jsp").forward(request, response);
			System.out.println("helloooo studennnnt ");

		}
		
		if(checkk == 2)
		{

			request.getRequestDispatcher("/helloInstructor.jsp").forward(request, response);
			System.out.println("helloooo ");

		}
		else 
		{
			
			System.out.println("wrongggg1");
			request.getRequestDispatcher("/wrong.jsp").forward(request, response);
			System.out.println("wrongggg2");
		}
	 
	}
	catch (Exception e)
	{// TODO Auto-generated catch blocke.printStackTrace();
		e.printStackTrace();
	}
	
	
	}
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		humanDBUtil = new HumanDBUtil(dataSource);

	}
	
	
}
