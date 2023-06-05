package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.City;
import utils.DBConnection;


public class CityDAOMysql implements CityDAO{

	private final String SELECT_CITIES = "SELECT id, name, countrycode, district, population FROM city";

	@Override
	public ArrayList<City> getAll() {
		ArrayList<City> lista = new ArrayList<>();
		
		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(SELECT_CITIES);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				City c = new City(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("countrycode"),
							rs.getString("district"),
							rs.getInt("population")
						);
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
