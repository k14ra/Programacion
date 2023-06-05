package dao;

import java.util.ArrayList;

import model.Population;

public interface PopulationDAO {

	public ArrayList<Population> getContinentPopulation();
	
	public ArrayList<Population> getCityPopulation();

	public ArrayList<Population> getCityPopulation2(String code);
}
