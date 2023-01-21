package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	public static boolean insertStudentToDB (Student student) {
		
		boolean status = false;
		
		try {
			Connection con = ConnectionProvider.createConnection();
			String q = "insert into students(sname, sphone, scity) values (?, ?, ?)";
			
			PreparedStatement statement = con.prepareStatement(q);
			
			statement.setString(1, student.getStudentName());
			statement.setString(2, student.getStudentPhone());
			statement.setString(3, student.getStudentCity());
			
			statement.executeUpdate();
			status=true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean deleteStudentUsingId(int userId) {
		boolean status = false;
		try {
			Connection con = ConnectionProvider.createConnection();
			String q = "delete from students where sid = ?";
			
			PreparedStatement statement = con.prepareStatement(q);
			statement.setInt(1, userId);
			statement.executeUpdate();
			status=true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
		
	}

	public static void showAllStudents() {
		try {
			Connection con = ConnectionProvider.createConnection();
			String q = "select * from students";
			
			Statement statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(q);
			while (result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				String phone = result.getString(3);
				String city = result.getString(4);
				
				System.out.println("id: "+ id 
						+ " Name: " + name 
						+ " Phone: " + phone 
						+ " City: "+ city);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
