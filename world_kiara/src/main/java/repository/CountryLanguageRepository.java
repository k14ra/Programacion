package repository;

import java.util.ArrayList;

import dao.CountryLanguageDAO;
import dao.CountryLanguageDAOMysql;
import model.CountryLanguage;

public class CountryLanguageRepository {

	private CountryLanguageDAO dao;
	private static CountryLanguageRepository instance;
	
	public static synchronized CountryLanguageRepository getInstance() {
		if(instance == null) {
			instance = new CountryLanguageRepository();
		} return instance;
	}
	
	private CountryLanguageRepository() {
		dao = new CountryLanguageDAOMysql();
	}
	
	public ArrayList<CountryLanguage> getCountryLanguage() {
		return dao.getCountryLanguage();
	}

}
