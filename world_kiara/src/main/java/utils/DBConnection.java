package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection conn;
	private static DBConnection instance;
	
	public static synchronized DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		} return instance;
	}
	
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//String db_type = "mysql";
		String db_name = "world";
		String db_url = "jdbc:mysql://127.0.0.1:3306/" + db_name;
		String db_user = "root";
		String db_pass = "";
		
		try {
			conn = DriverManager.getConnection(db_url, db_user, db_pass);
			System.out.println("Conexion creada con exito.");
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
		System.out.println("Conexion CERRADA.");
	}
}
