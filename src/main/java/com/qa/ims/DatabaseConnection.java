package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection activeConnection;
	private static final String URL = "jdbc:mysql://localhost/myims?serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "root";
	

	public DatabaseConnection() {
		super();
		initConnection();
	}
	
	private void initConnection() {
		try {
			activeConnection = DriverManager.getConnection(URL, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return activeConnection;
	}
	
	public static void close() {
		try {
			activeConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
