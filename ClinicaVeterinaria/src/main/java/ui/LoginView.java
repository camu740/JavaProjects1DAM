package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import models.Usuarios;
import utils.Almacen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LoginView {
	
	//Propiedades
	private JFrame frmLogin;
	private JTextField tfUser;
	private JButton btnLogin;
	private JButton btnRegister;
	private JLabel lblUser;
	private JLabel lblPasswd;
	private JLabel lblTitulo;
	private JPasswordField pfPassword;
	private JLabel lblErrorMessage;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		this.frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		configureUIComponents();
		configureListener();
	}
	
	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(ClinicaView.class.getResource("/utils/dog.png")));
		frmLogin.setBounds(100, 100, 500, 350);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		this.btnLogin = new JButton("Login");
		btnLogin.setBounds(286, 207, 138, 67);
		btnLogin.setBorderPainted(false); 
        btnLogin.setContentAreaFilled(false); 
        btnLogin.setFocusPainted(false); 
        btnLogin.setOpaque(false);
		frmLogin.getContentPane().add(btnLogin);
		
		btnRegister = new JButton("Registrar");
		btnRegister.setBackground(Color.DARK_GRAY);
		btnRegister.setBounds(83, 207, 138, 67);
		btnRegister.setBorderPainted(false); 
        btnRegister.setContentAreaFilled(false); 
        btnRegister.setFocusPainted(false); 
        btnRegister.setOpaque(false);
		frmLogin.getContentPane().add(btnRegister);
		
		tfUser = new JTextField();
		tfUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfUser.setHorizontalAlignment(SwingConstants.CENTER);
		tfUser.setForeground(new Color (56,109,185));
		tfUser.setBackground(Color.WHITE);
		tfUser.setBounds(219, 103, 171, 24);
		frmLogin.getContentPane().add(tfUser);
		tfUser.setColumns(10);
		
		lblUser = new JLabel("Nombre");
		lblUser.setForeground(Color.DARK_GRAY);
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUser.setBounds(61, 101, 127, 24);
		frmLogin.getContentPane().add(lblUser);
		
		lblPasswd = new JLabel("Contrase\u00F1a");
		lblPasswd.setForeground(Color.DARK_GRAY);
		lblPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPasswd.setBounds(61, 132, 127, 30);
		frmLogin.getContentPane().add(lblPasswd);
		
		lblTitulo = new JLabel("Login");
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(10, 34, 464, 38);
		frmLogin.getContentPane().add(lblTitulo);
		
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		pfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pfPassword.setForeground(new Color (56,109,185));
		pfPassword.setBackground(Color.WHITE);
		pfPassword.setBounds(219, 138, 171, 24);
		frmLogin.getContentPane().add(pfPassword);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(73, 183, 317, 24);
		frmLogin.getContentPane().add(lblErrorMessage);
	}
	
	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
		//boton login para acceder a la pokedex
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				checkLogin(tfUser.getText(), new String (pfPassword.getPassword()));
			}
		});
		
		//Enter tras poner user para ir al campo contraseña
		tfUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pfPassword.requestFocus();
               }
			}
		});
		
		//Enter tras poner contraseña para acceder a la clinica
		pfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin(tfUser.getText(), new String (pfPassword.getPassword()));
				}
			}
		});
		
		//vamos a la pagina de registro para crear una cuenta nueva
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setVisible(false);
				new RegisterView(frmLogin);
			}
		});
	}
	
	/**
	 * comprueba si el usuario y la contraseña son correctos
	 */
	public boolean checkLogin(String user, String pass) {
		String username = user;
		String password = pass;
		boolean find = false;
		
		//busca el usuario
		for(Usuarios u : Almacen.Users) {
			//si usuario y contraseña coinciden accede a la clinica
			if(username.equals(u.getUsername()) && password.equals(u.getPasswd())) {
				frmLogin.dispose();
				new ClinicaView(u, frmLogin);
				find = true;
				return true;
			}
			
			//si el usuario existe pero la contraseña no coincide muestra texto de error
			if(username.equals(u.getUsername()) && !password.equals(u.getPasswd())) {
				lblErrorMessage.setText("ERROR: Contraseña incorrecta.");
				find = true;
			}
			
		}
		
		//si no encuentra al usuario muestra texto de error
		if(!find) {
			lblErrorMessage.setText("ERROR: El usuario no existe.");
		}
		
		return false;
	}
}
