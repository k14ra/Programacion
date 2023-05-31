package dao;

import java.util.ArrayList;

import model.Cursos;


public interface CursosDAO {
	/**
	 * 
	 * @return complete list of all courses
	 */
	public ArrayList<Cursos> getAll();
}
