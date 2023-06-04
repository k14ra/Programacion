package repository;

import java.util.ArrayList;

import dao.CityDAO;
import dao.CityDAOMysql;
import model.City;

public class CityRepository {

	private CityDAO dao;
	private static CityRepository instance;
	
	public static CityRepository getInstance() {
		if(instance == null) {
			instance = new CityRepository();
		} return instance;
	}
	
	private CityRepository() {
		dao = new CityDAOMysql();	
	}
	
	public ArrayList<City> getAll() {
		return dao.getAll();
	}

	public boolean existeCiudad(int id) {
		return dao.existeCiudad(id);
	}
		
}
