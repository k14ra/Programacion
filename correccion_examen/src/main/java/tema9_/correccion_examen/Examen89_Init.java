package tema9_.correccion_examen;

import service.PopulationService;
import utils.ConfigException;
import utils.DBConnection;

public class Examen89_Init {

	public static void main(String[] args) throws ConfigException {
		
		PopulationService ps = new PopulationService();
		
		//ejercicio 2
		System.out.println(ps.getContinentPopulation());
		
		//ejercicio 3
		System.out.println(ps.getCityPopulation("Asia"));
		
		//ejercicio 4
		ps.volcarFichero(ps.writePopulationGrowth(2, 2));
		
		//cerrar la conexion con la BBDD.
		DBConnection.getInstance().destroyConnection();

	}
}
