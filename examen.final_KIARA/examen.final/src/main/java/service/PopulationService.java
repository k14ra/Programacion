package service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.Population;
import repository.PopulationRepository;

public class PopulationService {

	public ArrayList<Population> getContinentPopulation() {
		return PopulationRepository.getInstance().getContinentPopulation();
	}

	public ArrayList<Population> getCityPopulation() {
		return PopulationRepository.getInstance().getCityPopulation();
	}
	
	public ArrayList<Population> getCityPopulation2(String code) {
		return PopulationRepository.getInstance().getCityPopulation2(code);
	}

	
	//no me sale fran no soy capaz
	public void writePopulationGrowth(int anios) {
		Path ruta = Paths.get("Ficheros/WritePopulationGrowth.txt");
		ArrayList<Population> lista = getContinentPopulation();
		
		try(BufferedWriter bw = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8);){
			for (Population item : lista) {
				if(item.getNameCountry().equals("North America") || item.getNameCountry().equals("Africa")) {
					item.setPopulationCountry(item.getPopulationCountry() * (anios * 3));
				} else if (item.getNameCountry().equals("Europe") || item.getNameCountry().equals("North America")){
					item.setPopulationCountry(item.getPopulationCountry() * (anios * -3));
				} else if (item.getNameCountry().equals("Asia")) {
					item.setPopulationCountry(item.getPopulationCountry() * (anios * 2));
				} else if (item.getNameCountry().equals("Oceania") || item.getNameCountry().equals("Antartida")){
					item.setPopulationCountry(item.getPopulationCountry() * (anios * 1));
				}
				bw.write(item.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
