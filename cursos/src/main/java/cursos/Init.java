package cursos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import dao.AlumnosDAOMysql;
import dao.CursosDAOMysql;
import dao.GestionDAOMysql;
import model.Alumnos;
import model.Cursos;
import model.Gestion;
import service.AlumnosService;
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
				
				switch (opc) {
				case 1:
					AlumnosDAOMysql dao = new AlumnosDAOMysql();
					ArrayList<Alumnos> lista = new ArrayList<Alumnos>();
					lista = dao.getAll();
					
					for (Alumnos alumnos : lista) {
						System.out.println(alumnos);
					}
					break;
				case 2:
					CursosDAOMysql dao2 = new CursosDAOMysql();
					ArrayList<Cursos> lista2 = new ArrayList<Cursos>();
					lista2 = dao2.getAll();
					
					for (Cursos cursos : lista2) {
						System.out.println(cursos);
					}
					break;
				case 3:
					GestionDAOMysql dao3 = new GestionDAOMysql();
					ArrayList<Gestion> lista3 = new ArrayList<>();
					lista3 = dao3.getGestion();
					
					for (Gestion gestion : lista3) {
						System.out.println(gestion);
					}
					break;
				case 4:
					AlumnosService as = new AlumnosService();
					as.volcarAlumnosFichero();
					break;
				case 5:
					GestionService gs = new GestionService();
					gs.AlumnosNotasFichero();
					gs.LeerAlumnosNotas();
					break;
				case 6:
					AlumnosDAOMysql al = new AlumnosDAOMysql();
					al.addAlumno(80, "Sara", "Lopez", "677736372", null);
					break;
				case 7:
					
					break;
				case 8:
					
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
