package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import dao.FavDAO;
import dao.ShowDAO;
import dao.UserDAO;
import models.Show;
import utils.FavFileWriter;
import utils.ReaderFiles;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Vista de Netflix
 * 
 * @author Adrián Cámara Muñoz
 *
 */
public class NetflixView {

	// Propiedades
	private JFrame parent;
	private String correo;
	private JFrame frmNetflix;
	private UserDAO usuarioDAO;
	private JTextField tfConsulta;
	private JLabel lblBuscador;
	private JComboBox<String> comboBox;
	private JButton btnVolver;
	private JButton btnNext;
	private JButton btnPreview;
	private JButton btnBuscador;
	private JButton btnGenerarFichero;
	private JButton btnFavorito;
	private ShowDAO showDAO;
	private UserDAO userDAO;
	private FavDAO favDAO;
	private int idUser;
	private JButton btnRestablecer;
	private JScrollPane scrollPane;
	private JTextArea textAreaSeries;
	private ArrayList<Show> lista;
	private int count;

	/**
	 * Create the application.
	 */
	public NetflixView(String correo, JFrame parent) {
		this.correo = correo;
		this.parent = parent;
		count = 0;
		favDAO = new FavDAO();
		userDAO = new UserDAO();
		showDAO = new ShowDAO();
		lista = showDAO.getAll();
		usuarioDAO = new UserDAO();
		idUser = userDAO.idUser(correo);
		initialize();
		frmNetflix.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNetflix = new JFrame();
		configureUIComponents();
		configureListener();
		show();
	}

