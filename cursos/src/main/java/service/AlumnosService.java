package service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;

import model.Alumnos;
import repository.AlumnosRepository;

public class AlumnosService {

	public ArrayList<Alumnos> listarAlumnos(){
		return AlumnosRepository.getInstance().getAll();
	}
	
	public void addAlumoObj(Alumnos alumno) {
		AlumnosRepository.getInstance().addAlumoObj(alumno);
	}

	public void addAlumno(int id, String nombre, String apellidos, String tlfn, Date fechaNac) {
		AlumnosRepository.getInstance().addAlumno(id, nombre, apellidos, tlfn, fechaNac);
	}
	
	public void modifyNombreAlumno(String nombreOriginal, String nombreNuevo) {
		AlumnosRepository.getInstance().modifyNombreAlumno(nombreOriginal, nombreNuevo);
	}

	public void deleteAlumno(int id) {
		AlumnosRepository.getInstance().deleteAlumno(id);
	}

	/**
	 * Vuelca todos los alumnos en un fichero .txt
	 */
	public void volcarAlumnosFichero() {
		Path ruta = Paths.get("Ficheros/Alumnos.txt");
		ArrayList<Alumnos> listaAlumnos = listarAlumnos();
		
		try(BufferedWriter bw = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8);){
			for (Alumnos alumnos : listaAlumnos) {
				bw.write(alumnos.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
