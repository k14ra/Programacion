package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.City;
import utils.DBConnection;

public class CityDAOMysql implements CityDAO{

	private final String SELECT_CITIES = "SELECT id, name, countrycode, district, population FROM CITY";
	private final String INFO_CITY = "SELECT id, name, countrycode, district, population FROM CITY WHERE id = ?";
	
	@Override
	public ArrayList<City> getAll() {
		ArrayList<City> listaCiudades = new ArrayList<>();
		
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
				listaCiudades.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCiudades;
	}

	@Override
	public boolean existeCiudad(int id) {
		ArrayList<City> listaCiudades = new ArrayList<>();
		listaCiudades = getAll();
		
		for (City city : listaCiudades) {
			if(city.getId() == id) {
				//System.out.println("Ciudad encontrada." + city.getName());
				return true;
			}
		}
		return false;
	}

	//devuelve un objeto de tipo City con información de la ciudad con código codigoCiudad.
	@Override
	public City getCity(int codigoCiudad) {
		City c = null;
		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(INFO_CITY);){
			stmt.setInt(1, codigoCiudad);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				if (rs.getInt("id") == codigoCiudad) {
					c = new City(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("countrycode"),
							rs.getString("district"),
							rs.getInt("population")
						);
					return c;
				} else {
					System.out.println("Ciudad no encontrada.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

}
