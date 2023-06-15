package model;

import java.util.Objects;

public class CountryLanguage {

	private String countryName;
	private String language;
	
	public CountryLanguage(String countryName, String language) {
		this.countryName = countryName;
		this.language = language;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryName, language);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryLanguage other = (CountryLanguage) obj;
		return Objects.equals(countryName, other.countryName) && Objects.equals(language, other.language);
	}

	@Override
	public String toString() {
		return "\nPAIS --> " + countryName + ", IDIOMA --> " + language;
	}
}
