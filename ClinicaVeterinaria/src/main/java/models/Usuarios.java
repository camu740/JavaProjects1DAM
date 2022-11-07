package models;

import java.util.ArrayList;

public class Usuarios {
	private String username;
	private String passwd;
	//Lista de animales de este doctor
	public ArrayList<Animales> Mascotas; 
	
	//Builders
	public Usuarios(String username, String passwd) {
		Mascotas = new ArrayList<Animales>();
		this.username = username;
		this.passwd = passwd;
	}
	
	//Getters and Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public ArrayList<Animales> getMascotas() {
		return Mascotas;
	}
	
	//methods
	
	/**
	 * añade una mascota a la lista de mascotas del doctor
	 * @param a mascota a añadir
	 */
	public void addMascota(Animales a) {
		Mascotas.add(a);
	}
	
	
	public void quitarMascota(int i) {
		Mascotas.remove(i);
	}	
	
}
