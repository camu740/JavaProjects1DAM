package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import models.Animales;
import models.Usuarios;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import utils.Almacen;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class AddAnimalView {

	// Propiedades
	private JFrame frmAddAnimal;
	private Usuarios user;
	private JFrame parent;
	private JButton btnVolver;
	private JButton btnAdd;
	private JLabel lblEspecie;
	private JLabel lblRaza;
	private JLabel lblObservaciones;
	private JLabel lblPeso;
	private JTextField tfSetEspecie;
	private JTextField tfSetRaza;
	private JTextField tfSetPeso;
	private JTextField tfSetObservaciones;
	private JTextField tfNombre;
	private JTextField tfNumChip;
	private JLabel lblAddAnimal;
	private JLabel lblErrorMessage;
	private JLabel lblNumChip;
	private JLabel lblNombre;

	/**
	 * Create the application.
	 */
	public AddAnimalView(JFrame parent, Usuarios user) {
		this.parent = parent;
		this.user = user;
		initialize();
		frmAddAnimal.setVisible(true);
	}

	/**
	 * Inicializa la ventana de añadir nuevos pokemons Seleccion de icono para la
	 * ventana
	 */
	private void initialize() {
		frmAddAnimal = new JFrame();
		frmAddAnimal.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmAddAnimal.setIconImage(Toolkit.getDefaultToolkit().getImage(ClinicaView.class.getResource("/utils/dog.png")));
		configureUIComponents();
		configureListener();
	}

	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmAddAnimal.getContentPane().setLayout(null);
		frmAddAnimal.setBounds(100, 100, 500, 420);
		frmAddAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(20, 328, 120, 45);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		frmAddAnimal.getContentPane().add(btnVolver);

		btnAdd = new JButton("A\u00F1adir");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(340, 328, 120, 45);
		btnAdd.setBorderPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setFocusPainted(false);
		btnAdd.setOpaque(false);
		frmAddAnimal.getContentPane().add(btnAdd);

		lblEspecie = new JLabel("Especie");
		lblEspecie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecie.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecie.setBounds(183, 111, 108, 30);
		frmAddAnimal.getContentPane().add(lblEspecie);

		lblRaza = new JLabel("Raza");
		lblRaza.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setBounds(352, 111, 108, 30);
		frmAddAnimal.getContentPane().add(lblRaza);

		lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setBounds(20, 191, 440, 30);
		frmAddAnimal.getContentPane().add(lblObservaciones);

		lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(20, 111, 108, 30);
		frmAddAnimal.getContentPane().add(lblPeso);

		tfSetEspecie = new JTextField();
		tfSetEspecie.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetEspecie.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetEspecie.setBounds(183, 151, 108, 30);
		frmAddAnimal.getContentPane().add(tfSetEspecie);
		tfSetEspecie.setColumns(10);

		tfSetRaza = new JTextField();
		tfSetRaza.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetRaza.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetRaza.setColumns(10);
		tfSetRaza.setBounds(352, 151, 108, 30);
		frmAddAnimal.getContentPane().add(tfSetRaza);

		tfSetPeso = new JTextField();
		tfSetPeso.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetPeso.setColumns(10);
		tfSetPeso.setBounds(20, 151, 108, 30);
		frmAddAnimal.getContentPane().add(tfSetPeso);

		tfSetObservaciones = new JTextField();
		tfSetObservaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetObservaciones.setColumns(10);
		tfSetObservaciones.setBounds(20, 228, 440, 45);
		frmAddAnimal.getContentPane().add(tfSetObservaciones);

		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tfNombre.setBounds(333, 71, 127, 30);
		frmAddAnimal.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		tfNumChip = new JTextField();
		tfNumChip.setHorizontalAlignment(SwingConstants.CENTER);
		tfNumChip.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfNumChip.setColumns(10);
		tfNumChip.setBounds(110, 71, 127, 30);
		frmAddAnimal.getContentPane().add(tfNumChip);

		lblAddAnimal = new JLabel("A\u00F1adir Animal");
		lblAddAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAnimal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddAnimal.setBounds(10, 10, 466, 51);
		frmAddAnimal.getContentPane().add(lblAddAnimal);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(20, 283, 440, 26);
		frmAddAnimal.getContentPane().add(lblErrorMessage);

		lblNumChip = new JLabel("N\u00BAChip");
		lblNumChip.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumChip.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumChip.setBounds(20, 71, 80, 30);
		frmAddAnimal.getContentPane().add(lblNumChip);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(243, 70, 92, 30);
		frmAddAnimal.getContentPane().add(lblNombre);

	}

	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {

		// volver a Clinica View
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// mensaje de confirmacion antes de salir
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere Volver?", "Salir",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (opcion == 0) {
					frmAddAnimal.dispose();
					parent.setVisible(true);
				}
			}
		});

		// Crear Nuevo Animal
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean find = false;
				for (Animales p : user.getMascotas()) {
					// Si el numero de chip ya lo usa otro Animal
					if (tfNumChip.getText().equals(p.getNumChip())) {
						lblErrorMessage.setText("ERROR: El chip del Animal ya pertenece a otro Animal.");
						find = true;
						break;
					}
				}

				// si no existe ni el nombre ni el numero podemos crearlo
				if (!find) {

					// Si hay campos vacios no se puede crear
					if (tfNumChip.getText().equals("") || tfNombre.getText().equals("")
							|| tfSetEspecie.getText().equals("") || tfSetPeso.getText().equals("")
							|| tfSetRaza.getText().equals("")) {
					
						lblErrorMessage.setText("ERROR: No puede haber campos vacíos.");

					} else {

						try {
							if(tfSetObservaciones.getText().equals("")) {
								// creamos el nuevo animal
								añadirAnimalSinComentario(user);
							}else {
								// creamos el nuevo animal
								añadirAnimalConComentario(user);
							}
							

							// mensaje de confirmacion de nuevo animal
							JOptionPane.showMessageDialog(btnAdd, "Animal añadido correctamente.");

							frmAddAnimal.setVisible(false);
							new ClinicaView(user, frmAddAnimal);

						} catch (Exception e2) {
							// si algun campo numerico se introducen letras salta mensaje de error
							JOptionPane.showMessageDialog(btnAdd,
									"Datos inválidos, revisa que el peso y el número de chip sean numéricos.");
						}
					}
				}
			}
		});
	}
	
	private void añadirAnimalConComentario(Usuarios user)
	{
		user.addMascota(new Animales(tfNombre.getText(), 
				Integer.valueOf(tfNumChip.getText()),  
				tfSetEspecie.getText(), 
				tfSetRaza.getText(), 
				Double.parseDouble(tfSetPeso.getText()),
				tfSetObservaciones.getText()));
	}
	
	private void añadirAnimalSinComentario(Usuarios user)
	{
		user.addMascota(new Animales(tfNombre.getText(), 
				Integer.valueOf(tfNumChip.getText()),  
				tfSetEspecie.getText(), 
				tfSetRaza.getText(), 
				Double.parseDouble(tfSetPeso.getText())));
	}
}