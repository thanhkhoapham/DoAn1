package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static ConnectDB instance;
	private Connection connection;
	
	private ConnectDB() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyDKHP3";
		try {
			connection = DriverManager.getConnection(url , "sa", "123");
			System.out.println("Connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static ConnectDB getInstance() {
		if(instance == null)
			instance = new ConnectDB();
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
