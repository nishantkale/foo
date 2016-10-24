package prog1;
import java.sql.*;
public class simple {

	public static void main(String[] args) 
	{ 
		try
			{
	    	 Class.forName("com.mysql.jdbc.Driver");
	    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prog1","root","");
	    	 Statement stmt=con.createStatement();
	    	 
	    	 //stmt.executeUpdate("create index a1index2 on a1(id)");
	    	 //stmt.executeUpdate("create view nlk as select id,name from a1");
	    	 //stmt.executeUpdate("insert into a1(id,name,dept)values(6,'santosh','comp')");
	    	 //stmt.executeUpdate("update a1 set name='pari' where id=2");
	    	 //stmt.executeUpdate("delete from a1 where id=4");
	    	 //ResultSet rs=stmt.executeQuery("select * from a1");
	    	 //ResultSet rs=stmt.executeQuery("select * from nlk");
	    	 ResultSet rs=stmt.executeQuery("show index from a1");

	    	 ResultSetMetaData rm=rs.getMetaData();
	    	 int n=rm.getColumnCount();
	    	 for(int i=1;i<=n;i++)
	    	 {
	    		 System.out.print(rm.getColumnName(i)+"\t");
	    	 }
	    	 System.out.println();
	    	 while(rs.next())
	    	 {
	    		 for(int i=1;i<=n;i++)
	    		 {
	    			 System.out.print(rs.getString(i)+"\t");
	    		 }
	    		 System.out.println();
	    	 }
	         
	     }catch(Exception e)
	     {
	    	 System.err.println(e);
	     }
	}

}
