package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Country;
import utils.DBConnection;

public class CountryDAOMysql implements CountryDAO{

	private final String SELECT_COUNTRIES = "SELECT code, name, continent, region, population FROM COUNTRY";

	@Override
	public ArrayList<Country> getAll() {
		ArrayList<Country> listaPaises = new ArrayList<>();
		
		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(SELECT_COUNTRIES);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Country c = new Country(
							rs.getString("code"),
							rs.getString("name"),
							rs.getString("continent"),
							rs.getString("region"),
							rs.getInt("population")
						);
				listaPaises.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPaises;
	}

	@Override
	public boolean existePais(String name) {
		ArrayList<Country> listaPaises = new ArrayList<>();
		listaPaises = getAll();
		
		for (Country country : listaPaises) {
			if(country.getName() == name) {
				return true;
			}
		}
		return false;
	}
	
}
