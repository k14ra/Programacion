package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigLoader {

	private String db_url;
	private String db_ip;
	private String db_port;
	private String db_name;
	private String db_user;
	private String db_pass;
	
	private static ConfigLoader instance;
	
	Path ruta = Paths.get("Ficheros/config.txt");
	
	public static synchronized ConfigLoader getInstance() {
		if(instance == null) {
			instance = new ConfigLoader();
		} return instance;
	}
	
	private ConfigLoader() {
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
			e.printStackTrace();
		}
	}

	public String getDb_url() {
		return db_url;
	}

	public String getDb_ip() {
		return db_ip;
	}

	public String getDb_port() {
		return db_port;
	}

	public String getDb_name() {
		return db_name;
	}

	public String getDb_user() {
		return db_user;
	}

	public String getDb_pass() {
		return db_pass;
	}
	
}
