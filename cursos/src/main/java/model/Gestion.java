package model;

import java.util.Objects;

public class Gestion {

	private String nombre;
	private String apellidos;
	private String curso;
	private int nota;
	private String observaciones;
	
	public Gestion(String nombre, String apellidos, String curso, int nota, String observaciones) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
		this.nota = nota;
		this.observaciones = observaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, curso, nombre, nota, observaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gestion other = (Gestion) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(curso, other.curso)
				&& Objects.equals(nombre, other.nombre) && nota == other.nota
				&& Objects.equals(observaciones, other.observaciones);
	}

	@Override
	public String toString() {
		return "Gestion [nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso + ", nota=" + nota
				+ ", observaciones=" + observaciones + "\n";
	}
	
	
	
}
