package com.preparedstatement;

import java.sql.*;
import java.util.Scanner;

public class TestPreparedStatement 
{

	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement ptmt = null;
		try
		{
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase","root","admin");
			if(con == null)
			{
				System.out.println("Connection not Established");
			}
			else
			{
				System.out.println("Connection Established ");
			}


			// 			** Creation Of Table **

			/*			
				String sql = "Create table student(id int primary key , name varchar(20) , marks int)";
				ptmt = con.prepareStatement(sql);
				ptmt.executeUpdate();
				System.out.println("Table Is Created....! ");

			 */			
			//statement takes static data and taking data from user is dynamic way  


			//			** Insert Data In Table **

			/*
				String insql = "insert into student (id,name,marks) values(? , ? , ?)";
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

			*/
			
			
			//			** Updattion Of Details **

			/*
				String upsql = "update student set name = ? where id = ? " ;
				ptmt = con.prepareStatement(upsql);
				
				ptmt.setString(1, "Ram");
				ptmt.setInt(2, 101);
				
				ptmt.executeUpdate();	
				System.out.println("Data Is Updated ...!");
			*/
			
			//			** Deletion Of Data **
			
				
				String dsql = "delete from student where id = ?";
				ptmt = con.prepareStatement(dsql);
				
				ptmt.setInt(1, 5);
				ptmt.executeUpdate();
				System.out.println("Data is Deleted From Table ...! ");
				

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}
