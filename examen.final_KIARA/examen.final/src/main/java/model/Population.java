package model;

import java.util.Objects;

public class Population {

	//attributes of city
	private String nameCity;
	private long populationCity;
	
	//attributes of Country
	private String nameCountry;
	private long populationCountry;
	
	public Population(long populationCity, String nameCity) {
		this.nameCity = nameCity;
		this.populationCity = populationCity;
	}

	public Population(String nameCity, String nameCountry, long populationCity) {
		this.nameCity = nameCity;
		this.nameCountry = nameCountry;
		this.populationCity = populationCity;
	}

	public Population(String nameCountry, long populationCountry) {
		this.nameCountry = nameCountry;
		this.populationCountry = populationCountry;
	}

	public Population(String nameCity, long populationCity, String nameCountry, long populationCountry) {
		this.nameCity = nameCity;
		this.populationCity = populationCity;
		this.nameCountry = nameCountry;
		this.populationCountry = populationCountry;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public long getPopulationCity() {
		return populationCity;
	}

	public void setPopulationCity(long populationCity) {
		this.populationCity = populationCity;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}

	public long getPopulationCountry() {
		return populationCountry;
	}

	public void setPopulationCountry(long populationCountry) {
		this.populationCountry = populationCountry;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(nameCity, nameCountry, populationCity, populationCountry);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Population other = (Population) obj;
		return Objects.equals(nameCity, other.nameCity) && Objects.equals(nameCountry, other.nameCountry)
				&& populationCity == other.populationCity && populationCountry == other.populationCountry;
	}

	@Override
	public String toString() {
		return "Nombre del continente: " + nameCountry + " - Poblacion: " + populationCountry + " Nombre de la ciudad: " + nameCity + "\n";
	}

}
