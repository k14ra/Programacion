package cursos;

import java.util.ArrayList;
import java.util.Scanner;

import model.Alumnos;
import model.Cursos;
import model.Gestion;
import service.AlumnosService;
import service.CursosService;
import service.GestionService;
import utils.DBConnection;

public class Init {

	public static void main(String[] args) {
		int opc = 0;
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.println("1.- Mostrar alumnos");
			System.out.println("2.- Mostrar cursos");
			System.out.println("3.- Mostrar Alumnos y su nota final");
			System.out.println("4.- Volcar alumnos en fichero");
			System.out.println("5.- Sumar notas alumnos");
			System.out.println("6.- Aniadir alumnos");
			System.out.println("7.- Modificar alumnos");
			System.out.println("8.- Borrar alumnos");
			System.out.println("9.- Salir");

			do {
				System.out.println("Introduzca la opcion deseada: ");
				opc = sc.nextInt();
				AlumnosService as = new AlumnosService();
				GestionService gs = new GestionService();

				switch (opc) {
				case 1:
					ArrayList<Alumnos> listado = new ArrayList<>();
					listado = as.listarAlumnos();
					for (Alumnos lisst : listado) {
						System.out.println(lisst);
					}
					break;
				case 2:
					CursosService cs = new CursosService();
					ArrayList<Cursos> lista2 = new ArrayList<Cursos>();
					lista2 = cs.getAll();
					for (Cursos cursos : lista2) {
						System.out.println(cursos);
					}
					break;
				case 3:
					ArrayList<Gestion> lista3 = new ArrayList<>();
					lista3 = gs.AlumnosNotas();
					for (Gestion gestion : lista3) {
						System.out.println(gestion);
					}
					break;
				case 4:
					as.volcarAlumnosFichero();
					break;
				case 5:
					gs.AlumnosNotasFichero();
					gs.LeerAlumnosNotas();
					break;
				case 6:
					//as2.addAlumno(81, "Lara", "Lopez", "677736372",  LocalDate.of(2016, 8, 19));
					//as.addAlumno(82, "Alonso", "Lopez", "677736372",  null);
					Alumnos al = new Alumnos(345, "Prueba", "prueba", "768857564", null);
					as.addAlumoObj(al);
					break;
				case 7:
					as.modifyNombreAlumno("Laia", "Armando");
					break;
				case 8:
					as.deleteAlumno(82);
					break;
				case 9:
					DBConnection.getInstance().destroyConnection();
					System.out.println("Conexion cerrada y programa finalizado.");
					break;
				}
				
			} while (opc < 1 || opc > 9);
			
		} while (opc != 9);
		
		sc.close();
	}
}
