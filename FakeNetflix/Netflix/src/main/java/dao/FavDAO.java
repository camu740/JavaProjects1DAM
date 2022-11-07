package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Show;

/**
 * Sentencias SQL relacionadas con la tabla Favoritos de la Base de Datos
 * 
 * @author Adrián Cámara Muñoz
 *
 */
public class FavDAO extends AbstractDAO {

	/**
	 * Constructor de la BD que hereda de la clase Abstracta
	 */
	public FavDAO() {
		super();
	}

	/**
	 * obtener todos los shows
	 * 
	 * @param idUser id del usuario que queremos sus favoritas
	 * @return ArrayList de Shows con los favoritos del usuario
	 */
	public ArrayList<Show> getAll(int idUser) {
		final String QUERY = "SELECT id, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description "
				+ "FROM Series INNER JOIN Favoritos on Favoritos.id_Show = Series.id WHERE Favoritos.id_User = "
				+ idUser + ";";
		ArrayList<Show> series = new ArrayList<Show>();
		try {
			ResultSet rs = stmt.executeQuery(QUERY);

			while (rs.next()) {
				String show_id = rs.getString("id");
				String type = rs.getString("type");
				String title = rs.getString("title");
				String director = rs.getString("director");
				String cast = rs.getString("cast");
				String country = rs.getString("country");
				String date_added = rs.getString("date_added");
				String release_year = rs.getString("release_year");
				String rating = rs.getString("rating");
				String duration = rs.getString("duration");
				String listed_in = rs.getString("listed_in");
				String description = rs.getString("description");

				Show s = new Show(show_id, type, title, director, cast, country, date_added, release_year, rating,
						duration, listed_in, description);
				series.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return series;
	}

	/**
	 * comprueba si un usuario tiene un show en favoritos
	 * 
	 * @param idShow id del show a comprobar
	 * @param idUser id del usuario a comprobar
	 * @return true si ese usuario tiene ese show como favorito, false si no.
	 */
	public boolean showEncontrado(String idShow, int idUser) {
		final String QUERY = "SELECT id_Show FROM Favoritos where id_User = " + idUser + " and id_Show = '" + idShow
				+ "';";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * inserta un show como favorito para un usuario
	 * 
	 * @param idShow id del show a añadir como favorito
	 * @param idUser id del usuario
	 */
	public void insert(String idShow, int idUser) {
		final String INSERT = "INSERT INTO Favoritos" + " VALUES('" + idShow + "'," + idUser + ");";
		try {
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
			System.out.println("El elemento no se ha podido introducir");
		}
	}

	/**
	 * eliminar una serie como favorito para un usuario
	 * 
	 * @param idShow id del show a añadir como favorito
	 * @param idUser id del usuario
	 */
	public void delete(String idShow, int idUser) {
		final String DELETE = "delete from Favoritos where id_Show = '" + idShow + "' AND id_User = " + idUser + ";";
		try {
			stmt.executeUpdate(DELETE);
		} catch (Exception e) {
			System.out.println("El elemento no se ha podido eliminar");
		}
	}
}
