package repository;

import java.sql.Date;
import java.util.ArrayList;

import dao.AlumnosDAO;
import dao.AlumnosDAOMysql;
import model.Alumnos;

public class AlumnosRepository {

	private AlumnosDAO dao;
	private static AlumnosRepository instance;
	
	public static synchronized AlumnosRepository getInstance() {
		if(instance == null) {
			instance = new AlumnosRepository();
		}
		return instance;
	}
	
	private AlumnosRepository() {
		dao = new AlumnosDAOMysql();
	}
	
	public ArrayList<Alumnos> getAll(){
		return dao.getAll();
	}
	
	public void addAlumno(int id, String nombre, String apellidos, String tlfn, Date fechaNac) {
		dao.addAlumno(id, nombre, apellidos, tlfn, fechaNac);
	}
	
	public void modifyNombreAlumno(String nombreOriginal, String nombreNuevo) {
		dao.modifyNombreAlumno(nombreOriginal, nombreNuevo);
	}
	
	public void deleteAlumno(int id) {
		dao.deleteAlumno(id);
	}

}
