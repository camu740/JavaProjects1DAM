package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import models.Animales;
import models.ColaDelCastigo;
import models.ComparadorAnimales;

public class MainApp {
	public static void main(String[] args) throws Exception {

		Comparator<Animales> comp = (Animales o1, Animales o2) -> Double.valueOf(o1.getPeso()).compareTo(o2.getPeso());

		// Creamos una cola del castigo con su comparador en una clase
		//ColaDelCastigo<Animales> cola = new ColaDelCastigo<Animales>(new ComparadorAnimales());

		// Creamos una cola del castigo con su comparador con una funcion lambda
		//ColaDelCastigo<Animales> cola = new ColaDelCastigo<Animales>((Animales o1, Animales o2) -> Double.valueOf(o1.getPeso()).compareTo(o2.getPeso()));
		
		// Creamos una cola del castigo con su comparador con una variable que tiene una funcion lambda
		ColaDelCastigo<Animales> cola = new ColaDelCastigo<Animales>(comp);
		
		//vemos si la cola está vacía
		System.out.println("Está vacía: " + cola.isEmpty());
		System.out.println();
		
		//añadimos elementos a la cola
		System.out.println("Añadimos elementos a la cola");
		System.out.println();
		
		Animales animal1 = new Animales("Paco", 1);
		Animales animal2 = new Animales("Manolo", 5);
		Animales animal3 = new Animales("Roberto", 20);
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
		
		//vemos el tamaño de la cola
		System.out.println("tamaño cola: " + cola.size());
		System.out.println();
		
		//comprobamos si contiene al animal1
		System.out.println("¿Cola contiene Curro?: " + cola.contains(animal1));
		System.out.println();
		
		//borramos al animal1
		System.out.println("¿Se ha eliminado animal1?: " + cola.remove(animal1));
		System.out.println();
		
		ArrayList<Animales> lista_Animales = new ArrayList<Animales>();
		
		lista_Animales.add(animal2);
		lista_Animales.add(animal3);
		
		//comprobamos si contiene a lista_Animales
		System.out.println("¿Cola contiene los animales de la lista?: " + cola.containsAll(lista_Animales));
		System.out.println();
		
		//eliminamos de la cola la coleccion de lista_Animales
		System.out.println("Elementos eliminados: " + cola.removeAll(lista_Animales));
		System.out.println();
		
		//eliminamos de la cola los elementos que no estén en la coleccion de lista_Animales
		cola.add(animal1);
		cola.add(animal2);
		System.out.println("Elementos eliminados: " + cola.retainAll(lista_Animales));
		System.out.println();
		
		//eliminamos todo de la cola
		//cola.clear();

		//añadimos elementos a la cola
		System.out.println("Añadimos elementos a la cola");
		System.out.println();

		cola.add(animal1);
		cola.add(animal2);
		cola.add(animal3);
		cola.add(new Animales("Juan", 6));
		cola.add(new Animales("Maria", 12));
		cola.offer(new Animales("Curro", 25));
		cola.offer(new Animales("Beienvenido", 22.5));
		cola.offer(new Animales("Natalidad", 5));
		cola.offer(new Animales("Asuncion", 15));
		cola.offer(new Animales("Angustias", 2));

		//eliminamos de la cola el ultimo elemento
		System.out.println("Elemento eliminado: " + cola.remove());
		System.out.println();
		
		//eliminamos de la cola el primer elemento
		System.out.println("Elemento eliminado: " + cola.poll());
		System.out.println();
		
		//obtenemos de la cola el primer elemento
		System.out.println("Elemento obtenido: " + cola.element());
		System.out.println();
		
		//obtenemos de la cola el primer elemento
		System.out.println("Elemento obtenido: " + cola.peek());
		System.out.println();
				
		//mostramos los elementos de la lista a través de un iterador
		Iterator<Double> ite = cola.iterator();
		
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
				
	}
	
	
}
