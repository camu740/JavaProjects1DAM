package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import models.Animales;
import models.Usuarios;
import ui.ModifyAnimalView;
import utils.Almacen;

class ModifyAnimalViewTest {
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
	void testModificar() {
		crearAlmacen();
		
		ModifyAnimalView window = new ModifyAnimalView(new JFrame(), Almacen.Users.get(0));
		
		window.tfNombre.setText("Toby");
		window.tfSetEspecie.setText("perro");
		window.tfSetPeso.setText("12");
		window.tfSetRaza.setText("pastor aleman");
		
		window.modificar(Almacen.Users.get(0), 0);
		
		assertEquals("Toby", Almacen.Users.get(0).getMascotas().get(0).getNombre());
		assertEquals("perro", Almacen.Users.get(0).getMascotas().get(0).getEspecie());
		assertEquals(12.0, Almacen.Users.get(0).getMascotas().get(0).getPeso());
		assertEquals("pastor aleman", Almacen.Users.get(0).getMascotas().get(0).getRaza());
	}

}
