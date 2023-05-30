package tema8.ejerciciosFicheros;

import java.util.Objects;

public class Trabajadores {

	private String nombre;
	private int peonadas;
	
	public Trabajadores(String nombre) {
		this.nombre = nombre;
		this.peonadas = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeonadas() {
		return peonadas;
	}

	public void setPeonadas() {
		peonadas++;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, peonadas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajadores other = (Trabajadores) obj;
		return Objects.equals(nombre, other.nombre) && peonadas == other.peonadas;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ". Peonadas: " + peonadas + "\n";
	}
	
	
}
