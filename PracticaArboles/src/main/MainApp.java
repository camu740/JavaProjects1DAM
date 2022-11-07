package main;

import java.util.ArrayList;

import models.Arbol;
import models.Nodo;

public class MainApp {
	public static void main(String[] args) {
		
		Nodo seis = new Nodo("seis");

		ArrayList<Nodo> hijoscinco = new ArrayList<Nodo>();
		hijoscinco.add(seis);
		
		Nodo cinco = new Nodo("cinco", hijoscinco);
		
		ArrayList<Nodo> hijosdos = new ArrayList<Nodo>();
		hijosdos.add(cinco);
		
		Nodo dos = new Nodo("dos", hijosdos);
		Nodo uno = new Nodo("uno");
		
		ArrayList<Nodo> hijospollo = new ArrayList<Nodo>();
		hijospollo.add(uno);
		hijospollo.add(dos);
		
		Nodo tres = new Nodo("tres");
		
		ArrayList<Nodo> hijoscerdo = new ArrayList<Nodo>();
		hijoscerdo.add(tres);
		
		Nodo cuatro = new Nodo("cuatro");
		
		ArrayList<Nodo> hijosternera = new ArrayList<Nodo>();
		hijosternera.add(cuatro);
		
		Nodo pollo = new Nodo("pollo", hijospollo);
		Nodo cerdo = new Nodo("cerdo", hijoscerdo);
		Nodo ternera = new Nodo("ternera", hijosternera);

		ArrayList<Nodo> hijosraiz = new ArrayList<Nodo>();
		hijosraiz.add(pollo);
		hijosraiz.add(cerdo);
		hijosraiz.add(ternera);
		
		Nodo raiz = new Nodo("~", hijosraiz);
		
		Arbol arbol = new Arbol(raiz);
						
		String buscado = "cinco";
		
		System.out.println("PreOrden: ");
		arbol.preOrden();

		System.out.println();
		System.out.println();
		
		System.out.println("PostOrden: ");
		arbol.postOrden();
		
		System.out.println();
		System.out.println();
		
		System.out.println("Buscamos nodo cuatro: ");
		System.out.println(arbol.buscarNodo("cuatro"));
		
		System.out.println();
		System.out.println();
		
		System.out.println("insertamos nodo siete: ");
		System.out.println(arbol.insertarNodo(cuatro, "siete"));
		
		System.out.println();
		System.out.println();
		
		System.out.println("buscamos recorrido hasta seis: ");
		System.out.println(arbol.path("seis"));
		
		System.out.println();
		System.out.println();
		
		System.out.println("mostramos arbol: ");
		arbol.mostrarArbol();	
		
	}
}
