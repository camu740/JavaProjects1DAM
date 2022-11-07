package models;

public class Animales {

	private int identificador;
	private String nombre;
	private double peso;
	
	/**
	 * constructor de la clase Animales
	 * @param nombre nombre del animal
	 * @param color color del animal
	 */
	public Animales(String nombre, double peso) {
		super();
		this.nombre = nombre;
		this.peso = peso;
	}

	//setters
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	//getters
	public double getPeso() {
		return peso;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getIdentificador() {
		return identificador;
	}

	@Override
	public String toString() {
		return "Animales [identificador=" + identificador + ", nombre=" + nombre + "]";
	}
	

	
}
