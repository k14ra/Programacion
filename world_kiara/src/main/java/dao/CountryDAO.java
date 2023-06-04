package dao;

import java.util.ArrayList;

import model.Country;


public interface CountryDAO {

	/**
	 * Listado completo de paises
	 * @return arraylist de paises
	 */
	public ArrayList<Country> getAll();
	
	/**
	 * Comprueba si ese pais esta registrado o no.
	 * @param name
	 * @return T si el pais esta registrado, F si no lo esta
	 */
	public boolean existePais(String name);	
}
