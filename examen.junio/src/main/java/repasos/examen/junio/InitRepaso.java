package repasos.examen.junio;

import utils.ConfigException;
import utils.DBConnection;

public class InitRepaso {

	public static void main(String[] args) throws ConfigException {
		
		DBConnection.getInstance().getConnection();
	}
}
