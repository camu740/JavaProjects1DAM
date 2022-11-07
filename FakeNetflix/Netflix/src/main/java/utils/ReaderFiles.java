package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.ShowDAO;
import models.Show;

/**
 * Lectura de ficheros
 * 
 * @author Adrian Camara Muñoz
 *
 */
public class ReaderFiles {
	/**
	 * Buscar Show en un fichero
	 * 
	 * @param show     Show a buscar
	 * @param fileName Nombre del archivo en el que buscar
	 * @return true si encuentra el Show buscado, false si no.
	 */
	public boolean checkShow(Show show, String fileName) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName), "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				var trozos = line.split(",|;|\t");

				if (show.getShow_id().equals(trozos[0])) {
					return true;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		return false;
	}

	/**
	 * copiar shows de un fichero en la base de datos
	 * 
	 * @param fileName Nombre del fichero a leer
	 */
	public static void llenarBD(String fileName) {

		Scanner sc = null;
		ArrayList<Show> shows = new ArrayList<Show>();
		boolean isString = false;
		String trozoString = "";
		String lineaCompleta = "";
		int count = 0;
		int fila = 0;
		ShowDAO ficheros = new ShowDAO();

		try {
			sc = new Scanner(new File(fileName), "UTF-8");
			sc.nextLine();// cabecera
			while (sc.hasNextLine()) {
				count = 0;
				String s = sc.nextLine();
				// Omite las cadenas internas ""
				var trozos = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				for (String trozo : trozos) {
					if (trozo.startsWith("\"")) {
						trozo = trozo.substring(1, trozo.length());
						trozo = trozo.replaceAll("\"\"", "'");
						isString = true;
					}
					if (trozo.endsWith("\"")) {
						isString = false;
						trozo = trozo.replaceAll("\"\"", "'");
						trozoString += trozo;
						trozo = trozoString;
						trozo = trozo.substring(0, trozo.length() - 1);
						trozoString = "";
					}
					if (!isString) {
						count++;
						lineaCompleta = trozo;
					} else {
						trozoString += trozo + ",";
					}

				}

				// de cada campo del show eliminamos las " y cambiamos las ' por ` para evitar
				// fallos SQL
				for (int i = 0; i < trozos.length; i++) {
					trozos[i] = trozos[i].replace("\"", "");
					trozos[i] = trozos[i].replace("'", "`");
				}

				ficheros.insert(new Show(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], trozos[6],
						trozos[7], trozos[8], trozos[9], trozos[10], trozos[11]));

				shows.add(new Show(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], trozos[6],
						trozos[7], trozos[8], trozos[9], trozos[10], trozos[11]));
				fila++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
