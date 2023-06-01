package repository;

import java.util.ArrayList;

import dao.CursosDAO;
import dao.CursosDAOMysql;
import model.Cursos;

public class CursosRepository {

	private static CursosRepository instance;
	private CursosDAO dao;
	
	public static CursosRepository getInstance() {
		if(instance == null) {
			instance = new CursosRepository();
		} return instance;
	}
	
	private CursosRepository() {
		dao = new CursosDAOMysql();
	}
	
	public ArrayList<Cursos> getAll() {
		return dao.getAll();
	}
}
