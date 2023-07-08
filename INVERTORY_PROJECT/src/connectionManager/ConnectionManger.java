package connectionManager;
import java.sql.*;
public class ConnectionManger 
{
	        Connection con = null;
	        public Connection establishconnection() throws SQLException, ClassNotFoundException
	        {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventeryProject","root","krish13@");
	        return con;
	        }
	        public void closeconnection() throws SQLException
	        {
	        	con.close();
	        }
	}



