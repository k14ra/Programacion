package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// para el fill config:
	private String db_url;
	private String db_ip;
	private String db_port;
	private String db_name;
	private String db_user;
	private String db_pass;

	// "hardcodeado"
//	private final String DB_NAME = "world";
//	private final String URL = "jdbc:mysql://127.0.0.1:3306/" + DB_NAME;
//	private final String USER = "root";
//	private final String PASS = "";

	private static DBConnection instance;
	private Connection conn;

	public static synchronized DBConnection getInstance() throws ConfigException {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	private DBConnection() throws ConfigException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// hardcodeado:
//			conn = DriverManager.getConnection(URL, USER, PASS);
//			System.out.println("Conexion creada con exito");

			fillconfig();
			conn = DriverManager.getConnection(db_url+db_ip + ":" + db_port + "/" +
			db_name, db_user, db_pass);
			System.out.println("Conexion creada con exito");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void fillconfig() throws ConfigException {
		Path ruta = Paths.get("Ficheros/config.txt");

		try (BufferedReader br = Files.newBufferedReader(ruta, StandardCharsets.UTF_8);) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String filtro[] = line.split("@");
				switch (filtro[0]) {
				case "url":
					if (filtro.length == 2) {
						db_url = filtro[1].trim();
					}
					break;
				case "ip":
					if (filtro.length == 2) {
						db_ip = filtro[1].trim();
					}
					break;
				case "port":
					if (filtro.length == 2) {
						db_port = filtro[1].trim();
					}
					break;
				case "dbName":
					if (filtro.length == 2) {
						db_name = filtro[1].trim();
					}
					break;
				case "user":
					if (filtro.length == 2) {
						db_user = filtro[1].trim();
					}
					break;
				case "pass":
					if (filtro.length == 2) {
						db_pass = filtro[1].trim();
					}
					break;
				}
			}
		} catch (IOException e) {
			throw new ConfigException("Error al leer la configuracion", e);
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
