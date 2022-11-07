package utils;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Enviar emails
 * 
 * @author Adrián Cámara Muñoz
 *
 */
public class Emailing {

	// cuenta desde la que enviaremos los correos
	static final String username = Credentials.correoEmailing();
	static final String password = Credentials.passwordEmailing();

	/**
	 * Enviamos email con codigo de validacion al usuario
	 * 
	 * @param correo correo al que enviar el email
	 * @param codigo codigo de validacion a enviar
	 */
	public static void Mail(String correo, int codigo) {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "*");
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("fakenetflix.soporte@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
			message.setSubject("Prueba FakeNetflix");
			message.setText(
					"Querido usuario, esto es su codigo de registro: " + codigo + "\n\n Please do not spam my email!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			System.out.println("No se pudo enviar mensaje al correo seleccionado");
		}
	}
}
