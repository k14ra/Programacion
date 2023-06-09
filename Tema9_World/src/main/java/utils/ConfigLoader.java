package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigLoader {

	private static Logger logger = LogManager.getLogger(ConfigLoader.class);

	private final String DB_TYPE_DEFAULT = "mysql";
	private final String DB_NAME_DEFAULT = "world";
	private final String DB_URL_DEFAULT = "jdbc:mysql://127.0.0.1:3306/" + DB_NAME_DEFAULT;
	private final String DB_USER_DEFAULT = "root";
	private final String DB_PASS_DEFAULT = "";
	

	private String db_type;
	private String db_name;
	private String db_url;
	private String db_user;
	private String db_pass;
	

	private Path configFile = Paths.get("config/config.txt");

	// Específico del singleton

	// Instancia de él mismo
	private static ConfigLoader instance;

	// Método para recuperar el objeto
	public static synchronized ConfigLoader getInstance() {
		if (instance == null) {
			instance = new ConfigLoader();
		}

		return instance;
	}

	// Constructor siempre privado en un singleton
	private ConfigLoader() {
		// Esto cambia de un singleton a otro
		logger.info("Obteniendo la información de la configuración...");

		try (BufferedReader br = Files.newBufferedReader(configFile, StandardCharsets.UTF_8)) {
			
			String line =null;
			while((line = br.readLine()) != null ) {
				String[] configLine = line.split("=");
				switch (configLine[0]) {
				case "db_type":
					if(configLine[1].isEmpty()) {
						this.db_type = DB_TYPE_DEFAULT;
					} else {						
						this.db_type = configLine[1];
					}
					break;
				case "db_url":
					if(configLine[1].isEmpty()) {
						this.db_url = DB_URL_DEFAULT;
					} else {						
						this.db_url = configLine[1];
					}
					break;
				case "db_name":
					if(configLine[1].isEmpty()) {
						this.db_name = DB_NAME_DEFAULT;
					} else {						
						this.db_name = configLine[1];
					}
					break;
				case "db_user":
					if(configLine[1].isEmpty()) {
						this.db_user = DB_USER_DEFAULT;
					} else {						
						this.db_user = configLine[1];
					}
					break;
				case "db_pass":
					if(configLine[1].isEmpty()) {
						this.db_pass = DB_PASS_DEFAULT;
					} else {						
						this.db_pass = configLine[1];
					}
					break;
				}
			}

			logger.info("Configuración leída con éxito");
		} catch (IOException e) {
			logger.error("Error al leer el fichero de configuración", e);
		}
	}
	
	public String getDb_type() {
		return db_type;
	}

	public String getDb_name() {
		return db_name;
	}

	public String getDb_url() {
		return db_url;
	}

	public String getDb_user() {
		return db_user;
	}

	public String getDb_pass() {
		return db_pass;
	}

	

}
