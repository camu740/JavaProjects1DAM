package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import dao.UserDAO;
import utils.Emailing;
import utils.Hash;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Vista para restablecer la password
 * 
 * @author Adrián Cámara Muñoz
 *
 */
public class CambiarPasswdView {

	// Propiedades
	private JFrame frmChange;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JLabel lblPassword;
	private JLabel lblPasswordConfirm;
	private JButton btnChange;
	private JLabel lblErrorMessage;
	private UserDAO usuarioDAO;
	private String correo;
	private JLabel lblFondo;

	/**
	 * Create the application.
	 */
	public CambiarPasswdView(String correo) {
		this.correo = correo;
		usuarioDAO = new UserDAO();
		initialize();
		frmChange.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. selecciona el icono de la ventana
	 */
	private void initialize() {
		frmChange = new JFrame();
		frmChange.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmChange.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/netflix_icon.png"));
		configureUIComponents();
		configureListener();
	}

	/**
	 * configuración de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmChange.setBounds(100, 100, 900, 750);
		frmChange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChange.getContentPane().setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(56, 109, 185));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(491, 352, 180, 31);
		frmChange.getContentPane().add(passwordField);

		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(300, 352, 159, 31);
		frmChange.getContentPane().add(lblPassword);

		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setForeground(new Color(56, 109, 185));
		passwordFieldConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldConfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordFieldConfirm.setBackground(Color.WHITE);
		passwordFieldConfirm.setBounds(491, 403, 180, 31);
		frmChange.getContentPane().add(passwordFieldConfirm);

		lblPasswordConfirm = new JLabel("Confirm Password");
		lblPasswordConfirm.setForeground(Color.DARK_GRAY);
		lblPasswordConfirm.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPasswordConfirm.setBounds(182, 403, 277, 31);
		frmChange.getContentPane().add(lblPasswordConfirm);

		btnChange = new JButton("");
		btnChange.setIcon(new ImageIcon("assets/images/Confirm.png"));
		btnChange.setBounds(353, 551, 200, 80);
		btnChange.setBorderPainted(false);
		btnChange.setContentAreaFilled(false);
		btnChange.setFocusPainted(false);
		btnChange.setOpaque(false);
		frmChange.getContentPane().add(btnChange);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(152, 484, 596, 42);
		frmChange.getContentPane().add(lblErrorMessage);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("assets/images/fondo.png"));
		lblFondo.setBounds(0, 0, 886, 731);
		frmChange.getContentPane().add(lblFondo);
	}

	/**
	 * configuracion de la activación de los botones
	 */
	private void configureListener() {

		// Enter para ir a confirmar passwd desde passwd
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordFieldConfirm.requestFocus();
				}
			}
		});

		// cambiar contraseña del usuario al pulsar enter desde confirmPasswd
		passwordFieldConfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					changePasswd();
				}
			}
		});

		// cambiar contraseña del usuario
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePasswd();
			}
		});

	}

	/**
	 * método para restablecer la password
	 */
	private void changePasswd() {
		String passwd = new String(passwordField.getPassword());
		String confirmPasswd = new String(passwordFieldConfirm.getPassword());
		String passwdCodified = Hash.HashIt(passwd, "123456");

		// comprueba que las contraseñas no esten vacias, muestra error en caso de
		// estarlas
		if (passwd.equals("") || confirmPasswd.equals("")) {
			lblErrorMessage.setText("ERROR: Las contraseñas no puede estar vacia.");

			// comprueba si las contraseñas coinciden, muestra error en caso de no coincidir
		} else if (!passwd.equals(confirmPasswd)) {
			lblErrorMessage.setText("ERROR: Las contraseñas no coinciden.");

		} else {
			usuarioDAO.setPasswd(correo, passwdCodified);
			usuarioDAO.validado(correo, true);
			lblErrorMessage.setText("Contraseña cambiada con éxito.");

			frmChange.setVisible(false);
			new LoginView();
		}
	}

}