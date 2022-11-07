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

public class ModifyAnimalView {

	// Propiedades
	private JFrame frmModifyAnimal;
	private Usuarios user;
	private JFrame parent;
	private JButton btnVolver;
	private JButton btnModify;
	private JLabel lblEspecie;
	private JLabel lblRaza;
	private JLabel lblObservaciones;
	private JLabel lblPeso;
	public JTextField tfSetEspecie;
	public JTextField tfSetRaza;
	public JTextField tfSetPeso;
	private JTextField tfSetObservaciones;
	public JTextField tfNombre;
	private JLabel lblErrorMessage;
	private JLabel lblNumChip;
	private JLabel lblNombre;
	private JLabel lblModifyAnimal;
	private JLabel lblNumero;

	/**
	 * Create the application.
	 */
	public ModifyAnimalView(JFrame parent, Usuarios user) {
		this.parent = parent;
		this.user = user;
		initialize();
		frmModifyAnimal.setVisible(true);
	}

	/**
	 * Inicializa la ventana de añadir nuevos pokemons Seleccion de icono para la
	 * ventana
	 */
	private void initialize() {
		frmModifyAnimal = new JFrame();
		frmModifyAnimal.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmModifyAnimal.setIconImage(Toolkit.getDefaultToolkit().getImage(ClinicaView.class.getResource("/utils/dog.png")));
		configureUIComponents();
		configureListener();
		showAnimal();

	}

	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmModifyAnimal.getContentPane().setLayout(null);
		frmModifyAnimal.setBounds(100, 100, 500, 420);
		frmModifyAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(20, 328, 120, 45);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		frmModifyAnimal.getContentPane().add(btnVolver);

		btnModify = new JButton("Modificar");
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModify.setBounds(340, 328, 120, 45);
		btnModify.setBorderPainted(false);
		btnModify.setContentAreaFilled(false);
		btnModify.setFocusPainted(false);
		btnModify.setOpaque(false);
		frmModifyAnimal.getContentPane().add(btnModify);

		lblEspecie = new JLabel("Especie");
		lblEspecie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecie.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecie.setBounds(183, 111, 108, 30);
		frmModifyAnimal.getContentPane().add(lblEspecie);

		lblRaza = new JLabel("Raza");
		lblRaza.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setBounds(352, 111, 108, 30);
		frmModifyAnimal.getContentPane().add(lblRaza);

		lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setBounds(20, 191, 440, 30);
		frmModifyAnimal.getContentPane().add(lblObservaciones);

		lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(20, 111, 108, 30);
		frmModifyAnimal.getContentPane().add(lblPeso);

		tfSetEspecie = new JTextField();
		tfSetEspecie.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetEspecie.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetEspecie.setBounds(183, 151, 108, 30);
		frmModifyAnimal.getContentPane().add(tfSetEspecie);
		tfSetEspecie.setColumns(10);

		tfSetRaza = new JTextField();
		tfSetRaza.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetRaza.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetRaza.setColumns(10);
		tfSetRaza.setBounds(352, 151, 108, 30);
		frmModifyAnimal.getContentPane().add(tfSetRaza);

		tfSetPeso = new JTextField();
		tfSetPeso.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetPeso.setColumns(10);
		tfSetPeso.setBounds(20, 151, 108, 30);
		frmModifyAnimal.getContentPane().add(tfSetPeso);

		tfSetObservaciones = new JTextField();
		tfSetObservaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetObservaciones.setColumns(10);
		tfSetObservaciones.setBounds(20, 228, 440, 45);
		frmModifyAnimal.getContentPane().add(tfSetObservaciones);

		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tfNombre.setBounds(333, 71, 127, 30);
		frmModifyAnimal.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		lblModifyAnimal = new JLabel("Modificar Animal");
		lblModifyAnimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyAnimal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModifyAnimal.setBounds(10, 10, 466, 51);
		frmModifyAnimal.getContentPane().add(lblModifyAnimal);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(20, 283, 440, 26);
		frmModifyAnimal.getContentPane().add(lblErrorMessage);

		lblNumChip = new JLabel("N\u00BAChip");
		lblNumChip.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumChip.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumChip.setBounds(20, 71, 80, 30);
		frmModifyAnimal.getContentPane().add(lblNumChip);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(243, 70, 92, 30);
		frmModifyAnimal.getContentPane().add(lblNombre);

		lblNumero = new JLabel("numero");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumero.setBounds(110, 71, 123, 30);
		frmModifyAnimal.getContentPane().add(lblNumero);

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
					frmModifyAnimal.dispose();
					parent.setVisible(true);
				}
			}
		});

		// Modificar Animal
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Si hay campos vacios no se puede crear
				if (tfNombre.getText().equals("") || tfSetEspecie.getText().equals("") || tfSetPeso.getText().equals("")
						|| tfSetRaza.getText().equals("")) {

					lblErrorMessage.setText("ERROR: 1-No puede haber campos vacíos.");

				} else {

					try {
						if (tfSetObservaciones.getText().equals("")) {
							// creamos el nuevo animal
							modificar(user, ClinicaView.count);

						} else {
							// creamos el nuevo animal
							modificar(user, ClinicaView.count);
							user.getMascotas().get(ClinicaView.count).setObservaciones(tfSetObservaciones.getText());

						}
						// mensaje de confirmacion de animal modificado
						JOptionPane.showMessageDialog(btnModify, "Animal modificado correctamente.");

						frmModifyAnimal.setVisible(false);
						new ClinicaView(user, frmModifyAnimal);

					} catch (Exception e2) {
						// si algun campo numerico se introducen letras salta mensaje de error
						JOptionPane.showMessageDialog(btnModify,
								"Datos inválidos, revisa que el peso(separar decimales por puntos) y el número de chip sean numéricos.");
					}
				}
			}

		});

	}

	/**
	 * Muestra los datos del animal
	 */
	private void showAnimal() {

		// Establecemos numero y nombre de Pokémon.
		tfNombre.setText(user.getMascotas().get(ClinicaView.count).getNombre());
		lblNumero.setText(user.getMascotas().get(ClinicaView.count).getNumChip() + "");

		// Establecemos los atributos del Pokemon en cuestión.
		tfSetPeso.setText(Double.toString(user.getMascotas().get(ClinicaView.count).getPeso()));
		tfSetEspecie.setText(user.getMascotas().get(ClinicaView.count).getEspecie());
		tfSetRaza.setText(user.getMascotas().get(ClinicaView.count).getRaza());
		tfSetObservaciones.setText(user.getMascotas().get(ClinicaView.count).getObservaciones());

	}
	
	public void modificar(Usuarios user, int cont)
	{
		user.getMascotas().get(cont).setNombre(tfNombre.getText());
		user.getMascotas().get(cont).setEspecie(tfSetEspecie.getText());
		user.getMascotas().get(cont).setRaza(tfSetRaza.getText());
		user.getMascotas().get(cont).setPeso(Double.parseDouble(tfSetPeso.getText()));
	}
}