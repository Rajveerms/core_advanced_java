package com.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;





public class TestTransaction {

	public static void main(String[] args) {
	
		Connection con=null;
PreparedStatement ptmt=null;
		ResultSet rs=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase","root","admin");
		if(con==null)
		 System.out.println("connection not established");
		else
			System.out.println("connection  established");
		
		/*
		
		String q="create table customers(id int primary key, name varchar(20))";
		ptmt=con.prepareStatement(q);
		ptmt.executeUpdate();
		
		System.out.println("Table created");
		
		*/
		//insert records 
		String q1="insert into customers values(?,?)";
		
		ptmt=con.prepareStatement(q1);
		con.setAutoCommit(false);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many student u want");
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter id,name ");
			int id=sc.nextInt();
			String  name=sc.next();
			
			ptmt.setInt(1, id);
			ptmt.setString(2, name);
			ptmt.executeUpdate();
			
			System.out.println("commit/rollback");
			String change=sc.next();
			if(change.equals("commit")) {
				con.commit();
			}
			if(change.equals("rollback")) {
				con.rollback();
			}
			
			
			ptmt=con.prepareStatement("select *  from cuxtomers");
			rs=ptmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+""+rs.getString(2));
				
			}
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		
			
			}
			
			
		

}
}


}
}

