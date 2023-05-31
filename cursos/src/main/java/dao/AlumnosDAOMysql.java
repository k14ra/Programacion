package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Alumnos;
import utils.DBConnection;

public class AlumnosDAOMysql implements AlumnosDAO {

	private final static String GET_STUDENTS = "SELECT codigoalumno, nombre, apellidos, telefono, fechanacimiento FROM alumnos";
	private final static String INSERT_STUDENT = "INSERT INTO alumnos VALUES(?,?,?,?,?)";
	
	@Override
	public ArrayList<Alumnos> getAll() {
		ArrayList<Alumnos> listaAlumnos = new ArrayList<>();
		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(GET_STUDENTS);) {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Alumnos al = new Alumnos(
											rs.getInt("codigoalumno"),
											rs.getString("nombre"),
											rs.getString("apellidos"),
											rs.getString("telefono"),
											rs.getDate("fechanacimiento")
										);
				listaAlumnos.add(al);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAlumnos;
	}

	@Override
	public void addAlumno(int id, String nombre, String apellidos, String tlfn, Date fechaNac) {
		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(INSERT_STUDENT);){
			stmt.setInt(1, id);
			stmt.setString(2, nombre);
			stmt.setString(3, apellidos);
			stmt.setString(4, tlfn);
			stmt.setDate(5, fechaNac);
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
