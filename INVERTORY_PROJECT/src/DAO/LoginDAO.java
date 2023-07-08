package DAO;
import Model.Login;

import java.sql.*;
import connectionManager.ConnectionManger;


public class LoginDAO 
{
	     public boolean validate(Login login) throws ClassNotFoundException, SQLException 
	     {
	    	 //1.user input
	    	String username =login.getUsername();
	    	String password = login.getPassword();
	    	//connect java and jdbc
	    	ConnectionManger conm =  new ConnectionManger();
	    	Connection con = conm.establishconnection();
	    	
	    	//1.Declare statement class
	    	Statement st = con. createStatement();
	    	
	    	//2.write query
	    	ResultSet rt=st.executeQuery("select*from Login");
	    	
	    	//check username and passowrd
	    	while(rt.next())
	    	{
	    	if(username.equals(rt.getString("username"))&& password.equals(rt.getString("password")))
	    	  {
	    		conm.closeconnection();
	    		return true;
	    	  }
	    	}
	    	conm.closeconnection();
	    		return false;
	    	 
	    	 
		}
	
	     }

