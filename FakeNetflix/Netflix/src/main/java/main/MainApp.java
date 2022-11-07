package main;
import ui.LoginView;
import utils.ReaderFiles;

/**
 * Aplicacion Main del programa
 * @author Adrián Cámara Muñoz
 *
 */
public class MainApp {
	public static void main(String[] args) {
		//solo uso esto manualmente para llenar la base de datos de series
		//FileReaderDB.llenarBD("netflix_titles.csv");
		
		new LoginView();
	}
}