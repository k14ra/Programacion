package model;

import java.util.Objects;

public class Evaluaciones {

	private int codAlumno;
	private int codCurso;
	private int notaFinal;
	private String observaciones;
	
	public Evaluaciones(int codAlumno, int codCurso, int notaFinal, String observaciones) {
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.notaFinal = notaFinal;
		this.observaciones = observaciones;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public int getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(int notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codAlumno, codCurso, notaFinal, observaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluaciones other = (Evaluaciones) obj;
		return codAlumno == other.codAlumno && codCurso == other.codCurso && notaFinal == other.notaFinal
				&& Objects.equals(observaciones, other.observaciones);
	}

	@Override
	public String toString() {
		return "Evaluaciones [codAlumno=" + codAlumno + ", codCurso=" + codCurso + ", notaFinal=" + notaFinal
				+ ", observaciones=" + observaciones + "]";
	}
	
}
