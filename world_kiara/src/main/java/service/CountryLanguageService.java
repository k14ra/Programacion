package service;

import java.util.ArrayList;

import model.CountryLanguage;
import repository.CountryLanguageRepository;

public class CountryLanguageService {

	public ArrayList<CountryLanguage> getCountryLanguage() {
		return CountryLanguageRepository.getInstance().getCountryLanguage();
	}

	
}
