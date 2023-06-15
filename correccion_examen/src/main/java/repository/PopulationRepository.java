package repository;

import java.util.ArrayList;

import dao.PopulationDAO;
import dao.PopulationDAOMysql;
import model.City;
import model.Continent;

public class PopulationRepository {

	private PopulationDAO dao;
	private static PopulationRepository instance;

	public static synchronized PopulationRepository getInstance() {
		if (instance == null) {
			instance = new PopulationRepository();
		}
		return instance;
	}

	private PopulationRepository() {
		dao = new PopulationDAOMysql();
	}
	
	public ArrayList<City> getCityPopulation(String continentName) {
		return dao.getCityPopulation(continentName);
	}
	
	public ArrayList<Continent> getContinentPopulation() {
		return dao.getContinentPopulation();
	}


}
