package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Sentencias SQL relacionadas con la tabla Usuarios de la Base de Datos
 * 
 * @author Adrián Cámara Muñoz
 *
 */
public class UserDAO extends AbstractDAO {

	/**
	 * Constructor de la BD que hereda de la clase Abstracta
	 */
	public UserDAO() {
		super();
	}

	/**
	 * comprobar si un correo se encuentra registrado en la BD
	 * 
	 * @param correo correo a comprobar
	 * @return true si existe, false si no.
	 */
	public boolean correoEncontrado(String correo) {
		final String QUERY = "SELECT correo FROM usuarios where correo = '" + correo + "';";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * comprobar que un usuario puede logearse en la aplicacion
	 * 
	 * @param correo correod el usuario
	 * @param passwd contraseña hash del usuario
	 * @return true si coincide con la BD y está activado, false si no.
	 */
	public boolean login(String correo, String passwd) {
		final String QUERY = "SELECT correo, password, activado FROM usuarios " + "where correo = '" + correo + "' and "
				+ "password = '" + passwd + "' and " + "activado = true ";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * registrar un nuevo usuario en nuestra base de datos
	 * 
	 * @param correo correo del usuario
	 * @param passwd contraseña hash del usuario
	 * @param codigo codigo de validacion de la cuenta (-1 si no se ha generado
	 *               codigo)
	 */
	public void register(String correo, String passwd, int codigo) {
		final String INSERT = "INSERT INTO usuarios (correo,password,codigo)" + " VALUES ('" + correo + "','" + passwd
				+ "', " + codigo + ");";
		try {
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * obtener codigo de validacion de un usuario
	 * 
	 * @param correo correo del que queremos obtener el codigo de validacion
	 * @return codigo de validacion si existe, -1 si no existe
	 */
	public int codigoValidacion(String correo) {
		final String QUERY = "SELECT codigo FROM usuarios WHERE correo = '" + correo + "';";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * obtener id de un usuario
	 * 
	 * @param correo correo del usuario del que queremos obtenber la id
	 * @return id del usuario encontrado / -1 si no encuentra al usuario
	 */
	public int idUser(String correo) {
		final String QUERY = "SELECT id FROM usuarios WHERE correo = '" + correo + "';";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * cambiar codigo de validacion de un usuario
	 * 
	 * @param correo     correo del usuario al que queremos cambiar el codigo de
	 *                   validacion
	 * @param validation nuevo codigo de validacion
	 */
	public void setCode(String correo, int validation) {
		final String UPDATE = "UPDATE usuarios SET codigo = " + validation + " WHERE correo = '" + correo + "';";

		try {
			stmt.executeUpdate(UPDATE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * validar o invalidar cuenta
	 * 
	 * @param correo correo al que se va a validar o invalidar
	 * @param opcion true si queremos validar o false si queremos invalidar
	 */
	public void validado(String correo, boolean opcion) {
		final String UPDATE = "UPDATE usuarios SET activado = " + opcion + " WHERE correo = '" + correo + "';";

		try {
			stmt.executeUpdate(UPDATE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * cambiar contraseña a un usuario
	 * 
	 * @param correo correo del usuario al que cambiar la contraseña
	 * @param passwd nueva contraseña hash del usuario
	 */
	public void setPasswd(String correo, String passwd) {
		final String UPDATE = "UPDATE usuarios SET password = '" + passwd + "' WHERE correo = '" + correo + "';";

		try {
			stmt.executeUpdate(UPDATE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}