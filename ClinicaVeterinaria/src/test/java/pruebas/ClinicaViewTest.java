package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import models.Animales;
import models.Usuarios;
import ui.ClinicaView;
import utils.Almacen;

class ClinicaViewTest {
	
	void crearAlmacen()
	{
		Usuarios doctor1 = new Usuarios("doctor1", "doctor");
		Usuarios doctor2 = new Usuarios("doctor2", "doctor");

		Almacen.Users.add(doctor1);
		Almacen.Users.add(doctor2);

		doctor1.addMascota(new Animales("Toby", 12345, "perro", "pastor aleman", 10));
		doctor1.addMascota(new Animales("Misifu", 23456, "gato", "persa", 2));
		doctor1.addMascota(new Animales("gatubela", 34567, "elefante", "gris", 4000));


		doctor2.addMascota(new Animales("firulais", 45678, "perro", "pastor aleman", 7));
		doctor2.addMascota(new Animales("perico", 56789, "pajaro", "canario", 0.5));
		doctor2.addMascota(new Animales("grabie", 90123, "caballo", "pura sangre", 1));
	}
	
	@Test
	void testshowAnimal() {
		crearAlmacen();
		
		ClinicaView window = new ClinicaView(Almacen.Users.get(0), new JFrame());
		
		window.showAnimal(Almacen.Users.get(0), 0);
		
		assertEquals("12345.0", window.lblSetChip.getText());
	}
	
	@Test
	void testMostrarVacio() {
		crearAlmacen();
		
		ClinicaView window = new ClinicaView(Almacen.Users.get(0), new JFrame());
		
		window.mostrarVacio();
		
		assertEquals("N/A", window.lblSetChip.getText());
	}

}
