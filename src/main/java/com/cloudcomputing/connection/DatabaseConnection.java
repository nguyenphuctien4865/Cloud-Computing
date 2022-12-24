package com.cloudcomputing.connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cloudcomputingdb","root","123");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* Check databaseConnection */
	
//	public static void main(String[] args) {
//		try {
//			new DatabaseConnection();
//			System.out.println(	DatabaseConnection.initializeDatabase());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	} 
}
