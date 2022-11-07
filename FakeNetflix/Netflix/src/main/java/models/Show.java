package models;

/**
 * Clase Show
 * 
 * @author Adrián Cámara Muñoz
 *
 */
public class Show {

	// Propiedades
	private String show_id;
	private String type;
	private String title;
	private String director;
	private String cast;
	private String country;
	private String date_added;
	private String release_year;
	private String rating;
	private String duration;
	private String listed_in;
	private String description;

	// builders
	
	/**
	 * Constructor de Show
	 * @param show_id id de la serie
	 * @param type TV Show / Movie
	 * @param title titulo de la serie
	 * @param director director de la serie
	 * @param cast reparto de la serie
	 * @param country pais de donde procede la serie
	 * @param date_added fecha en la que se añade la serie
	 * @param release_year año en el que se estrena la serie
	 * @param rating valoraciones de la serie
	 * @param duration duracion de la serie
	 * @param listed_in Genero de la serie
	 * @param description Descripcion de la serie
	 */
	public Show(String show_id, String type, String title, String director, String cast, String country,
			String date_added, String release_year, String rating, String duration, String listed_in,
			String description) {
		super();
		this.show_id = show_id;
		this.type = type;
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.country = country;
		this.date_added = date_added;
		this.release_year = release_year;
		this.rating = rating;
		this.duration = duration;
		this.listed_in = listed_in;
		this.description = description;
	}

	// Getters and Setters

	public String getShow_id() {
		return show_id;
	}

	public void setShow_id(String show_id) {
		this.show_id = show_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getListed_in() {
		return listed_in;
	}

	public void setListed_in(String listed_in) {
		this.listed_in = listed_in;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Show [show_id=" + show_id + ", type=" + type + ", title=" + title + ", director=" + director + ", cast="
				+ cast + ", country=" + country + ", date_added=" + date_added + ", release_year=" + release_year
				+ ", rating=" + rating + ", duration=" + duration + ", listed_in=" + listed_in + ", description="
				+ description + "]";
	}

}
