package model;

import java.sql.Date;
import java.util.Objects;

public class Cursos {

	private int idCurso;
	private String curso;
	private Date fechaInicio;
	private Date fechaFin;
	private String horaInicio;
	private String horaFin;
	
	public Cursos(int idCurso, String curso, Date fechaInicio, Date fechaFin, String horaInicio,
			String horaFin) {
		this.idCurso = idCurso;
		this.curso = curso;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(curso, fechaFin, fechaInicio, horaFin, horaInicio, idCurso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cursos other = (Cursos) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(fechaFin, other.fechaFin)
				&& Objects.equals(fechaInicio, other.fechaInicio) && Objects.equals(horaFin, other.horaFin)
				&& Objects.equals(horaInicio, other.horaInicio) && idCurso == other.idCurso;
	}
	@Override
	public String toString() {
		return "Cursos [idCurso=" + idCurso + ", curso=" + curso + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + "]";
	}
	
}
