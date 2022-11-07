package models;

import ui.PokedexView;

public class Pokemon {
	//Propiedades
	private int numeroPokedex;
	private String tipo;
	private String tipo2;
	private String name;
	private String sexo;
	private double altura; 
	private double peso;
	private String categoría;
	private String habilidad;
	private String URL;
	
	//Builder
	
	/**
	 * constructor de cada Pokemon
	 * @param numeroPokedex Numero de la Pokedex del pokemon
	 * @param tipo Tipo del pokemon
	 * @param name Nombre del pokemon
	 * @param sexo Sexo del pokemon
	 * @param altura Altura del pokemon
	 * @param peso Peso del pokemon
	 * @param categoría Categoría del pokemon
	 * @param habilidad Habilidad principal del pokemon
	 * @param URL Url de la imagen del pokemon
	 */
	public Pokemon(int numeroPokedex, String tipo, String name, String sexo, double altura, double peso, String categoría,
			String habilidad, String URL, String tipo2) {
		this.numeroPokedex = numeroPokedex;
		this.tipo = tipo;
		this.name = name;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
		this.categoría = categoría;
		this.habilidad = habilidad;
		this.URL = URL;
		this.tipo2 = tipo2;
	}
	
	public Pokemon(int numeroPokedex, String tipo, String name, String sexo, double altura, double peso, String categoría,
			String habilidad, String URL) {
		this.numeroPokedex = numeroPokedex;
		this.tipo = tipo;
		this.name = name;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
		this.categoría = categoría;
		this.habilidad = habilidad;
		this.URL = URL;
		this.tipo2 = "NULL";
	}
	
	//Getters y Setters
	public int getNumeroPokedex() {
		return numeroPokedex;
	}
	public void setNumeroPokedex(int numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo2() {
		return tipo2;
	}
	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getCategoría() {
		return categoría;
	}
	public void setCategoría(String categoría) {
		this.categoría = categoría;
	}
	public String getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
	public String getURL() {
		return URL;
	}

	@Override
	public String toString() {
		return "count: " + PokedexView.count + "Pokemon [numeroPokedex=" + numeroPokedex + ", tipo=" + tipo + ", name=" + name + ", sexo=" + sexo
				+ ", altura=" + altura + ", peso=" + peso + ", categoría=" + categoría + ", habilidad=" + habilidad
				+ ", URL=" + URL + "]";
	}
	
	
}
