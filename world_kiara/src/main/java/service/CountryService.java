package service;

import java.util.ArrayList;

import model.Country;
import repository.CountryRespository;

public class CountryService {

	public ArrayList<Country> getAll() {
		return CountryRespository.getInstance().getAll();
	}

	public boolean existePais(String name) {
		return CountryRespository.getInstance().existePais(name);
	}

}
