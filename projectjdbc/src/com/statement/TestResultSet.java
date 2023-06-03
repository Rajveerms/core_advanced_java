package com.statement;

import java.sql.*;
// result set using statement

public class TestResultSet 
{

	public static void main(String[] args) 
	{
		Connection con = null ;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase","root","admin");
			
			if(con == null)
			{
				System.out.println("Connection Not Estalished :");
			}
			else
			{
				System.out.println("Connection Is Established : ");
			}
			
			
			stmt = con.createStatement();
			String s = " Select * from employee1 ";
			rs = stmt.executeQuery(s);
			
			System.out.println("\n ");
			
			System.out.println("ID    " +"  NAME   "+"   SALARY ");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"    ::    "
								   +rs.getString(2)+"   ::    " 
								   +rs.getInt(3));
			}
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}
