package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.models.Client;

public class ConnectToDB{
	
	 

	  final static private String host = "localhost:3306";
	  final static private String user = "root";
	  final static private String passwd = "a789*789";
	  private static Connection connection=null;
	  
	  
	  
	public static void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			ConnectToDB.connection=DriverManager.getConnection(  
			  "jdbc:mysql://"+host+"/clientappdb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",user,passwd); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	public static ResultSet execute(String sqlQuery) throws SQLException {
		Statement stmt= connection.createStatement();  
	     ResultSet rs=stmt.executeQuery(sqlQuery);  
	     return rs;
	}
	
	  }

