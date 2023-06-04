package service;

import java.util.ArrayList;

import model.Country;
import repository.CountryRepository;
import utils.DBConnection;

public class CountryService {

	public ArrayList<Country> getAll() {
		return CountryRepository.getInstance().getAll();
	}

	public boolean existePais(String name) {
		return CountryRepository.getInstance().existePais(name);
	}

	public Country devolverPais(String codigoPais) {
		return CountryRepository.getInstance().encontrarPais(codigoPais);
	}

}
