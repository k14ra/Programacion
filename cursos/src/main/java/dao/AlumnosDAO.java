package dao;

import java.sql.Date;
import java.util.ArrayList;

import model.Alumnos;

public interface AlumnosDAO {

	/**
	 * 
	 * @return complete list of all students
	 */
	public ArrayList<Alumnos> getAll();
	
	/**
	 * insert student
	 */
	public void addAlumno(int id, String nombre, String apellidos, String tlfn, Date fechaNac);
 	
}
