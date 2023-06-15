package dao;

import java.util.ArrayList;

import model.City;
import model.Continent;

public interface PopulationDAO {

	public ArrayList<City> getCityPopulation(String continentName);
	
	public ArrayList<Continent> getContinentPopulation();
	
}
