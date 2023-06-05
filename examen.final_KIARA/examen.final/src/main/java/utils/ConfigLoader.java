package utils;

import java.io.BufferedReader;
import java.io.IOException;
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

	public static synchronized ConfigLoader getInstance() {
		if (instance == null) {
			instance = new ConfigLoader();
		}
		return instance;
	}

	private ConfigLoader() {
		Path ruta = Paths.get("Ficheros/config.txt");
		
		try(BufferedReader br = Files.newBufferedReader(ruta)){
			String lineaTexto = null;
			
			while((lineaTexto = br.readLine()) != null){
				String[] filtro = lineaTexto.split("[@]");
				switch(filtro[0]) {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getDb_url() {
		return db_url;
	}

	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}

	public String getDb_ip() {
		return db_ip;
	}

	public void setDb_ip(String db_ip) {
		this.db_ip = db_ip;
	}

	public String getDb_port() {
		return db_port;
	}

	public void setDb_port(String db_port) {
		this.db_port = db_port;
	}

	public String getDb_name() {
		return db_name;
	}

	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}

	public String getDb_user() {
		return db_user;
	}

	public void setDb_user(String db_user) {
		this.db_user = db_user;
	}

	public String getDb_pass() {
		return db_pass;
	}

	public void setDb_pass(String db_pass) {
		this.db_pass = db_pass;
	}


}