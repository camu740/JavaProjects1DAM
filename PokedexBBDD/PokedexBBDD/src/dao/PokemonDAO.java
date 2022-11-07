package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;

public class PokemonDAO {

	final static String DB_URL = "jdbc:mysql://localhost/Pokedex";
	final static String USER = "Entrenador";
	final static String PASS = "ratatasalvaje69";
	
	public PokemonDAO() {
	}

	public Pokemon first() {
		final String QUERY = "SELECT numPokedex, Tipo, name, sexo, altura, peso, categoria, habilidad, url"
				+ "FROM Pokemon limit 1";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var numPokedex = rs.getInt("numPokedex");
				String tipo = rs.getString("Tipo");
				String name = rs.getString("name");
				String sexo = rs.getString("Sexo");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String categoria = rs.getString("categoria");
				String habilidad = rs.getString("habilidad");
				String url = rs.getString("url");
				String tipo2 = rs.getString("Tipo2");
				
				Pokemon p = new Pokemon(numPokedex, tipo, name, sexo, altura, peso, categoria, habilidad, url, tipo2);
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Pokemon> getAll() {
		final String QUERY = "SELECT numPokedex, Tipo, Tipo2, name, sexo, altura, peso, categoria, habilidad, url "
				+ "FROM Pokemon";
		ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				int numPokedex = rs.getInt("numPokedex");
				String tipo = rs.getString("Tipo");
				String name = rs.getString("name");
				String sexo = rs.getString("Sexo");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String categoria = rs.getString("categoria");
				String habilidad = rs.getString("habilidad");
				String url = rs.getString("url");
				String tipo2 = rs.getString("Tipo2");
				
				Pokemon p = new Pokemon(numPokedex, tipo, name, sexo, altura, peso, categoria, habilidad, url, tipo2);	
				pokemones.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemones;
	}
	
	public static void insert(Pokemon p) {
		final String INSERT = "INSERT INTO Pokemon(numPokedex, Tipo, name, sexo, altura, peso, categoria, habilidad, url, Tipo2) "
				+ "VALUES("+p.getNumeroPokedex()+",'"+p.getTipo()+"','"+p.getName()+"','"+p.getSexo()
				+ "',"+p.getAltura()+","+p.getPeso()+",'"+p.getCategoría()+"','"+p.getHabilidad()+"','"+p.getURL()+"',"
				+ (p.getTipo2() != null 
						? "'" + String.valueOf(p.getTipo2()) + "'" 
						: "NULL") 
						+");";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public static void delete(Pokemon p) {
		final String DELETE = "delete from Pokemon where numPokedex = " + p.getNumeroPokedex();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(DELETE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Pokemon p) {
		final String UPDATE = "UPDATE Pokemon"
				+ " SET"
				+ " numPokedex = " + p.getNumeroPokedex() + ","
				+ " Tipo = '" + p.getTipo() + "',"
				+ " name = '" + p.getName() + "',"
				+ " sexo = '" + p.getSexo() + "',"
				+ " altura = " + p.getAltura() + ","
				+ " peso = " + p.getPeso() + ","
				+ " categoria = '" + p.getCategoría() + "',"
				+ " habilidad = '" + p.getHabilidad() + "',"
				+ " url = '" + p.getURL() + "',"
				
				+ "Tipo2 = " + (p.getTipo2() != "NULL" 
				? "'" + String.valueOf(p.getTipo2()) + "'" 
				: "null") 				
				+ " WHERE numPokedex = " + p.getNumeroPokedex() + ";";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}