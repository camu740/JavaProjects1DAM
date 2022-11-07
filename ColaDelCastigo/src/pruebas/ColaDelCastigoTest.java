package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import models.Animales;
import models.ColaDelCastigo;

class ColaDelCastigoTest {

	Comparator<Animales> comp = (Animales o1, Animales o2) -> Double.valueOf(o1.getPeso()).compareTo(o2.getPeso());
	ColaDelCastigo<Animales> cola = new ColaDelCastigo<Animales>(comp);
	
	Animales animal1 = new Animales("Paco", 1);
	Animales animal2 = new Animales("Manolo", 5);
	Animales animal3 = new Animales("Roberto", 20);
	
	ArrayList<Animales> lista_Animales = new ArrayList<Animales>();
	
	@Test
	void testEmpty() {
		assertTrue(cola.isEmpty());
	}
	
	@Test
	/**
	 * comprobamos que añade todos los elementos viendo que el tamaño sea igual al numero de elementos añadidos
	 * @throws Exception si no se puede añadir algun elemento
	 */
	void testAddYSize() throws Exception {
		cola.add(animal1);
		cola.add(animal2);
		cola.add(animal3);
		cola.add(new Animales("Juan", 6));
		cola.add(new Animales("Maria", 12));
		cola.add(new Animales("Curro", 25));
		cola.add(new Animales("Beienvenido", 22.5));
		cola.add(new Animales("Natalidad", 5));
		cola.add(new Animales("Asuncion", 15));
		cola.add(new Animales("Angustias", 2));
		
		assertEquals(10, cola.size(), "debe contener 10 elementos");
	}
	
	@Test
	/**
	 * comprobamos si contains devuelve true si la cola contiene ese elemento
	 * @throws Exception si no se puede añadir algun elemento
	 */
	void testContains() throws Exception {
		cola.add(animal1);
		assertTrue(cola.contains(animal1));
	}
	
	@Test
	/**
	 * comprobamos borrar elementos usando contains para ver que ya no está
	 * @throws Exception si no se puede añadir algun elemento
	 */
	void testRemove() throws Exception {
		cola.add(animal1);
		cola.remove(animal1);
		assertFalse(cola.contains(animal1));

	}
	
	@Test
	/**
	 * comprobamos que contiene una lista dada
	 * @throws Exception si no se puede añadir algun elemento
	 */
	void testContainsAll() throws Exception {
		lista_Animales.add(animal2);
		lista_Animales.add(animal3);
		
		cola.add(animal2);
		cola.add(animal3);
		
		assertTrue(cola.containsAll(lista_Animales));
	}
	
	@Test
	/**
	 * comprobamos que borra todo lo de la lista mediante containsAll
	 * @throws Exception si no se puede añadir algun elemento
	 */
	void testRemoveAll() throws Exception {
		lista_Animales.add(animal2);
		lista_Animales.add(animal3);
		
		cola.add(animal1);
		cola.add(animal2);
		cola.add(animal3);
		
		cola.removeAll(lista_Animales);
		
		assertFalse(cola.containsAll(lista_Animales));
	}
	
	@Test
	/**
	 * comprobamos que retainAll borra todo lo que no está la lista usando contains y containsAll
	 * @throws Exception si no se puede añadir algun elemento
	 */
	void testRetainAll() throws Exception {
		lista_Animales.add(animal2);
		lista_Animales.add(animal3);
		
		cola.add(animal1);
		cola.add(animal2);
		cola.add(animal3);
		
		cola.retainAll(lista_Animales);
		
		assertFalse(cola.contains(animal1));
		assertTrue(cola.containsAll(lista_Animales));

	}
	
	@Test 
	/**
	 * comprobamos que poll borra solo el primer elemento de la lista
	 * @throws Exception si no se puede añadir algun elemento
	 */
	void testPoll() throws Exception {
		cola.add(animal1);
		cola.add(animal2);
		
		cola.poll();
		
		assertTrue(cola.contains(animal2));
		assertFalse(cola.contains(animal1));
	}
	
	@Test
	/**
	 * comprobamos que los dos metodos que tenemos para obtener el primer elemento de la lista funcionan
	 * @throws Exception si no se puede añadir algun elemento
	 */
	void testObtener() throws Exception {
		cola.add(animal1);
		cola.add(animal2);
		cola.add(animal3);
		
		assertEquals(animal1, cola.element(), "debe ser el primer elemento");
		assertEquals(cola.element(), cola.peek(), "ambas deben devolver el primero");
	}

}
