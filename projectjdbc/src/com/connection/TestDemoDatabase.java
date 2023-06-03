package com.connection;

import java.sql.*;

public class TestDemoDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		Statement stmt = null;
		
		 Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase","root","admin");
		 if(con == null)
			{
				System.out.println("Connection not Established : ");
			}
			else
			{
				System.out.println("Connection Established : ");
			}

		
		//		* Create Table *
		
			String sql = "create table employee(id int primary key , name varchar(20) , salary int)";
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("table Created : ");
		

		//			* Insert Data in Table *
		
			String in = "insert into employee(id,name,salary) values (5,'Sam',35000),(6,'sia',25000)";
			stmt = con.createStatement();
			stmt.executeUpdate(in);
			System.out.println("Inserted data : ");
		
		
		//			* Update Data in Table *
		//String up = "update employee set name='Jazz' where id = 1";
		//String up = "update employee set name='Bharat', salary = 40000 where id=2";
		
			String up = "update employee set name='Ram',salary = 40000 where id = 3";
			stmt = con.createStatement();
			stmt.executeUpdate(up);
			System.out.println("Data Updated : ");
		 
		
		//			* Delete Data from Table *
			
		 	String del = "delete from employee where id=1";
			stmt = con.createStatement();
			stmt.executeUpdate(del);
			System.out.println("Record Deleted from db ");
		 
	
	//maven repository -> mysql connector -> select version according to mysql ->
	//5.1.13 then click on jar and download 


	}

}
