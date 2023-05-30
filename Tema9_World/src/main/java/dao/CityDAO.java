package dao;

import java.util.Set;

import model.City;

public interface CityDAO {

	Set<City> getAll();

	boolean hashCity(long codigoCiudad);

	Set<City> getCitiesByCountry(String countryName);

}
