package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Gestion;
import utils.DBConnection;

public class GestionDAOMysql implements GestionDAO{

	private final static String GET_STUDENT_RESULTS = "select a.nombre, a.apellidos, c.curso, e.notafinal, e.observaciones "
			+ "from alumnos a "
			+ "join evaluaciones e on e.codigoalumno = a.codigoalumno "
			+ "join cursos c on e.codigocurso = c.codigocurso;";
	

	@Override
	public ArrayList<Gestion> getGestion() {
		ArrayList<Gestion> listado = new ArrayList<>();
		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(GET_STUDENT_RESULTS);){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Gestion g = new Gestion(
											rs.getString("nombre"),
											rs.getString("apellidos"),
											rs.getString("curso"),
											rs.getInt("notafinal"),
											rs.getString("observaciones")
						);
				listado.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listado;
	}
}
