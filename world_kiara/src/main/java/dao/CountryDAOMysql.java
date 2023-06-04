package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Country;
import utils.DBConnection;

public class CountryDAOMysql implements CountryDAO{

	private final String SELECT_COUNTRIES = "SELECT code, name, continent, region, population FROM COUNTRY";
	private final String SELECT_COUNTRY = "SELECT code, name, continent, region, population FROM COUNTRY WHERE code = ?";

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

	@Override
	public Country encontrarPais(String codigoPais) {
		Country c = null;
		
		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(SELECT_COUNTRY);){
			stmt.setString(1, codigoPais);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("code") == codigoPais) {
					c = new Country(
							rs.getString("code"),
							rs.getString("name"),
							rs.getString("continent"),
							rs.getString("region"),
							rs.getInt("population")
						);
					return c;
				}else {
					System.out.println("Pais no encontrado.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}

