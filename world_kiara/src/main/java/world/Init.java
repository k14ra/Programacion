package world;

import java.util.Scanner;

import service.CityService;
import service.CountryService;
import utils.DBConnection;


public class Init {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CityService cs = new CityService();
		CountryService cos = new CountryService();
		int opc = 0;
		
		do {
			System.out.println("1 Listar ciudades");
			System.out.println("2 Listar paises");
			System.out.println("3 Existe ciudad ? por id");
			System.out.println("4 Existe pais ? por nombre");
			System.out.println("5 Salir");
			
			do {
				System.out.println("Introduce la opcion deseada: ");
				opc = sc.nextInt();
				
				switch (opc) {
				case 1:
					System.out.println(cs.listadoCiudades());
					break;
				case 2:
					System.out.println(cos.getAll());
					break;
				case 3:
					System.out.println(cs.existeCiudad(4046));
					break;
				case 4:
					System.out.println(cos.existePais("Spain"));
					break;
				case 5:
					DBConnection.getInstance().destroyConnection();
					System.out.println("Conexion cerrada con exito.");
					break;

				}
				
			}while(opc > 0 || opc < 6);
			
		} while(opc != 5);
		
		sc.close();
	}
	
	
}
