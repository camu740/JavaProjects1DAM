package dao;

//CTRL + SHIFT + O
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;
import models.Usuario;

public class UserDAO {
	final static String DB_URL = "jdbc:mysql://localhost/Pokedex";
	final static String USER = "Entrenador";
	final static String PASS = "ratatasalvaje69";
	

	public void consulta() {
		final String QUERY = "SELECT username, password FROM users";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				// Display values
				System.out.print("Username: " + rs.getString("username"));
				System.out.println(", Password: " + rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean login(Usuario usuario) {
		final String QUERY = "SELECT username, password FROM users "+
							"where username = '" + usuario.getUsername() + "' and "+
							"password = '" + usuario.getPasswd() + "'";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void register(Usuario usuario) {
		final String INSERT = "INSERT INTO users (username,password)"
				+ " VALUES ('"+ usuario.getUsername() + "','"+ usuario.getPasswd() +"');";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}