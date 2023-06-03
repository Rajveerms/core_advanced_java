package com.collablestatement;

import java.sql.*;

public class TestCollableStatement 
{

	public static void main(String[] args) throws SQLException 
	{
		Connection con = null;
		CallableStatement ctmt = null;


		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase","root","admin");
			if(con==null)
			{
				System.out.println("	** connection not established **	 ");
			}
			else
			{
				System.out.println("      ** connection established **    ");
			}

			ctmt = con.prepareCall("{call insertData(?,?,?)} ");
			ctmt.setInt(1, 101);
			ctmt.setString(2, "Bharat");
			ctmt.setInt(3, 45000);
			
			ctmt.executeUpdate();
			System.out.println("Data in Inserted In Table using :  procedure :  ");


		}
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();	
			ctmt.close();
		}

	}
}

