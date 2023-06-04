package repository;

import java.util.ArrayList;

import dao.CountryDAO;
import dao.CountryDAOMysql;
import model.Country;

public class CountryRespository {

	private CountryDAO dao;
	private static CountryRespository instance;
	
	public static CountryRespository getInstance() {
		if(instance == null) {
			instance = new CountryRespository();
		} return instance;
	}
	
	private CountryRespository() {
		dao = new CountryDAOMysql();
	}
	
	public ArrayList<Country> getAll() {
		return dao.getAll();
	}

	public boolean existePais(String name) {
		return dao.existePais(name);
	}

}
