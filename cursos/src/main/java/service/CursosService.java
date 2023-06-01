package service;

import java.util.ArrayList;

import model.Cursos;
import repository.CursosRepository;

public class CursosService {

	public ArrayList<Cursos> getAll() {
		return CursosRepository.getInstance().getAll();
	}

}
