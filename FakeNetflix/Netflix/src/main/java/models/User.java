package models;

/**
 * Clase Usuarios
 * 
 * @author Adri�n C�mara Mu�oz
 *
 */
public class User {
	// Propiedades
	protected String correo;
	protected String passwd;

	// Builders

	/**
	 * Constructor del usuario
	 * 
	 * @param username Nombre del usuario
	 * @param passwd   Contrase�a del usuario
	 */
	public User(String username, String passwd) {
		super();
		this.correo = username;
		this.passwd = passwd;
	}

	// Getters and Setters
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}