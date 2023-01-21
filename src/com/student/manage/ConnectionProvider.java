package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con; 
	public static Connection createConnection () {
		try {
		//Load the driver:
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// create the connection:
		String user = "root";
		String pswd = "root";
		String url = "jdbc:mysql://localhost:3306/student_manage";
		
		con = DriverManager.getConnection(url, user, pswd);
		
		// Checking if the connection is created
		System.out.println(
				con.isClosed() ? 
						"Connection is closed!!":
						"Connection is created!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
