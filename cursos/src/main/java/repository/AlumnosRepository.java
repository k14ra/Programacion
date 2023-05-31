package repository;

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
}
