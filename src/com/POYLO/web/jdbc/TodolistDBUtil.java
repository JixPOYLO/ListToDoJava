package com.POYLO.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TodolistDBUtil {

	public TodolistDBUtil(DataSource dataSource)
	{
		super();
		this.dataSource = dataSource;
	}
	
	private DataSource dataSource;
	
	public List<Todolist> getTodolists() throws Exception 
	{
		List<Todolist> todo= new ArrayList<Todolist>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		
		try 
		{
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todolist ";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next())
			{
				int id = myRs.getInt("id");
				String description=myRs.getString("description");
				//boolean done =myRs.getBoolean("done");
			
				Todolist tempTodo= new Todolist(id,description);
				todo.add(tempTodo);
			}
			return todo;
		}
		 finally
		 {
			 close(myConn,myStmt,myRs);
		 
		 }
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) 
	{
		try
		{
			if(myStmt!=null)myStmt.close();
			if(myRs!=null)myRs.close();
			if(myConn!=null)myConn.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
