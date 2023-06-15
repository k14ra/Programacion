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

	private Connection conn;
	private static DBConnection instance;

	private String db_url;
	private String db_ip;
	private String db_port;
	private String db_name;
	private String db_user;
	private String db_pass;
	
	private static final String RUTA = "Ficheros/";
	private static final String DELIMITER = "@";

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
			fillConfig();
			conn = DriverManager.getConnection(db_url+db_ip + ":" + db_port + "/" + db_name, db_user, db_pass);
			System.out.println("Conexion creada.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ConfigException e) {
			throw new ConfigException("Error al crear la conexion", e);
		}
	}
	
	public Connection getConnection() {
		return conn;
	}

	public void fillConfig() throws ConfigException {
		Path configFile = Paths.get(RUTA + "/config.txt");
		
		try (BufferedReader br = Files.newBufferedReader(configFile, StandardCharsets.UTF_8);){
			System.out.println("Lectura del fichero de configuracion de BD...");

			String line = null;
			while((line = br.readLine()) != null){
				String filtro[] = line.split(DELIMITER);
				switch (filtro[0]) {
				case "url":
					if(filtro.length == 2) {
						db_url = filtro[1].trim();
					}
					break;
				case "ip":
					if(filtro.length == 2) {
						db_ip = filtro[1].trim();
					}
					break;
				case "port":
					if(filtro.length == 2) {
						db_port = filtro[1].trim();
					}
					break;
				case "dbName":
					if(filtro.length == 2) {
						db_name = filtro[1].trim();
					}
					break;
				case "user":
					if(filtro.length == 2) {
						db_user = filtro[1].trim();
					}
					break;
				case "pass":
					if(filtro.length == 2) {
						db_pass = filtro[1].trim();
					}
					break;
				}
			}
			
			System.out.println("FIN lectura del fichero de configuracion de BD.");
		} catch (IOException e) {
			throw new ConfigException("Error al leer el fichero de configuracion de la BD", e);
		}
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
