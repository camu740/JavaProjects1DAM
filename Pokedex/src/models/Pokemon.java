package models;

import enums.Sexo;
import enums.Tipo;
import ui.PokedexView;

public class Pokemon {
	//Propiedades
	private int numeroPokedex;
	private Tipo tipo;
	private String name;
	private Sexo sexo;
	private double altura; 
	private double peso;
	private String categor�a;
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
	 * @param categor�a Categor�a del pokemon
	 * @param habilidad Habilidad principal del pokemon
	 * @param URL Url de la imagen del pokemon
	 */
	public Pokemon(int numeroPokedex, Tipo tipo, String name, Sexo sexo, double altura, double peso, String categor�a,
			String habilidad, String URL) {
		this.numeroPokedex = numeroPokedex;
		this.tipo = tipo;
		this.name = name;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
		this.categor�a = categor�a;
		this.habilidad = habilidad;
		this.URL = URL;
	}
	
	//Getters y Setters
	public int getNumeroPokedex() {
		return numeroPokedex;
	}
	public void setNumeroPokedex(int numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
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
	public String getCategor�a() {
		return categor�a;
	}
	public void setCategor�a(String categor�a) {
		this.categor�a = categor�a;
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
				+ ", altura=" + altura + ", peso=" + peso + ", categor�a=" + categor�a + ", habilidad=" + habilidad
				+ ", URL=" + URL + "]";
	}
	
	
}
