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
	public static final String MODIFY_STUDENT = "update alumnos set nombre = ? where nombre = ?";
	public static final String DELETE_STUDENT = "delete from alumnos where CodigoAlumno = ?";

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

	public void addAlumoObj(Alumnos alumno) {
		
		try(PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(INSERT_STUDENT);){
			stmt.setInt(1, alumno.getIdAlumno());
			stmt.setString(2, alumno.getNombre());
			stmt.setString(3, alumno.getApellidos());
			stmt.setString(4, alumno.getTlf());
			stmt.setDate(5, alumno.getFechaNac());

			stmt.executeUpdate();
			System.out.println("Alumno añadido correctamente.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			System.out.println("Alumno añadido correctamente.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modifyNombreAlumno(String nombreOriginal, String nombreNuevo) {
		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(MODIFY_STUDENT);){
			stmt.setString(1, nombreNuevo);
			stmt.setString(2, nombreOriginal);
			
			stmt.executeUpdate();
			System.out.println("Nombre del alumno modificado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAlumno(int id) {
		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(DELETE_STUDENT);){
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			System.out.println("Alumno eliminado correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
