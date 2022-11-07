package models;

public class Arbol {
	private Nodo raiz;

	//Builders
	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}
	
	//Methods
	
	/**
	 * muestra el arbol n-ario en forma preOrden
	 */
	public void preOrden() {
		this.raiz.preOrden(raiz);
	}
	
	/**
	 * muestra el arbol n-ario en forma postOrden
	 */
	public void postOrden() {
		this.raiz.postOrden(raiz);
	}
	
	/**
	 * busca un nodo concreto en un arbol n-ario
	 * @param valor nombre del Nodo a buscar
	 * @return Nodo cuyo nombre sea el buscado, null si no lo encuentra
	 */
	public Nodo buscarNodo(String valor) {
		return this.raiz.buscar(valor);
	}
	
	/**
	 * inserta un nodo en un arbol n-ario
	 * @param padre nodo que será el padre del que queremos insertar
	 * @param s nombre del nodo a insertar
	 * @return Nodo insertado cuyo nombre será el pasado por parametro, null si no se puede insertar
	 */
	public Nodo insertarNodo(Nodo padre, String s) {
	return this.raiz.insertar(padre, s);
	}
	
	/**
	 * busca la ruta hasta encontrar el nodo buscado en un arbol n-ario
	 * @param s nombre del nodo a buscar
	 * @return String con la ruta buscada, null si no se encuentra
	 */
	public String path(String s) {
		return this.raiz.path(s);
	}
	
	/**
	 * muestra el path de cada nodo del arbol n-ario
	 */
	public void mostrarArbol() {
		this.raiz.mostrarArbol();
	}
}
