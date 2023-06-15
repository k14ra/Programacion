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
	public void addAlumoObj(Alumnos alumno);

	/**
	 * insert student
	 */
	public void addAlumno(int id, String nombre, String apellidos, String tlfn, Date fechaNac);
	
	/**
	 * Changes the name of an existing student.
	 * @param nombreOriginal original name of the student, the one we want to change
	 * @param nombreNuevo the new name to put on the student
	 */
	public void modifyNombreAlumno(String nombreOriginal, String nombreNuevo);

	/**
	 * Deletes an student using the ID
	 * @param id the id of the student you want to delete
	 */
	public void deleteAlumno(int id);
 	
}
