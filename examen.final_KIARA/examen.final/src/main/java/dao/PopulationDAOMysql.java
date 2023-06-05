package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Population;
import utils.DBConnection;

public class PopulationDAOMysql implements PopulationDAO {

	public final static String CONTINENT_POPULATION = "SELECT continent, SUM(population) from country group by continent";
	public final static String CITY_POPULATION = "SELECT name, SUM(population) from city group by name";
	public final static String CITY_POPULATION2 = "select ci.name, ci.population from city ci join country c on ci.CountryCode = c.Code where c.code = ?";
	
	@Override
	public ArrayList<Population> getContinentPopulation() {
		ArrayList<Population> listaDatos = new ArrayList<>();
		
		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(CONTINENT_POPULATION);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Population p = new Population(
							rs.getString("continent"),
							rs.getLong("SUM(population)")
						);
				listaDatos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDatos;
	}

	@Override
	public ArrayList<Population> getCityPopulation() {
		ArrayList<Population> listaDatos = new ArrayList<>();
		
		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(CITY_POPULATION);){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Population p = new Population(
							rs.getString("name"),
							rs.getLong("SUM(population)")
						);
				listaDatos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDatos;
	}

	public ArrayList<Population> getCityPopulation2(String code) {
		ArrayList<Population> listaDatos = new ArrayList<>();
		
		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(CITY_POPULATION);){
			ResultSet rs = stmt.executeQuery();
			stmt.setString(1, code);
			
			while(rs.next()) {
				Population p = new Population(
							rs.getString("ci.name"),
							rs.getLong("ci.population")
						);
				listaDatos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDatos;
	}

}
