package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection conn;
	private static DBConnection instance;

	public static synchronized DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/*
		String db_url = ConfigLoader.getInstance().getDb_url() + 
				ConfigLoader.getInstance().getDb_ip() + ":" +
				ConfigLoader.getInstance().getDb_port() + "/" +
				ConfigLoader.getInstance().getDb_name();
		String db_user = ConfigLoader.getInstance().getDb_user();
		String db_pass = ConfigLoader.getInstance().getDb_pass();
		*/
		
		String db_url = "jdbc:mysql://127.0.0.1:3306/world";
		String db_user = "root";
		String db_pass = "";
		
		try {
			conn = DriverManager.getConnection(db_url, db_user, db_pass);
			System.out.println("Conexion creada.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}

	public void destroyConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance = null;
		}
		System.out.println("Conexion cerrada.");
	}

}
