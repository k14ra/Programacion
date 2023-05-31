package repository;

import java.util.ArrayList;

import dao.GestionDAO;
import dao.GestionDAOMysql;
import model.Gestion;

public class GestionRepository {

	private static GestionRepository instance;
	private GestionDAO dao;
	
	public static GestionRepository getInstance() {
		if(instance == null) {
			instance = new GestionRepository();
		} return instance;
	}
	
	private GestionRepository() {
		dao = new GestionDAOMysql();
	}
	
	public ArrayList<Gestion> getGestion(){
		return dao.getGestion();
	}
}
