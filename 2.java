package com.hello.src;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Threet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Threet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();	
		out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>JOIN OPERATION</title>");            
         out.println("</head>");
         out.println("<body>");	
		try{
			System.out.println("Connecting..............");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loding Drivers!!!!!");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/dml","root","");
			System.out.println("Connected!!!!!!!!!!!!");
            ResultSet rs;
            Statement stmt=connect.createStatement();
			int entry;	
			
			String sql= "select *from a1 natural join a2";
			rs=stmt.executeQuery(sql);
			System.out.println("Done");
			out.print("<table border=1>");
            out.print("<tr>");
            out.print("<td>ID:</td><td>NAME</td><td>ADDRESS</td><td>Dept</td></tr><tr>");
           
			while(rs.next())
            {
				int id=rs.getInt("id");
	            String name=rs.getString("name");
	            String addr=rs.getString("addr");
	            String dept=rs.getString("dept");
	            
                out.print("<tr><td>"+id+"</td><td>" + name +"</td><td>" + addr +"</td><td>"+dept+"</td></tr>");
            }
			out.print("</tr></table>");			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}				
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
