package repository;

import java.util.ArrayList;

import dao.PopulationDAO;
import dao.PopulationDAOMysql;
import model.Population;

public class PopulationRepository {

	private PopulationDAO dao;
	private static PopulationRepository instance;
	
	public static synchronized PopulationRepository getInstance() {
		if(instance == null) {
			instance = new PopulationRepository();
		}
		return instance;
	}
	
	private PopulationRepository() {
		dao = new PopulationDAOMysql();
	}
	
	public ArrayList<Population> getContinentPopulation() {
		return dao.getContinentPopulation();
	}
	
	public ArrayList<Population> getCityPopulation() {
		return dao.getCityPopulation();
	}

	public ArrayList<Population> getCityPopulation2(String code) {
		return dao.getCityPopulation();
	}
}
