package world;

import java.util.Scanner;

import service.CityService;
import service.CountryLanguageService;
import service.CountryService;
import utils.DBConnection;


public class Init {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CityService cs = new CityService();
		CountryService cos = new CountryService();
		CountryLanguageService cls = new CountryLanguageService();
		int opc = 0;
		
		do {
			System.out.println("1 Listar ciudades");
			System.out.println("2 Listar paises");
			System.out.println("3 Existe ciudad ? por id");
			System.out.println("4 Existe pais ? por nombre");
			System.out.println("5 Buscar ciudad");
			System.out.println("6 Buscar pais");
			System.out.println("7 Numero de idiomas por pais");
			System.out.println("8 Salir");
			
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
					System.out.println(cs.getCity(4046));
					break;
				case 6:
					System.out.println(cos.devolverPais("United States"));
					break;
				case 7:
					System.out.println(cls.getCountryLanguage());
					break;
				case 8:
					DBConnection.getInstance().destroyConnection();
					System.out.println("Conexion cerrada con exito.");
					break;
				}
				
			}while(opc > 0 || opc < 9);
			
		} while(opc != 8);
		
		sc.close();
	}
	
	
}
