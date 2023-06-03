package com.preparedstatement;

//result set using prepared statement
import java.sql.*;

public class TestResultSet {

	public static void main(String[] args) {
		Connection con = null ;
		PreparedStatement ptmt = null;
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
			
			System.out.println(" \n ");
			
			ptmt = con.prepareStatement(" Select * from employee1 ");
			rs = ptmt.executeQuery();
			
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
