package model;

import java.util.Objects;

public class Continent {

	private String name;
	private long population;
	
	public Continent(String name, long population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, population);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Continent other = (Continent) obj;
		return Objects.equals(name, other.name) && population == other.population;
	}

	@Override
	public String toString() {
		return "Pais: " + name + ", poblacion: " + population + "\n";
	}
}
