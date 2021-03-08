package com.ltts.connec;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	public static Connection getConnection() throws Exception
	{
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MiniProject","root","admin");
		return c;
		
	}
	
}
