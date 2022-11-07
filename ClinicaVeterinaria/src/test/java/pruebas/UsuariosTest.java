package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Animales;
import models.Usuarios;

class UsuariosTest {

	@Test
	void testAddMascota() {
		Usuarios doctor1 = new Usuarios("doctor1", "doctor");
		Animales Toby = new Animales("Toby", 12345, "perro", "pastor aleman", 10);
		doctor1.addMascota(Toby);
		
		assertEquals(Toby, doctor1.getMascotas().get(doctor1.getMascotas().size()-1));
	}
	
	@Test
	void testEliminarMascota() {
		Usuarios doctor1 = new Usuarios("doctor1", "doctor");
		Animales Toby = new Animales("Toby", 12345, "perro", "pastor aleman", 10);
		doctor1.addMascota(new Animales("Misifu", 23456, "gato", "persa", 2));
		doctor1.addMascota(Toby);
		doctor1.quitarMascota(0);
		
		assertEquals(1, doctor1.getMascotas().size());
	}

}