	/**
	 * configuración de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmNetflix.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmNetflix.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/netflix_icon.png"));
		frmNetflix.setBounds(100, 100, 900, 750);
		frmNetflix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflix.getContentPane().setLayout(null);
		lblBuscador = new JLabel("Buscador");
		lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBuscador.setBounds(20, 107, 107, 43);
		frmNetflix.getContentPane().add(lblBuscador);

		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Title", "Country", "Director", "Release_year" }));
		comboBox.setBounds(118, 107, 154, 43);
		frmNetflix.getContentPane().add(comboBox);

		tfConsulta = new JTextField();
		tfConsulta.setBounds(282, 109, 321, 43);
		frmNetflix.getContentPane().add(tfConsulta);
		tfConsulta.setColumns(10);

		btnVolver = new JButton("Cerrar Sesi\u00F3n");
		btnVolver.setBounds(701, 629, 120, 41);
		frmNetflix.getContentPane().add(btnVolver);

		btnNext = new JButton(">");
		btnNext.setBounds(455, 36, 408, 49);
		frmNetflix.getContentPane().add(btnNext);

		btnPreview = new JButton("<");
		btnPreview.setBounds(20, 36, 408, 49);
		frmNetflix.getContentPane().add(btnPreview);

		btnFavorito = new JButton("Favorito");
		btnFavorito.setBackground(Color.LIGHT_GRAY);
		btnFavorito.setBounds(86, 629, 120, 41);
		frmNetflix.getContentPane().add(btnFavorito);

		btnGenerarFichero = new JButton("Fichero Favoritos");
		btnGenerarFichero.setBackground(Color.LIGHT_GRAY);
		btnGenerarFichero.setBounds(226, 629, 120, 41);
		frmNetflix.getContentPane().add(btnGenerarFichero);

		btnBuscador = new JButton("Buscar");
		btnBuscador.setBounds(613, 110, 120, 41);
		frmNetflix.getContentPane().add(btnBuscador);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 179, 843, 413);
		frmNetflix.getContentPane().add(scrollPane);

		textAreaSeries = new JTextArea();
		textAreaSeries.setEditable(false);
		scrollPane.setViewportView(textAreaSeries);

		btnRestablecer = new JButton("Restablecer");
		btnRestablecer.setBounds(743, 110, 120, 41);
		frmNetflix.getContentPane().add(btnRestablecer);

	}

	/**
	 * configuración de la activacion de los botones
	 */
	private void configureListener() {

		// cerrar sesión y volver a pantalla de login
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNetflix.dispose();
				parent.setVisible(true);
			}
		});

		// búsqueda de una serie en concreto
		btnBuscador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String condition = (String) comboBox.getSelectedItem();
				String consulta = tfConsulta.getText();

				if (consulta.isBlank()) {
					JOptionPane.showMessageDialog(frmNetflix, "Debe introducir que desea buscar", "Error de Búsqueda",
							JOptionPane.WARNING_MESSAGE);
				} else {
					lista.clear();
					lista = showDAO.getShows(condition, consulta);
					count = 0;
					show();
				}
			}
		});

		// añadir a favorita la serie visualizada en ese momento
		btnFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String idShow = lista.get(count).getShow_id();

				if (favDAO.showEncontrado(idShow, idUser)) {
					favDAO.delete(idShow, idUser);
					btnFavorito.setBackground(Color.LIGHT_GRAY);

				} else {
					favDAO.insert(idShow, idUser);
					btnFavorito.setBackground(Color.CYAN);
				}
			}
		});

		// generar fichero de texto csv con los favoritos del usuario
		btnGenerarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = JOptionPane.showInputDialog(frmNetflix, "Nombre de tu fichero de favoritos:",
						"FileName");
				
				int seleccion = JOptionPane.showOptionDialog(frmNetflix,"Seleccione un separador",
						  "Selector de separadores",JOptionPane.YES_NO_CANCEL_OPTION,
						   JOptionPane.QUESTION_MESSAGE,null,
						  new Object[] { "coma", "punto y coma", "tabulador" },"coma");
				
				String separator = null;

				switch(seleccion) {
				case 0:
					separator = ",";
					break;
				case 1:
					separator = ";";
					break;
				case 2:
					separator = "\t";
					break;
				}
				
				FavFileWriter.writer(fileName, idUser, separator);

			}
		});

		// ver anterior serie de la lista
		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// en caso de ser el primero de la lista, el anterior será el último
				if (count == 0) {
					count = lista.size() - 1;

					// si no es el primero de la lista, muestra el anterior
				} else {
					count--;
				}

				show();

			}
		});

		// restablecer las series y mostrar la lista completa
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.clear();
				lista = showDAO.getAll();
				show();
			}
		});

		// ver siguiente serie de la lista
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// en caso de ser el ultimo de la lista, el siguiente será el primero
				if (count == lista.size() - 1) {
					count = 0;

					// si no es el ultimo de la lista, muestra el siguiente
				} else {
					count++;
				}

				show();

			}

		});
	}

	/**
	 * rellenar los datos de la serie a mostrar
	 * 
	 * @param count numero del array de la serie a mostrar
	 */
	private void show() {
		// si no hay series en la lista muestra la pantalla vacia
		if (lista.size() == 0) {
			mostrarVacio();
		} else {
			btnNext.setVisible(true);
			btnPreview.setVisible(true);
			lblBuscador.setVisible(true);
			btnBuscador.setVisible(true);
			btnFavorito.setVisible(true);
			btnGenerarFichero.setVisible(true);
			tfConsulta.setVisible(true);
			comboBox.setVisible(true);

			// Boton Anterior (muestra el titulo de la serie que se mostrará al hacer click)
			if (count == 0) {
				btnPreview.setText(lista.get(lista.size() - 1).getTitle());
			} else {
				btnPreview.setText(lista.get(count - 1).getTitle());
			}

			// Boton Posterior (muestra el titulo de la serie que se mostrará al hacer
			// click)
			if (count == lista.size() - 1) {
				btnNext.setText(lista.get(0).getTitle());
			} else {
				btnNext.setText(lista.get(count + 1).getTitle());
			}

			colorFav();

			showData();
		}

	}

	/**
	 * color del boton fav dependiendo si está seleccionado como fav o no
	 */
	protected void colorFav() {
		String idShow = lista.get(count).getShow_id();

		if (favDAO.showEncontrado(idShow, idUser)) {
			btnFavorito.setBackground(Color.CYAN);

		} else {
			btnFavorito.setBackground(Color.LIGHT_GRAY);

		}
	}

	private void showData() {
		String cadena = "";

		// establecemos los campos de la serie en cuestión
		cadena += "Title: " + lista.get(count).getTitle() + "\n\n";
		cadena += "Type: " + lista.get(count).getType() + "\n\n";
		cadena += "Director: " + lista.get(count).getDirector() + "\n\n";
		cadena += "Cast: " + lista.get(count).getCast() + "\n\n";
		cadena += "Country: " + lista.get(count).getCountry() + "\n\n";
		cadena += "Date Added: " + lista.get(count).getDate_added() + "\n\n";
		cadena += "Release Year: " + lista.get(count).getRelease_year() + "\n\n";
		cadena += "Rating: " + lista.get(count).getRating() + "\n\n";
		cadena += "Duration: " + lista.get(count).getDuration() + "\n\n";
		cadena += "Listed in: " + lista.get(count).getListed_in() + "\n\n";
		cadena += "Description: " + lista.get(count).getDescription();

		textAreaSeries.setText(cadena);
	}

	/**
	 * En caso de no haber series en la lista se mostrará la pantalla vacia
	 */
	private void mostrarVacio() {
		btnNext.setVisible(false);
		btnPreview.setVisible(false);
		lblBuscador.setVisible(false);
		btnBuscador.setVisible(false);
		btnFavorito.setVisible(false);
		btnGenerarFichero.setVisible(false);
		tfConsulta.setVisible(false);
		comboBox.setVisible(false);
		textAreaSeries.setText("La lista de Series está vacia");

	}
}