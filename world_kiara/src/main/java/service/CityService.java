package service;

import java.util.ArrayList;

import model.City;
import repository.CityRepository;

public class CityService {

	public ArrayList<City> listadoCiudades() {
		return CityRepository.getInstance().getAll();
	}
	
	public boolean existeCiudad(int id) {
		return CityRepository.getInstance().existeCiudad(id);
	}

}
