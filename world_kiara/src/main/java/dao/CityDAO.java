package dao;

import java.util.ArrayList;

import model.City;

public interface CityDAO {

	/**
	 * Listado completo de las ciudades
	 * @return arraylist de ciudades
	 */
	public ArrayList<City> getAll();

	/**
	 * Devuelve verdadero en caso de que la ciudad esté registrada y falso en caso contrario. 
	 * @param id
	 * @return V si la ciudad esta registrada, F si no lo esta
	 */
	public boolean existeCiudad(int id);
	
	
	
}
