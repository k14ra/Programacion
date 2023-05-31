package model;

import java.sql.Date;
import java.util.Objects;

public class Alumnos {

	private int idAlumno;
	private String nombre;
	private String Apellidos;
	private String tlf;
	private Date fechaNac;
	
	public Alumnos(int idAlumno, String nombre, String apellidos, String tlf, Date fechaNac) {
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		Apellidos = apellidos;
		this.tlf = tlf;
		this.fechaNac = fechaNac;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Apellidos, fechaNac, idAlumno, nombre, tlf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumnos other = (Alumnos) obj;
		return Objects.equals(Apellidos, other.Apellidos) && Objects.equals(fechaNac, other.fechaNac)
				&& idAlumno == other.idAlumno && Objects.equals(nombre, other.nombre) && Objects.equals(tlf, other.tlf);
	}

	@Override
	public String toString() {
		return "Alumnos [idAlumno=" + idAlumno + ", nombre=" + nombre + ", Apellidos=" + Apellidos + ", tlf=" + tlf
				+ ", fechaNac=" + fechaNac + "\n";
	}

}
