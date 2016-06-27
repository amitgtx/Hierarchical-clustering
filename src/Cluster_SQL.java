import java.io.*;
import java.sql.*;
import java.util.*;
class Cluster_SQL
{
	void compute(Cluster[] clusters)
	{
		try
		{
				String s,t;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOKS","root","root");
				int c=1;
				

				Statement stmt=con.createStatement();

				// s="CREATE TABLE B(NAME VARCHAR(15))";

				// s="INSERT INTO B VALUES('AMIT'),('CHIRAG')";

				// stmt.executeUpdate(s);

				for(int i=0;i<clusters.length;i++)
				{
					ArrayList<Book> temp=clusters[i].getBooks();
					if(temp.size()<10)break;
					s="DROP TABLE IF EXISTS CLUSTER_"+c+"";
					stmt.executeUpdate(s);
					s="CREATE TABLE CLUSTER_"+c+"(BOOK_NAME VARCHAR(1000))";
					stmt.executeUpdate(s);
					for(int j=0;j<temp.size();j++)
					{
						t=temp.get(j).getName();
						t=t.replace("'","\\'");
						s="INSERT INTO CLUSTER_"+c+" VALUES('"+t+"')";
						stmt.executeUpdate(s);
					}
					c++;
				}



				con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}