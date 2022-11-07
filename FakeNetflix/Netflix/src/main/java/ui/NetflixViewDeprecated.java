package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import dao.ShowDAO;
import dao.UserDAO;
import models.Show;
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

/**
 * Vista de Netflix V1.0 (no usado)
 * @author Adrián Cámara Muñoz
 *
 */
public class NetflixViewDeprecated {

	// Propiedades
	private JFrame parent;
	private String correo;
	private JFrame frmNetflix;
	private UserDAO usuarioDAO;
	private JTextField tfConsulta;
	private JLabel lblBuscador;
	private JLabel lblType;
	private JComboBox<String> comboBox;
	private JLabel lblTitle;
	private JLabel lblDirector;
	private JLabel lblCast;
	private JLabel lblCountry;
	private JLabel lblDateAdded;
	private JLabel lblReleaseYear;
	private JLabel lblRating;
	private JLabel lblDurating;
	private JLabel lblListedIn;
	private JLabel lblDescription;
	private JButton btnVolver;
	private JButton btnNext;
	private JButton btnPreview;
	private JButton btnBuscador;
	private JButton btnGenerarFichero;
	private JButton btnFavorito;
	private ShowDAO showDAO;
	private ArrayList<Show> lista;
	private int count;
	
	/**
	 * Create the application.
	 */
	public NetflixViewDeprecated(String correo, JFrame parent) {
		this.correo = correo;
		this.parent = parent;
		count = 0;
		showDAO = new ShowDAO();
		lista = showDAO.getAll();
		usuarioDAO = new UserDAO();
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
		showData();
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
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Title", "Country", "Director", "Release_year"}));
		comboBox.setBounds(143, 107, 214, 43);
		frmNetflix.getContentPane().add(comboBox);

		tfConsulta = new JTextField();
		tfConsulta.setBounds(367, 107, 368, 43);
		frmNetflix.getContentPane().add(tfConsulta);
		tfConsulta.setColumns(10);
		
		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblType.setBounds(86, 205, 390, 35);
		frmNetflix.getContentPane().add(lblType);
		
		lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(86, 250, 390, 35);
		frmNetflix.getContentPane().add(lblTitle);
		
		lblDirector = new JLabel("Director:");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDirector.setBounds(486, 205, 390, 35);
		frmNetflix.getContentPane().add(lblDirector);
		
		lblCast = new JLabel("Cast:");
		lblCast.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCast.setBounds(86, 297, 790, 35);
		frmNetflix.getContentPane().add(lblCast);
		
		lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCountry.setBounds(486, 251, 390, 35);
		frmNetflix.getContentPane().add(lblCountry);
		
		lblDateAdded = new JLabel("Date added:");
		lblDateAdded.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateAdded.setBounds(86, 343, 390, 35);
		frmNetflix.getContentPane().add(lblDateAdded);
		
		lblReleaseYear = new JLabel("Release year:");
		lblReleaseYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReleaseYear.setBounds(486, 343, 390, 35);
		frmNetflix.getContentPane().add(lblReleaseYear);
		
		lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRating.setBounds(86, 389, 390, 35);
		frmNetflix.getContentPane().add(lblRating);
		
		lblDurating = new JLabel("Duration:");
		lblDurating.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDurating.setBounds(486, 389, 390, 35);
		frmNetflix.getContentPane().add(lblDurating);
		
		lblListedIn = new JLabel("Listed In:");
		lblListedIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListedIn.setBounds(86, 445, 390, 35);
		frmNetflix.getContentPane().add(lblListedIn);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(86, 491, 790, 35);
		frmNetflix.getContentPane().add(lblDescription);
		
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
		btnFavorito.setBounds(86, 629, 120, 41);
		frmNetflix.getContentPane().add(btnFavorito);
		
		btnGenerarFichero = new JButton("Fichero Favoritos");
		btnGenerarFichero.setBounds(226, 629, 120, 41);
		frmNetflix.getContentPane().add(btnGenerarFichero);
		
		btnBuscador = new JButton("Buscar");
		btnBuscador.setBounds(743, 107, 120, 41);
		frmNetflix.getContentPane().add(btnBuscador);
	
	}

	/**
	 * configuración de la activacion de los botones
	 */
	private void configureListener() {
		btnBuscador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String condition = (String) comboBox.getSelectedItem();
				String consulta = tfConsulta.getSelectedText();
				lista.clear();
				lista = showDAO.getShows(condition, consulta);
			}
		});
		
		//ver anterior serie de la lista
		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//en caso de ser el primero de la lista, el anterior será el último
				if(count == 0) {
					count = lista.size() - 1;
				
				//si no es el primero de la lista, muestra el anterior
				}else {
					count--;
				}
				
				show(count);

			
			}
		});
		
		//ver siguiente serie de la lista
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//en caso de ser el ultimo de la lista, el siguiente será el primero
				if(count == lista.size() - 1) {
					count = 0;
					
				//si no es el ultimo de la lista, muestra el siguiente
				}else {
					count++;
				}
				show(count);
			}
		});
	}
	
	/**
	 * rellenar los datos de la serie a mostrar
	 * @param count numero del array de la serie a mostrar
	 */
	private void show(int count) {
		//si no hay series en la lista muestra la pantalla vacia
		if(lista.size() == 0) {
			mostrarVacio();
		}else {
			btnNext.setVisible(true);
			btnPreview.setVisible(true);
			
			//Botón Anterior (muestra el título de la serie que se mostrará al hacer click)
			if(count == 0) {
				btnPreview.setText(lista.get(lista.size()-1).getTitle());
			}else {
				btnPreview.setText(lista.get(count-1).getTitle());
			}
			
			//Botón Posterior (muestra el título de la serie que se mostrará al hacer click)
			if(count == lista.size()-1){
				btnNext.setText(lista.get(0).getTitle());
			}else {
				btnNext.setText(lista.get(count+1).getTitle());
			}
			
			showData();
		}
		
	}
	
	/**
	 * muestra los datos de la serie
	 */
	private void showData() {
		
		if(lista.size() == 0) {
			mostrarVacio();
		}else {
			//establecemos los campos de la serie en cuestión
			lblType.setText(lista.get(count).getType());
			lblTitle.setText(lista.get(count).getTitle());
			lblDirector.setText(lista.get(count).getDirector());
			lblCast.setText(lista.get(count).getCast());
			lblCountry.setText(lista.get(count).getCountry());
			lblDateAdded.setText(lista.get(count).getDate_added());
			lblReleaseYear.setText(lista.get(count).getRelease_year());
			lblRating.setText(lista.get(count).getRating());
			lblDurating.setText(lista.get(count).getDuration());
			lblListedIn.setText(lista.get(count).getListed_in());
			lblDescription.setText(lista.get(count).getDescription());
		}
	}

	/**
	 * En caso de no haber series en la lista se mostrará la pantalla vacia
	 */
	private void mostrarVacio() {
		btnNext.setVisible(false);
		btnPreview.setVisible(false);
		lblTitle.setText("N/A");
		lblDirector.setText("N/A");
		lblCast.setText("N/A");
		lblCountry.setText("N/A");
		lblDateAdded.setText("N/A");
		lblReleaseYear.setText("N/A");
		lblRating.setText("N/A");
		lblDurating.setText("N/A");
		lblListedIn.setText("N/A");
		lblDescription.setText("N/A");
		
	}
}