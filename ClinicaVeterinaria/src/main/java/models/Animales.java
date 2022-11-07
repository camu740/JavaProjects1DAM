package models;

public class Animales {
	protected String nombre;
	protected int numChip;
	protected String especie;
	protected String raza;
	protected double peso;
	protected String observaciones;
	
	//Builder
	public Animales(String nombre, int numChip, String especie, String raza, double peso, String observaciones) {
		super();
		this.nombre = nombre;
		this.numChip = numChip;
		this.especie = especie;
		this.raza = raza;
		this.peso = peso;
		this.observaciones = observaciones;
	}
	
	public Animales(String nombre, int numChip, String especie, String raza, double peso) {
		super();
		this.nombre = nombre;
		this.numChip = numChip;
		this.especie = especie;
		this.raza = raza;
		this.peso = peso;
		this.observaciones = "";
	}

	//Getters and Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumChip() {
		return numChip;
	}

	public void setNumChip(int numChip) {
		this.numChip = numChip;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
