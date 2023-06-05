package world;

import java.util.Scanner;

//import dao.CityDAOMysql;
//import dao.CountryDAOMysql;
import service.PopulationService;
import utils.DBConnection;

public class Examen89_Init {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PopulationService ps = new PopulationService();
		int opc = 0;
		
		/* esto no lo pedias...
		CountryDAOMysql cd = new CountryDAOMysql();
		System.out.println(cd.getAll());
		
		CityDAOMysql cdm = new CityDAOMysql();
		System.out.println(cdm.getAll());
		*/

		
		do {
			System.out.println("1 - GetContinentPopulation:");
			System.out.println("2 - GetCityPopulation");
			System.out.println("3 - WritePopulationGrowth");
			System.out.println("4 - Salir");
			do {
				System.out.println("Introduce opcion deseada: ");
				opc = sc.nextInt();
				
				switch (opc) {
				case 1:
					System.out.println(ps.getContinentPopulation());
					break;
				/*case 2:
					System.out.println(ps.getCityPopulation());
					break;*/
				case 2:
					System.out.println(ps.getCityPopulation2("USA"));
					break;
				case 3:
					ps.writePopulationGrowth(2);
					break;
				case 4:
					DBConnection.getInstance().destroyConnection();
					break;
				}
			} while (opc > 0 && opc < 5);
		} while (opc != 4);
		
		sc.close();

	}

	
}
