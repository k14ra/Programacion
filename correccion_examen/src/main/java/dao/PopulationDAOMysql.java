package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.City;
import model.Continent;
import utils.ConfigException;
import utils.DBConnection;

public class PopulationDAOMysql implements PopulationDAO{

	private final String SELECT_CONTINENT_POPULATION = "SELECT CONTINENT, SUM(POPULATION) POPULATION "
			+ "FROM COUNTRY GROUP BY CONTINENT";
	
	private final String SELECT_BY_REGION = "select ci.name, co.name, ci.population from city ci join country co on ci.CountryCode=co.Code where co.continent=?;";
	
	@Override
	public ArrayList<City> getCityPopulation(String continentName) {
		ArrayList<City> lista = new ArrayList<>();

		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(SELECT_BY_REGION);){
			stmt.setString(1, continentName);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				City c = new City(rs.getString("ci.name"), rs.getString("co.name"), rs.getLong("ci.population"));
				lista.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ConfigException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public ArrayList<Continent> getContinentPopulation() {
		ArrayList<Continent> lista = new ArrayList<>();
		
		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(SELECT_CONTINENT_POPULATION);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Continent c = new Continent(rs.getString("continent"), rs.getLong("population"));
				lista.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ConfigException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	
}
