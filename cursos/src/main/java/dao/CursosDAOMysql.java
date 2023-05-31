package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cursos;
import utils.DBConnection;

public class CursosDAOMysql implements CursosDAO{

	private final static String GET_COURSES = "SELECT codigocurso, curso, fechainicio, fechafin, horainicio, horafin FROM cursos";

	@Override
	public ArrayList<Cursos> getAll() {
		ArrayList<Cursos> listaCursos = new ArrayList<>();
		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(GET_COURSES);) {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cursos c = new Cursos(
										rs.getInt("codigocurso"),
										rs.getString("curso"),
										rs.getDate("fechainicio"),
										rs.getDate("fechafin"),
										rs.getString("horainicio"),
										rs.getString("horafin")
						);
				listaCursos.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCursos;
	}
}
