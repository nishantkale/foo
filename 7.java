package com.src.pkg;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DML_Queries extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public DML_Queries() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>INSERT OPERATION</title>");            
         out.println("</head>");
         out.println("<body>");
		
		
		
		
		
		try{
			System.out.println("Connecting..............");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loding Drivers!!!!!");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/DML","root","");
			System.out.println("Connected!!!!!!!!!!!!");
			
            ResultSet rs;
            Statement stmt=connect.createStatement();
			int entry;
			
			
			String table=" create table if not exists  student (id int , name varchar(25), dept varchar(25))";
			entry=stmt.executeUpdate(table);
			System.out.println("Table Created!");
			String table1=" create table if not exists  student1 (id int , name varchar(25), dept varchar(25))";
			entry=stmt.executeUpdate(table1);
			System.out.println("Table Created!");
			String insert="INSERT INTO student(id,name,dept) values(7,'amit','Computer')";
			entry=stmt.executeUpdate(insert);
			System.out.println("Value Inserted!");
			
			//Updation
			String update=" update student name set name='kiran' where dept='comp'";
			entry=stmt.executeUpdate(update);
			System.out.println("Value Updated!");
			
			//Deletion
			String delete="delete from student where id=1";
			entry=stmt.executeUpdate(delete);
			System.out.println("Value Deleted!");
			
			//drop table
			String drop="drop table student1";
			entry=stmt.executeUpdate(drop);
			System.out.println("Value Deleted!");
			
			
			//display
			String sql= "select *from student";
			rs=stmt.executeQuery(sql);
			System.out.println("Done");
			out.print("<table border=1>");
            out.print("<tr>");
            out.print("<td>ID:</td><td>NAME</td><td>DEPT</td></tr><tr>");
            
            PreparedStatement ps =connect.prepareStatement("insert into student values(34,'kiran','comp')");
			ps.execute();
			while(rs.next())
            {
				int id=rs.getInt("id");
	            String name=rs.getString("name");
	            String dept=rs.getString("dept");
                out.print("<tr><td>"+id+"</td><td>" + name +"</td><td>"+dept+"</td></tr>");
            }
			out.print("</tr></table>");
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
			
	}
	
	
	
{
		
		
	}
	 /* PrintWriter out=response.getWriter();
		out.println("Hello Servlets");
		*/

}