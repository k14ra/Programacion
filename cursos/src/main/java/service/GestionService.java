package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.Gestion;
import repository.GestionRepository;

public class GestionService {
	
	/*Guardar los alumnos en un fichero, y guardar sus notas en el fichero para sumarlas despues*/
	public ArrayList<Gestion> AlumnosNotas(){
		return GestionRepository.getInstance().getGestion();
	}
	
	/*metodo para guardar la informacion anterior en un fichero*/
	public void AlumnosNotasFichero() {
		Path ruta = Paths.get("Ficheros/AlumnosNotasFichero.txt");
		ArrayList<Gestion> listado = AlumnosNotas();
		
		try (BufferedWriter bw = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8);){
			for (Gestion gestion : listado) {
				bw.write(gestion.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*metodo para leer el fichero anterior*/
	public void LeerAlumnosNotas() {
		Path ruta = Paths.get("Ficheros/AlumnosNotasFichero.txt");
		String lineaTexto = null;
		int suma = 0;

		try (BufferedReader br = Files.newBufferedReader(ruta, StandardCharsets.UTF_8);){
			
			while((lineaTexto = br.readLine()) != null) {
				String[] filtro = lineaTexto.split("[,=]");
				suma += Integer.parseInt(filtro[7]);
			} System.out.println("Suma: " + suma);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
