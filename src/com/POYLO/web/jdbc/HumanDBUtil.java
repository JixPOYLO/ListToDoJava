package com.POYLO.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class HumanDBUtil {
	public HumanDBUtil(DataSource dataSource)
	{
		super();
		this.dataSource = dataSource;
	}
	
	private DataSource dataSource;
	
	public List<Human> getHumans() throws Exception 
	{
		List<Human> humans= new ArrayList<Human>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		
		try 
		{
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from human order by last_name";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next())
			{
				int id = myRs.getInt("id");
				String firstName=myRs.getString("first_name");
				String lastName=myRs.getString("last_name");
				String statut = myRs.getString("statut");
				Human tempHuman= new Human(id,firstName,lastName,statut);
				humans.add(tempHuman);
			}
			return humans;
		}
		 finally
		 {
			 close(myConn,myStmt,myRs);
		 
		 }
		
		
	}
	
	public int checkHuman(String username , String password) throws Exception 
	{

		int valid = 0;
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		
		try 
		{
			System.out.println("entryyyyy ");
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select statut from human where first_name = '"+username+"' and last_name = '"+password+"'" ;
			System.out.println(sql);

			myRs = myStmt.executeQuery(sql);
			int nb=0;
			String statut = "";
			
			while(myRs.next())
			{
				nb++;
				statut = myRs.getString("statut");
				System.out.println(nb);
				
			}
			
			if( nb == 1 )
			{
				System.out.println("account exists ");
				
				if (statut == "student")
				{
					valid = 1;
				}
				
				if (statut == "instructor")
				{
					valid = 2;
				}
				
			}
			
			return valid;
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
