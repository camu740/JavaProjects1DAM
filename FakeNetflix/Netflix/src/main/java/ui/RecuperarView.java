package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import dao.UserDAO;
import utils.Emailing;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Vista de recuperar password
 * 
 * @author Adri�n C�mara Mu�oz
 *
 */
public class RecuperarView {

	// Propiedades
	private JFrame frmRecuperar;
	private JButton btnVolver;
	private JButton btnTengoCodigo;
	private JButton btnNuevoCodigo;
	private JLabel lblErrorMessage;
	private UserDAO usuarioDAO;
	private JLabel lblFondo;

	/**
	 * Create the application.
	 */
	public RecuperarView() {
		usuarioDAO = new UserDAO();
		initialize();
		frmRecuperar.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. selecciona el icono de la ventana
	 */
	private void initialize() {
		frmRecuperar = new JFrame();
		frmRecuperar.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmRecuperar.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/netflix_icon.png"));
		configureUIComponents();
		configureListener();
	}

	/**
	 * configuraci�n de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmRecuperar.setBounds(100, 100, 900, 750);
		frmRecuperar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecuperar.getContentPane().setLayout(null);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon("assets/images/Login.png"));
		btnVolver.setBounds(358, 518, 200, 80);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		frmRecuperar.getContentPane().add(btnVolver);

		btnTengoCodigo = new JButton("");
		btnTengoCodigo.setIcon(new ImageIcon("assets/images/EnterCode.png"));
		btnTengoCodigo.setBounds(358, 413, 200, 80);
		btnTengoCodigo.setBorderPainted(false);
		btnTengoCodigo.setContentAreaFilled(false);
		btnTengoCodigo.setFocusPainted(false);
		btnTengoCodigo.setOpaque(false);
		frmRecuperar.getContentPane().add(btnTengoCodigo);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(151, 608, 596, 42);
		frmRecuperar.getContentPane().add(lblErrorMessage);

		btnNuevoCodigo = new JButton("");
		btnNuevoCodigo.setIcon(new ImageIcon("assets/images/GenerateCode.png"));
		btnNuevoCodigo.setOpaque(false);
		btnNuevoCodigo.setFocusPainted(false);
		btnNuevoCodigo.setContentAreaFilled(false);
		btnNuevoCodigo.setBorderPainted(false);
		btnNuevoCodigo.setBounds(358, 310, 200, 80);
		frmRecuperar.getContentPane().add(btnNuevoCodigo);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("assets/images/fondo.png"));
		lblFondo.setBounds(0, 0, 886, 731);
		frmRecuperar.getContentPane().add(lblFondo);
	}

	/**
	 * configuraci�n de la activacion de los botones
	 */
	private void configureListener() {
		// Volver a iniciar sesi�n
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRecuperar.setVisible(false);
				new LoginView();
			}
		});

		// introducir el c�digo que ya tiene el usuario
		btnTengoCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorMessage.setText(" ");
				String correo = JOptionPane.showInputDialog(frmRecuperar, "Introduce tu correo:", "ejemplo@gmail.com");

				if (usuarioDAO.correoEncontrado(correo)) {
					introducirCodigo(correo);
				} else {
					lblErrorMessage.setText("Correo no registrado, reviselo o crea una cuenta nueva.");
				}
			}
		});

		// enviar nuevo c�digo
		btnNuevoCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorMessage.setText(" ");
				sendCode();
			}
		});
	}

	/**
	 * enviar c�digo de activaci�n al nuevo usuario
	 */
	private void sendCode() {
		String correo = JOptionPane.showInputDialog(frmRecuperar, "Introduce tu correo:", "ejemplo@gmail.com");

		// comprueba si el correo ya existe, muestra error en ese caso
		if (usuarioDAO.correoEncontrado(correo)) {

			int validation = (int) (Math.random() * 1000000);
			usuarioDAO.setCode(correo, validation);

			Emailing.Mail(correo, validation);

			introducirCodigo(correo);

			// en caso de no existir el usuario muestra mensaje de error
		} else {
			lblErrorMessage.setText("Correo no registrado, reviselo o crea una cuenta nueva.");
		}
	}

	/**
	 * Solicita el c�digo de validaci�n
	 * 
	 * @param correo correo del usuario que quiere introducir el c�digo
	 */
	private void introducirCodigo(String correo) {
		if (obtenerCodigo() == usuarioDAO.codigoValidacion(correo)) {
			lblErrorMessage.setText("Codigo correcto.");
			usuarioDAO.validado(correo, true);
			frmRecuperar.dispose();
			new CambiarPasswdView(correo);
		} else {
			lblErrorMessage.setText("Codigo Incorrecto");
		}
	}

	/**
	 * obtener c�digo de validaci�n introducido por el usuario
	 * 
	 * @return c�digo de validaci�n
	 */
	private int obtenerCodigo() {
		int codigo = -1;
		try {
			codigo = Integer.parseInt(
					JOptionPane.showInputDialog(frmRecuperar, "Codigo de activacion", "Activacion de cuenta"));

		} catch (Exception e) {
			lblErrorMessage.setText("El codigo introducido no es v�lido.");
		}

		return codigo;
	}

}