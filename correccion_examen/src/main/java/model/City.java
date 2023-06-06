package model;

import java.util.Objects;

public class City {

	private String cityName;
	private String countryName;
	private long cityPopulation;
	
	public City(String cityName, String countryName, long cityPopulation) {
		this.cityName = cityName;
		this.countryName = countryName;
		this.cityPopulation = cityPopulation;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getCityPopulation() {
		return cityPopulation;
	}

	public void setCityPopulation(long cityPopulation) {
		this.cityPopulation = cityPopulation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityName, cityPopulation, countryName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(cityName, other.cityName) && cityPopulation == other.cityPopulation
				&& Objects.equals(countryName, other.countryName);
	}

	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", countryName=" + countryName + ", cityPopulation=" + cityPopulation
				+ "\n";
	}
	
	
}
