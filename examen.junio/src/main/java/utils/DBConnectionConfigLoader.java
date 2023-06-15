package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionConfigLoader {

	private Connection conn;
	private static DBConnectionConfigLoader instance;

	public static synchronized DBConnectionConfigLoader getInstance() {
		if (instance == null) {
			instance = new DBConnectionConfigLoader();
		}
		return instance;
	}

	private DBConnectionConfigLoader() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String db_url = ConfigLoader.getInstance().getDb_url() + ConfigLoader.getInstance().getDb_name();
		String db_user = ConfigLoader.getInstance().getDb_user();
		String db_pass = ConfigLoader.getInstance().getDb_pass();

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
