package repasos.examen.junio;

import utils.DBConnection;

public class InitRepaso {

	
	public static void main(String[] args) {
		
		DBConnection.getInstance().getConnection();
	}
}
