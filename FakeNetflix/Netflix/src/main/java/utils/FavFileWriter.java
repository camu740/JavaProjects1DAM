package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dao.FavDAO;
import models.Show;

/**
 * Escritura en Fichero de favoritos
 * 
 * @author Adrián Cámara Muñoz
 *
 */
public class FavFileWriter {

	/**
	 * Crea un archivo csv para guardar los shows favoritos del usuario
	 * 
	 * @param FileName  nombre del fichero
	 * @param idUser    id del usuario que crea el fichero
	 * @param separator separador seleccionado por el usuario
	 */
	public static void writer(String FileName, int idUser, String separator) {

		FavDAO favDAO = new FavDAO();
		ArrayList<Show> favs = favDAO.getAll(idUser);
		ReaderFiles reader = new ReaderFiles();

		String favoritos = "assets/favFile/" + FileName + ".csv";
		File file = new File(favoritos);
		FileWriter fw = null;

		try {
			if (file.createNewFile()) {
				fw = new FileWriter(file, true);

				fw.write(
						"Show Id, type, title, director, cast, country, date added, release year, rating. duration, listed in, description ");

			} else {
				fw = new FileWriter(file, true);
			}

			for (Show s : favs) {

				if (!reader.checkShow(s, favoritos)) {

					String newShow = nuevoShow(s, separator);

					// Escribe en el archivo el nuevo show
					fw.write("\n" + newShow);
					fw.flush();
				}
			}

			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * generar próxima linea a anyadir en el fichero
	 * 
	 * @param s          show a añadir
	 * @param separatorn separador utilizado
	 * @return linea a anyadir
	 */
	private static String nuevoShow(Show s, String separator) {
		return (s.getShow_id() + separator + s.getType() + separator + s.getTitle() + separator + s.getDirector()
				+ separator + s.getCast() + separator + s.getCountry() + separator + s.getDate_added() + separator
				+ s.getRelease_year() + separator + s.getRating() + separator + s.getDuration() + separator
				+ s.getListed_in() + separator + s.getDescription());

	}

}
