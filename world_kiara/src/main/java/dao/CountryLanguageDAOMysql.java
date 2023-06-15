package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CountryLanguage;
import utils.DBConnection;

public class CountryLanguageDAOMysql implements CountryLanguageDAO{

	private final static String COUNTRY_LANGUAGE = "SELECT co.name, COUNT(cl.language) FROM country co JOIN countrylanguage cl ON cl.countrycode = co.code GROUP BY co.name";
	
	@Override
	public ArrayList<CountryLanguage> getCountryLanguage() {
		ArrayList<CountryLanguage> lista = new ArrayList<>();
		
		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(COUNTRY_LANGUAGE);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CountryLanguage cl = new CountryLanguage(
						rs.getString("co.name"),
						rs.getString("COUNT(cl.language)")
						);
				lista.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
