package tema8.ejerciciosFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LectorTrabajadores {
	// Lo primero es añadir los .txt en la carpeta ficheros, el de trabajadores y
	// peonadas

	/*
	 * Debemos realizar un programa que genere el archivo “totalPeonadas.txt” que
	 * contenga la siguiente información: Juan:2 Pedro:4 Daniel:2 Carlos:3 Luis:2
	 */

	public static void main(String[] args) {

		trabajadoresPeonadas();
	}

	// Necesitamos una funcion que cree la lista de trabajadores.
	public static ArrayList<Trabajadores> crearListaTrabajadores() {

		// Lo primero es acceder al fichero, asi que necesitamos la ruta
		Path rutaTrabajadores = Paths.get("Ficheros/Trabajadores.txt");

		// Necesitamos guardar la informacion (en este caso los trabajadores) en un
		// ArrayList.
		// para crear una lista de trabajadores necesito crear los trabajadores y
		// meterlos en la lista
		ArrayList<Trabajadores> listaTrabajadores = new ArrayList<Trabajadores>();

		try (BufferedReader br = Files.newBufferedReader(rutaTrabajadores, StandardCharsets.UTF_8)) {

			// Variable que vamos a usar para guardar linea a linea el contenido del
			// fichero:
			String lineaTexto = null;

			while ((lineaTexto = br.readLine()) != null) {
				// Trabajadores trab = new Trabajadores(lineaTexto);
				listaTrabajadores.add(new Trabajadores(lineaTexto));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaTrabajadores;
	}

	// Necesito leer el fichero de las peonadas, y si el nombre de un trabajador
	// coincide con algun
	// trabajador de fichero de peonadas, tengo que sumar 1 a las peonadas de ese
	// trabajador.

	public static ArrayList<Trabajadores> leerPeonadas() {
		Path rutaPeonadas = Paths.get("Ficheros/Peonadas.txt");
		ArrayList<Trabajadores> listaPeonadas = new ArrayList<Trabajadores>();

		try (BufferedReader br = Files.newBufferedReader(rutaPeonadas, StandardCharsets.UTF_8)) {

			listaPeonadas = crearListaTrabajadores();
			String lineaTexto = null;

			while ((lineaTexto = br.readLine()) != null) {
				System.out.println(lineaTexto);

				String[] filtro = lineaTexto.split("[:,]");
				for (int i = 0; i < filtro.length; i++) {
					for (Trabajadores lista : listaPeonadas) {
						if (lista.getNombre().equals(filtro[i])) {
							lista.setPeonadas();
						}
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPeonadas;
	}

	// Ahora, necesito otro metodo para volcar la lista nueva en un fichero...
	public static void trabajadoresPeonadas() {
		ArrayList<Trabajadores> lista = new ArrayList<>();
		Path nuevoFichero = Paths.get("Ficheros/TrabajadoresPeonadas.txt");

		try (BufferedWriter bw = Files.newBufferedWriter(nuevoFichero, StandardCharsets.UTF_8)) {
			lista = leerPeonadas();
			for (Trabajadores listaCompleta : lista) {
				bw.write(listaCompleta.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
