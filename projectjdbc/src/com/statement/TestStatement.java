package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestStatement 
{
	static Connection con ;
	Statement stmt = null;
	
	public static Connection conn() throws ClassNotFoundException , SQLException
	{	
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
		return con;
	}
	public void createTable() throws SQLException
	{
		String sql = "create table employee1(id int primary key , name varchar(20) , salary int)";
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println(" Table Created : ");
	}

	public void insertData() throws ClassNotFoundException, SQLException
	{
		
		String sql = "insert into employee1(id,name,salary) values (1,'Sam',35000),(2,'sia',25000),(3,'Veer',35000)";
		stmt = conn().createStatement();
		stmt.executeUpdate(sql);
		System.out.println(" Inserted data : ");
	}
	
	public void updateTable() throws SQLException
	{
		String sql = "update employee1 set name='Ram',salary = 40000 where id = 1";
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println(" Data Updated : ");
	}
	
	public void deleteRecord() throws SQLException
	{
		String sql = "delete from employee1 where id=1";
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println(" Record Deleted from db ");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		TestStatement t = new TestStatement();
		t.conn();
		
	
		String ch;
		do
		{
			System.out.println("1.Table Creation :");
			System.out.println("2.Insert A Record In Table :");
			System.out.println("3.Update Record In Table  :");
			System.out.println("4.Delete Record From Table  :");
			System.out.println("5.Exit :");
			Scanner sc = new Scanner(System.in);
			System.out.println("\n \n ");
			
			int choice;
			
			System.out.println("Enter Your Choice :");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1 : 
					t.createTable();
					break;
			case 2:
					t.insertData();
					break;
			case 3:
					t.updateTable();
					break;
			case 4:
					t.deleteRecord();
					break;
			case 5:
					System.exit(0);
			default :
					System.out.println("Wrong Choice : ");
			}
			System.out.println("Do you want to Continue ...Yes or No ");
			ch = sc.next();
		}
		while(ch.equals("yes"));
		
		
	}
}
		/*
		 *Class.forName("com.mysql.jdbc.Driver");
		 *Connection con = DriverManager.getConnection("jdbc:mysql:\\localhost:3306\\demo\\root\\admin");
		 */

		//Class.forName("com.mysql.jdbc.Driver");
		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase","root","admin");
		
		
		//		* Create Table *
		/*
			String sql = "create table employee(id int primary key , name varchar(20) , salary int)";
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("table Created : ");
		 */	

		//			* Insert Data in Table *
		/*
			String in = "insert into employee(id,name,salary) values (5,'Sam',35000),(6,'sia',25000)";
			stmt = con.createStatement();
			stmt.executeUpdate(in);
			System.out.println("Inserted data : ");
		*/
		
		//			* Update Data in Table *
		//String up = "update employee set name='Jazz' where id = 1";
		//String up = "update employee set name='Bharat', salary = 40000 where id=2";
		/*
			String up = "update employee set name='Ram',salary = 40000 where id = 3";
			stmt = con.createStatement();
			stmt.executeUpdate(up);
			System.out.println("Data Updated : ");
		 */
		
		//			* Delete Data from Table *
		/*	
		 	String del = "delete from employee where id=1";
			stmt = con.createStatement();
			stmt.executeUpdate(del);
			System.out.println("Record Deleted from db ");
		*/
	
	//maven repository -> mysql connector -> select version according to mysql ->
	//5.1.13 then click on jar and download 

