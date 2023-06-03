package com.preparedstatement;

import java.sql.*;
import java.util.Scanner;

public class TestPreparedMethod 
{
	static Connection con = null ;
	static PreparedStatement ptmt = null;
	
	// 				** Connection With Database **
	public static Connection conn() throws SQLException
	{
	
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase","root","admin");
		if(con == null)
		{
			System.out.println("Connection not Established");
		}
		else
		{
			System.out.println("Connection Established ");
		}
		
		return con;
	}

	// 				** Creation Of Table **
	public static void create() throws SQLException
	{
		String sql = "Create table stu(id int primary key , name varchar(20) , marks int)";
		ptmt = con.prepareStatement(sql);
		ptmt.executeUpdate();
		System.out.println("Table Is Created....! ");
	}

	// 				** Insert Data in Table **
	public static void insert() throws SQLException
	{
		String insql = "insert into stu (id,name,marks) values(? , ? , ?)";
		ptmt = con.prepareStatement(insql);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter How Many Student Data You Want : ");
		int num = sc.nextInt();
		
		for(int i = 1 ; i <= num ; i++)
		{
		
			System.out.println("\n Insert id : ");
			int id = sc.nextInt();
			
			System.out.println("\n Insert Name : ");
			String name = sc.next();

			System.out.println("\n Insert Marks :");
			int marks = sc.nextInt();
		
			
			ptmt.setInt(1, id);
			ptmt.setString(2, name);
			ptmt.setInt(3, marks);
			ptmt.executeUpdate();
		}
		
		System.out.println("Data Is Inserted In Table...!");
	}

	// 				** Update Data in Table **
	public static void update() throws SQLException
	{
		String upsql = "update stu set name = ? where id = ? " ;
		ptmt = con.prepareStatement(upsql);
		
		ptmt.setString(1, "Sia");
		ptmt.setInt(2, 1);
		
		ptmt.executeUpdate();	
		System.out.println("Data Is Updated ...!");
	}

	// 				** Delete Records in Table **
	public static void delete() throws SQLException
	{
		String dsql = "delete from stu where id = ?";
		ptmt = con.prepareStatement(dsql) ;
		
		ptmt.setInt(1, 5);
		ptmt.executeUpdate();
		System.out.println("Data is Deleted From Table ...! ");
	}



	public static void main(String[] args) 
	{
		
		try
		{
			conn();
			String s;

			do
			{
				//		** Creation Of Menu **
				System.out.println("1. Create Table : ");
				System.out.println("2. Insert Data  : ");
				System.out.println("3. Update Data  : ");
				System.out.println("4. Delete Data  : ");
				System.out.println("5. Exit 		: ");
	
				System.out.println(" \n ");
	
				// Enter the operataion to perform 
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Your Choice .. ");
				int ch = sc.nextInt();
					
				//		** Switch For Selection of menu **
				switch(ch)
				{
					case 1:
						create();
						break;
					case 2:
						insert();
						break;
					case 3:
						update();
						break;
					case 4:
						delete();
						break;
					case 5:
						//System.out.println("System is Exit..!");
						System.exit(0);
					default:
						System.out.println("Enter Choice Is Wrong ....!");
	
				}
				
				//		** Do We Want TO Continue or Not **
				System.out.println("Do you want to continue ... yes or no : ");
				s = sc.next();
			}
			while(s.equals("yes"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
