import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;

public class myExecutor
{
	public static int processQuery(String Query)
	{
		String url = "jdbc:mysql://localhost:3306/dbProjectData";
		int affected_rows = 0;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,"root","system");

			Statement st = con.createStatement();

			affected_rows = st.executeUpdate(Query);

			st.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);

		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

		return affected_rows;
	}

	public static String[] getSingleRow(String Query, int ColumnCount)
	{
		String url = "jdbc:mysql://localhost:3306/dbProjectData";
		int value = 0;
		Vector <String> v = new Vector <String>();

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,"root","system");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(Query);

			if(rs.next())
			{
				for(int i=0;i<ColumnCount;i++)
				{
					v.addElement(rs.getString(i+1));
				}
			}
			st.close();
			rs.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

		String[] values = v.toArray(new String[v.size()]) ;

		return(values);
	}

}