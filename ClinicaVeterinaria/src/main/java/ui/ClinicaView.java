package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import models.Animales;
import models.Usuarios;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import utils.Almacen;
import java.awt.Color;

public class ClinicaView {
	
	//Propiedades
	private JFrame frmClinica;
	public static Usuarios user;
	private JFrame parent;
	private JButton btnCloseSesion;
	private JButton btnNewAnimal;
	private JButton btnModifyAnimal;
	private JButton btnDeleteAnimal;
	private JButton btnAnteriorAnimal;
	private JButton btnSiguienteAnimal;
	private JLabel lblSetNombre;
	private JLabel lblRaza;
	private JLabel lblSetRaza;
	private JLabel lblEspecie;
	private JLabel lblSetEspecie;
	private JLabel lblPeso;
	private JLabel lblSetPeso;
	private JLabel lblObservaciones;
	public static int count = 0;
	private JLabel lblSetObservaciones;
	private JLabel lblChip;
	public JLabel lblSetChip;

	/**
	 * Create the application.
	 * @param username Nombre de usuario
	 * @parent Ventana padre desde la que se llama a esta para poder volver a ella.
	 */
	public ClinicaView(Usuarios user, JFrame parent) {
		this.parent = parent;
		this.user = user;
		initialize();
		frmClinica.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * selecciona el icono de la ventana
	 */
	private void initialize() {
		frmClinica = new JFrame();
		frmClinica.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmClinica.setIconImage(Toolkit.getDefaultToolkit().getImage(ClinicaView.class.getResource("/utils/dog.png")));
		configureUIComponents();
		configureListener();
		showAnimal(user,count);

	}
	
	//getters y setters
	public static String getUsername() {
		return user.getUsername();
	}
	
	public static int getCount() {
		return count;
	}

	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmClinica.getContentPane().setLayout(null);
		frmClinica.setBounds(100, 100, 500, 420);
		frmClinica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnCloseSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCloseSesion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCloseSesion.setBounds(354, 338, 120, 37);
		btnCloseSesion.setBorderPainted(false); 
		btnCloseSesion.setContentAreaFilled(false); 
		btnCloseSesion.setFocusPainted(false); 
		btnCloseSesion.setOpaque(false);
		frmClinica.getContentPane().add(btnCloseSesion);

		btnNewAnimal = new JButton("A\u00F1adir Nuevo");
		btnNewAnimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewAnimal.setBounds(20, 253, 120, 37);
		btnNewAnimal.setBorderPainted(false); 
		btnNewAnimal.setContentAreaFilled(false); 
		btnNewAnimal.setFocusPainted(false); 
		btnNewAnimal.setOpaque(false);
		frmClinica.getContentPane().add(btnNewAnimal);

		btnModifyAnimal = new JButton("Modificar");
		btnModifyAnimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifyAnimal.setBounds(20, 299, 120, 37);
		btnModifyAnimal.setBorderPainted(false); 
		btnModifyAnimal.setContentAreaFilled(false); 
		btnModifyAnimal.setFocusPainted(false); 
		btnModifyAnimal.setOpaque(false);
		frmClinica.getContentPane().add(btnModifyAnimal);

		btnDeleteAnimal = new JButton("Borrar");
		btnDeleteAnimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteAnimal.setBounds(20, 338, 120, 37);
		btnDeleteAnimal.setBorderPainted(false); 
		btnDeleteAnimal.setContentAreaFilled(false); 
		btnDeleteAnimal.setFocusPainted(false); 
		btnDeleteAnimal.setOpaque(false);
		frmClinica.getContentPane().add(btnDeleteAnimal);

		btnAnteriorAnimal = new JButton();
		btnAnteriorAnimal.setForeground(Color.LIGHT_GRAY);
		btnAnteriorAnimal.setBackground(Color.DARK_GRAY);
		btnAnteriorAnimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAnteriorAnimal.setBounds(10, 11, 222, 37);
		frmClinica.getContentPane().add(btnAnteriorAnimal);
		
		btnSiguienteAnimal = new JButton();
		btnSiguienteAnimal.setForeground(Color.LIGHT_GRAY);
		btnSiguienteAnimal.setBackground(Color.DARK_GRAY);
		btnSiguienteAnimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSiguienteAnimal.setBounds(252, 11, 222, 37);
		frmClinica.getContentPane().add(btnSiguienteAnimal);

		lblSetNombre = new JLabel("AA");
		lblSetNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSetNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetNombre.setBounds(10, 53, 464, 37);
		frmClinica.getContentPane().add(lblSetNombre);

		lblRaza = new JLabel("Raza");
		lblRaza.setForeground(Color.WHITE);
		lblRaza.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setBounds(333, 90, 120, 30);
		frmClinica.getContentPane().add(lblRaza);

		lblSetRaza = new JLabel("Prueba");
		lblSetRaza.setForeground(Color.WHITE);
		lblSetRaza.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetRaza.setBounds(333, 130, 120, 30);
		frmClinica.getContentPane().add(lblSetRaza);

		lblEspecie = new JLabel("Especie");
		lblEspecie.setForeground(Color.WHITE);
		lblEspecie.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEspecie.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecie.setBounds(179, 90, 120, 30);
		frmClinica.getContentPane().add(lblEspecie);

		lblSetEspecie = new JLabel("Prueba");
		lblSetEspecie.setForeground(Color.WHITE);
		lblSetEspecie.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetEspecie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetEspecie.setBounds(179, 130, 120, 30);
		frmClinica.getContentPane().add(lblSetEspecie);

		lblPeso = new JLabel("Peso");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(20, 171, 120, 30);
		frmClinica.getContentPane().add(lblPeso);

		lblSetPeso = new JLabel("Prueba");
		lblSetPeso.setForeground(Color.WHITE);
		lblSetPeso.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetPeso.setBounds(20, 212, 120, 30);
		frmClinica.getContentPane().add(lblSetPeso);

		lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setForeground(Color.WHITE);
		lblObservaciones.setFont(new Font("Dialog", Font.BOLD, 16));
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setBounds(160, 171, 293, 30);
		frmClinica.getContentPane().add(lblObservaciones);
		
		lblSetObservaciones = new JLabel("Prueba");
		lblSetObservaciones.setVerticalAlignment(SwingConstants.TOP);
		lblSetObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetObservaciones.setForeground(Color.WHITE);
		lblSetObservaciones.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetObservaciones.setBounds(150, 217, 303, 110);
		frmClinica.getContentPane().add(lblSetObservaciones);
		
		lblChip = new JLabel("N\u00BAChip");
		lblChip.setHorizontalAlignment(SwingConstants.CENTER);
		lblChip.setForeground(Color.WHITE);
		lblChip.setFont(new Font("Dialog", Font.BOLD, 16));
		lblChip.setBounds(20, 90, 120, 30);
		frmClinica.getContentPane().add(lblChip);
		
		lblSetChip = new JLabel("Prueba");
		lblSetChip.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetChip.setForeground(Color.WHITE);
		lblSetChip.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetChip.setBounds(20, 130, 120, 30);
		frmClinica.getContentPane().add(lblSetChip);

	}
	
	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
		// cerrar sesion y volver a login
		btnCloseSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//mensaje de confirmacion para salir
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere Salir?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
				
