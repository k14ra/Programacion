package service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.City;
import model.Continent;
import repository.PopulationRepository;

public class PopulationService {

	public ArrayList<City> getCityPopulation(String continentName) {
		return PopulationRepository.getInstance().getCityPopulation(continentName);
	}

	public ArrayList<Continent> getContinentPopulation() {
		return PopulationRepository.getInstance().getContinentPopulation();
	}

	public ArrayList<City> writePopulationGrowth(int crecimiento, int anio){
		ArrayList<City> lista = new ArrayList<>();
		long population;
		
		switch (crecimiento) {
		case 3:
			lista = getCityPopulation("South America");
			//Esto sirve para añadir otra lista y juntarlas.
			lista.addAll(getCityPopulation("Africa"));
			for (City city : lista) {
				//necesito multiplicar por tantos años me indique el paramentro.
				for (int i = 0; i < anio; i++) {
					population = city.getCityPopulation();
					population += city.getCityPopulation() * 0.03;
					city.setCityPopulation(population);
				}
			}
			break;
		case 2:
			lista = getCityPopulation("Asia");
			for (City city : lista) {
				for (int i = 0; i < anio; i++) {
					population = city.getCityPopulation();
					population += city.getCityPopulation() * 0.02;
					city.setCityPopulation(population);
				}
			}
			break;
		case 1:
			lista = getCityPopulation("Oceania");
			lista.addAll(getCityPopulation("Antartica"));
			for (City city : lista) {
				for (int i = 0; i < anio; i++) {
					population = city.getCityPopulation();
					population += city.getCityPopulation() * 0.01;
					city.setCityPopulation(population);
				}
			}
			break;
		case -2:
			lista = getCityPopulation("Europe");
			lista.addAll(getCityPopulation("North America"));
			for (City city : lista) {
				for (int i = 0; i < anio; i++) {
					population = city.getCityPopulation();
					population -= city.getCityPopulation() * 0.02;
					city.setCityPopulation(population);
				}
			}
			break;
		}
		return lista;
	}
	
	//A este método hay que pasarle por parametro la lista de writePopulationGrowth();
	public void volcarFichero(ArrayList<City> lista) {
		Path rutaFichero = Paths.get("Ficheros/Crecimiento.txt");
		ArrayList<City> listaCiudades = lista;
		try (BufferedWriter bw = Files.newBufferedWriter(rutaFichero, StandardCharsets.UTF_8)) {
			for (City city : listaCiudades) {
				bw.write(city.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
