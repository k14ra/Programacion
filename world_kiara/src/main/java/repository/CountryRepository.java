package repository;

import java.util.ArrayList;

import dao.CountryDAO;
import dao.CountryDAOMysql;
import model.City;
import model.Country;

public class CountryRepository {

	private CountryDAO dao;
	private static CountryRepository instance;
	
	public static CountryRepository getInstance() {
		if(instance == null) {
			instance = new CountryRepository();
		} return instance;
	}
	
	private CountryRepository() {
		dao = new CountryDAOMysql();
	}
	
	public ArrayList<Country> getAll() {
		return dao.getAll();
	}

	public boolean existePais(String name) {
		return dao.existePais(name);
	}

	public Country encontrarPais(String codigoPais) {
		return dao.encontrarPais(codigoPais);
	}

}
