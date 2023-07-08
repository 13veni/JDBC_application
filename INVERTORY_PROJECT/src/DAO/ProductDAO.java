package DAO;

import java.sql.*;



import Model.Product;
import connectionManager.ConnectionManger;
public class ProductDAO 
{
     public void addProduct1(Product product) throws ClassNotFoundException, SQLException
     {
    	 ConnectionManger conm =  new ConnectionManger();
	    	Connection con = conm.establishconnection();
	    	String sql_query ="insert into product(productId,productName,minSellQuantity,price,quantity) values(?,?,?,?,?)";  
	    	PreparedStatement ps = con.prepareStatement(sql_query);
	    	ps.setInt(1,product.getProductId());
	    	ps.setString(2,product.getProductName());
	    	ps.setInt(3, product.getMinSellQuantity());
	    	ps.setInt(4, product.getPrice());
	    	ps.setInt(5,product.getQuantity());
	    	
	    	ps.executeUpdate();
	    	conm.closeconnection();
	    	
	    	
     }
     public void display() throws ClassNotFoundException, SQLException
     {
    	 ConnectionManger conm =  new ConnectionManger();
	    	Connection con = conm.establishconnection();
	    	
	    	//1.Declare statement class
	    	Statement st = con. createStatement();
	    	
	    	//2.write query
	    	ResultSet rt=st.executeQuery("select*from Product");
	    	
	    	//check username and passowrd
	    	while(rt.next())
	    	{
	    		System.out.println(rt.getInt("productId")+" | "+rt.getString("productName")+" | "+rt.getInt("minSellQuantity")+" | "+rt.getInt("price")+" | "+rt.getInt("quantity")+" | ");            
	    	}
	    	conm.closeconnection();
     }

	
	}