				//en caso de decir que si sale de la ventana y vuelve a login
				if(opcion == 0) {
					frmClinica.dispose();
					new LoginView();
				}

			}
		});

		// Crear un nuevo animal
		btnNewAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClinica.setVisible(false);
				new AddAnimalView(frmClinica, user);
			}
		});

		// Modificar animal existente
		btnModifyAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClinica.setVisible(false);
				new ModifyAnimalView(frmClinica, user);
			}
		});

		// Eliminar animal existente
		btnDeleteAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este Animal?", "Eliminar Animal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
				
				if(opcion == 0) {
					user.quitarMascota(count);
					showAnimal(user,count);
				}
			}
		});

		// Ver Anterior animal de la lista
		btnAnteriorAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//en caso de ser el primero de la lista, el anterior será el último
				if(count == 0) {
					count = user.getMascotas().size() - 1;
				
				//si no es el primero de la lista, muestra el anterior
				}else {
					count--;
				}
				
				showAnimal(user,count);

			}
		});

		// Ver Siguiente animal de la lista
		btnSiguienteAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//en caso de ser el ultimo de la lista, el siguiente será el primero
				if(count == user.getMascotas().size() - 1) {
					count = 0;
					
				//si no es el ultimo de la lista, muestra el siguiente
				}else {
					count++;
				}
				
				showAnimal(user,count);
				
			}
		});

	}
	
	/**
	 * muestra los datos del animal
	 * @param count posicion del animal a mostrar
	 */
	public void showAnimal(Usuarios user, int count) {
		
		//si no hay animales en la lista muestra la pantalla vacia
		if(user.getMascotas().size() == 0) {
			mostrarVacio();
		
		//si hay animales registrados muestra el animal en cuestion
		}else {
			
			btnAnteriorAnimal.setVisible(true);
			btnSiguienteAnimal.setVisible(true);
			btnModifyAnimal.setVisible(true);
			btnDeleteAnimal.setVisible(true);
			
		
		//Boton Anterior Animal (muestra el nombre del animal que mostrará al hacer click)
		if(count == 0) {
			btnAnteriorAnimal.setText("nº" + user.getMascotas().get(user.getMascotas().size()-1).getNumChip() + " " + user.getMascotas().get(user.getMascotas().size()-1).getNombre());
		}else {
			btnAnteriorAnimal.setText("nº" + user.getMascotas().get(count - 1).getNumChip() + " " + user.getMascotas().get(count - 1).getNombre());
		}
		
		//Boton Siguiente Animal (muestra el nombre del animal que mostrará al hacer click)
		if(count == user.getMascotas().size()-1) {
			btnSiguienteAnimal.setText("nº" + user.getMascotas().get(0).getNumChip() + " " + user.getMascotas().get(0).getNombre());
		}else {
			btnSiguienteAnimal.setText("nº" + user.getMascotas().get(count + 1).getNumChip() + " " + user.getMascotas().get(count + 1).getNombre());

		}
		
		// Establecemos numero y nombre de Animal.
		lblSetNombre.setText("nº" + user.getMascotas().get(count).getNumChip() + " " + user.getMascotas().get(count).getNombre());

		// Establecemos los atributos del Animal en cuestión.
		lblSetNombre.setText(user.getMascotas().get(count).getNombre());
		lblSetChip.setText(Double.toString(user.getMascotas().get(count).getNumChip()));
		lblSetPeso.setText(Double.toString(user.getMascotas().get(count).getPeso()));
		lblSetRaza.setText(user.getMascotas().get(count).getRaza());
		lblSetEspecie.setText(user.getMascotas().get(count).getEspecie());
		lblSetObservaciones.setText(user.getMascotas().get(count).getObservaciones());

		}
	}
	
	/**
	 * en caso de no haber animales guardados en la clinica mostrará la pantalla vacia indicando que no hay ningun animal y solo permitirá crear uno nuevo o salir.
	 */
	public void mostrarVacio() {
		lblSetNombre.setText("");
		lblSetPeso.setText("N/A");
		lblSetChip.setText("N/A");
		lblSetRaza.setText("N/A");
		lblSetEspecie.setText("N/A");
		lblSetObservaciones.setText("N/A");
		btnAnteriorAnimal.setVisible(false);
		btnSiguienteAnimal.setVisible(false);
		btnModifyAnimal.setVisible(false);
		btnDeleteAnimal.setVisible(false);
	}
}