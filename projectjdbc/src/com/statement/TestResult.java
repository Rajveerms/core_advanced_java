package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestResult
{
	static Connection con ;
	Statement stmt = null;
	ResultSet rs = null;
	
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
	
	public void displayData() throws SQLException
	{

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
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		TestResult t = new TestResult();
		t.conn();
		
	
		String ch;
		do
		{
			System.out.println("1.Table Creation :");
			System.out.println("2.Insert A Record In Table :");
			System.out.println("3.Update Record In Table  :");
			System.out.println("4.Delete Record From Table  :");
			System.out.println("5.Display Record From Table  :");
			System.out.println("6.Exit :");
			
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
			case 5 :
					t.displayData();
					break;
			case 6:
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
