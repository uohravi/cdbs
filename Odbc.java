import java.sql.*;
import java.net.*;
import javax.swing.*;

public class Odbc
{
	public static Connection conn;
	public static Statement stat;
	
	public static Statement getStatement()
	{
		try
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:home","system","manager");
				stat=conn.createStatement();	
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error in Creating Connection","Database Error",JOptionPane.ERROR_MESSAGE);
			}	
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Not connected to Database","DataBase Error",JOptionPane.ERROR_MESSAGE);
		}
		return(stat);
	}
	
	public static Connection getConnection()
	{
		return(conn);
	}
}