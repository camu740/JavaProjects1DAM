package models;

import java.util.ArrayList;

public class Nodo {

	private String valor;
	private ArrayList<Nodo> hijo;

	//Builders
	public Nodo(String valor) {
		super();
		this.valor = valor;
		this.hijo = new ArrayList<Nodo>();
	}

	public Nodo(String valor, ArrayList<Nodo> hijo) {
		super();
		this.valor = valor;
		this.hijo = hijo;
	}

	//Methods
	
	/**
	 * Comprueba si un nodo es Hoja, es decir, si no tiene hijos
	 * @return true si no tiene hijos, false si tiene hijos
	 */
	public boolean esHoja() {
		return this.hijo == null;
	}

	/**
	 * Comprueba si un Nodo tiene hijos
	 * @param n nodo a comprobar si tiene hijos
	 * @return true si tiene hijos, false si no
	 */
	public boolean tieneHijos(Nodo n) {
		return n.hijo != null;
	}

	/**
	 * muestra el arbol n-ario en forma preOrden
	 */
	public void preOrden(Nodo n) {
		System.out.print(n.valor + ",");

		if (tieneHijos(n)) {
			for (int i = 0; i < n.hijo.size(); i++) {
				preOrden(n.hijo.get(i));
			}
		}

	}

	/**
	 * muestra el arbol n-ario en forma postOrden
	 */
	public void postOrden(Nodo n) {

		if (tieneHijos(n)) {
			for (int i = 0; i < n.hijo.size(); i++) {
				postOrden(n.hijo.get(i));
			}
		}

		System.out.print(n.valor + ",");
	}

	/**
	 * busca un nodo concreto en un arbol n-ario
	 * @param valor nombre del Nodo a buscar
	 * @return Nodo cuyo nombre sea el buscado, null si no lo encuentra
	 */
	public Nodo buscar(String s) {
		if (this.valor.equals(s)) {
			return this;
		} else {
			if (tieneHijos(this)) {
				for (int i = 0; i < this.hijo.size(); i++) {
					var n = this.hijo.get(i).buscar(s);
					if (n != null) {
						return n;
					}
				}
			}
		}
		return null;
	}

	/**
	 * inserta un nodo como hijo de un nodo dado
	 * @param padre nodo que será el padre del que queremos insertar
	 * @param s nombre del nodo a insertar
	 * @return Nodo insertado cuyo nombre será el pasado por parametro, null si no se puede insertar
	 */
	public Nodo insertar(Nodo padre, String s) {

		if (buscar(padre.valor) != null) {
			padre.hijo.add(new Nodo(s));
			return padre.hijo.get(padre.hijo.size() - 1);
		}

		return null;

	}

	/**
	 * busca la ruta hasta encontrar el nodo buscado
	 * @param s nombre del nodo a buscar
	 * @return String con la ruta buscada, null si no se encuentra
	 */
	public String path(String s) {

		if (this.valor.equals(s)) {
			return this.valor;
		} else {
			if (tieneHijos(this)) {
				for (int i = 0; i < this.hijo.size(); i++) {
					if (this.hijo.get(i).path(s) != null) {
						return this.valor + "/" + this.hijo.get(i).path(s);
					}
				}
			}
		}
		return null;

	}
	
	/**
	 * muestra el path de cada nodo del arbol-ario
	 */
	public void mostrarArbol() {
		ArrayList<String> lista_nodos = new ArrayList<String>();
		lista_nodos = obtenerNodos(lista_nodos, this);
		
		for (int i = 0; i < lista_nodos.size(); i++) {
			System.out.println(path(lista_nodos.get(i)));
		}
	}
	
	/**
	 * obtiene un array formado por todos los nodos del arbol n-ario
	 * @param array donde almacenar los nodos
	 * @param nodo Nodo a añadir en el array (el primero será la raiz del árbol)
	 * @return array formado por todos los nodos del array n-ario
	 */
	public ArrayList<String> obtenerNodos(ArrayList<String> array, Nodo nodo) {
		
		array.add(nodo.valor);	

		if (tieneHijos(nodo)) {
			for (int i = 0; i < nodo.hijo.size(); i++) {
				obtenerNodos(array, nodo.hijo.get(i));
			}
		}
		
		return array;
	}
	
	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}

}
