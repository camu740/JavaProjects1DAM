package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import exceptions.ColaExceededSizeException;
import exceptions.ElementBlockedException;
import exceptions.LlevateTuNullDeAquiException;

public class ColaDelCastigo<T extends Animales> {

	private ArrayList<T> cola;
	private Comparator<T> comparador;

	public ColaDelCastigo(Comparator<T> comparador) {
		super();
		this.cola = new ArrayList<T>();
		this.comparador = comparador;
	}

	/**
	 * Comprobamos el tamaño del ArrayList cola
	 * 
	 * @return tamaño del ArrayList cola
	 */
	public int size() {
		return cola.size();
	}

	/**
	 * Comprobamos si el ArrayList cola está vacío
	 * 
	 * @return true si está vacío, false si hay algun elemento
	 */
	public boolean isEmpty() {
		if (cola.size() > 0) {
			return false;
		}
		return true;
	}

	/**
	 * Comprobamos si el ArrayList cola contiene un objeto dado
	 * 
	 * @param o objeto a comprobar si está dentro de la lista
	 * @return true si el objeto dado está en la lista, false si no lo está
	 */
	public boolean contains(Object o) {
		if (cola.contains(o)) {
			return true;
		}
		return false;
	}

	/**
	 * Crea un iterador de la lista
	 * @return devuelve el iterador creado
	 */
	public Iterator iterator() {
		return cola.iterator();
	}

	/**
	 * Crea un array formado por los elementos de la lista
	 * @return el array creado
	 */
	public Object[] toArray() {
		return cola.toArray();
	}

	/**
	 * añade a un array los elementos de la lista
	 * @param a array en el que serán almacenados los elementos de la lista
	 * @return el array creado
	 */
	public Object[] toArray(Object[] a) {
		return cola.toArray(a);
	}

	/**
	 * Elimina el objeto dado de la lista cola
	 * 
	 * @param o objeto a eliminar de la lista
	 * @return true si se ha encontrado y por tanto eliminado, false si ese objeto
	 *         no está en la lista
	 * @throws Exception saltará si se trata de borrar el ultimo elemento de la
	 *                   lista
	 */
	public boolean remove(Object o) throws Exception {
		if (cola.size() > 0) {
			if (cola.contains(o)) {
				cola.remove(o);
				return true;
			}
			return false;

		} else {
			throw new Exception(
					new ElementBlockedException("No puedes eliminar el ultimo elemento que queda en la cola"));
		}
	}

	/**
	 * Comprobamos si el ArrayList cola contiene una coleccion de objetos dada
	 * 
	 * @param c coleccion dada
	 * @return true si la lista contiene todos los objetos de la coleccion, false si
	 *         hay algun elemento de la coleccion que no esté en la lista
	 */
	public boolean containsAll(Collection c) {
		if (cola.containsAll(c)) {
			return true;
		}
		return false;
	}

	/**
	 * Añade una coleccion de elementos a la lista (se añade al final)
	 * 
	 * @param c coleccion a añadir
	 * @return true si ha sido añadida, false si no se ha podido añadir porque
	 *         supere el limite de 10 objetos
	 * @throws Exception si no se puede añadir a la coleccion
	 */
	public boolean addAll(Collection c) throws Exception {
		if (cola.size() + c.size() < 10) {
			if (cola.addAll(c)) {
				cola.sort(comparador);
				return true;
			} else {
				return false;
			}
		} else {
			throw new Exception(new ColaExceededSizeException(
					"No puedes añadir esta coleccion porque la cola superaría los diez elementos"));
		}
	}

	/**
	 * Elimina de la lista todos los objetos de la coleccion dada
	 * 
	 * @param c Coleccion dada
	 * @return true si elimina la coleccion, false si no puede eliminarla
	 * @throws Exception si la lista quedaría vacía tras eliminar los elementos de
	 *                   la coleccion
	 */
	public boolean removeAll(Collection c) throws Exception {
		if (cola.size() > c.size()) {
			if (cola.removeAll(c)) {
				return true;

			} else {
				return true;
			}
		} else {
			throw new Exception(new ElementBlockedException("No se puede dejar la cola vacía"));
		}
	}

	/**
	 * Elimina de la lista todos los objetos que no estén en la coleccion dada
	 * 
	 * @param c Coleccion dada
	 * @return true si elimina los objetos que no están en la coleccion, false si no
	 *         puede eliminarlos
	 * @throws Exception si la lista quedaría vacía tras eliminar los elementos que
	 *                   no están en la coleccion
	 */
	public boolean retainAll(Collection c) throws Exception {
		if (cola.retainAll(c))
			if (cola.size() > 0)
				return true;
			else
				throw new Exception(new ElementBlockedException("No se puede dejar la cola vacía"));
		else
			return false;
	}

	/**
	 * Trata de vaciar la lista pero no podemos dejar la cola vacia por lo que
	 * salatará una excepcion
	 * 
	 * @throws Exception no puede vaciarse la cola
	 */
	public void clear() throws Exception {
		throw new Exception(new ElementBlockedException("No se puede dejar la cola vacía"));
	}

	/**
	 * Añade un objeto dado al final de la cola
	 * @param e objeto a introducir
	 * @return true si ha podido añadirlo, false si no.
	 * @throws Exception si tratas de añadir un objeto null o si la cola ya está
	 *                   llena
	 */
	public boolean add(T e) throws Exception {
		if (!e.equals(null)) {
			if (cola.size() < 10) {
				if (cola.add(e)) {
					cola.sort(comparador);
					return true;
				}
				return false;
			} else {
				throw new Exception(new ColaExceededSizeException(
						"No puedes añadir esta coleccion porque la cola superaría los diez elementos"));
			}
		} else {
			throw new Exception(new LlevateTuNullDeAquiException("No puede añadir un elemento null a la lista"));
		}
	}

	/**
	 * Añade un objeto dado al final de la cola
	 * @param e objeto a introducir
	 * @return true si ha podido añadirlo, false si no.
	 */
	public boolean offer(T e) {
		if (cola.size() < 10) {
			if (cola.add(e)) {
				cola.sort(comparador);
				return true;
			}
			return false;
		} 
		return false;
	}

	/**
	 * elimina el ultimo elemento de la lista
	 * 
	 * @return el objeto eliminado
	 * @throws Exception si solo queda un elemento en la lista y no se puede
	 *                   eliminar
	 */
	public Object remove() throws Exception {
		if (cola.size() > 1) {
			return cola.remove(cola.size() - 1);
		} else {
			throw new Exception(new ElementBlockedException("No se puede dejar la cola vacía"));
		}
	}

	/**
	 * elimina el primer elemento de la lista
	 * 
	 * @return el objeto eliminado
	 * @throws Exception si solo queda un elemento en la lista y no se puede
	 *                   eliminar
	 */
	public Object poll() throws Exception {
		if (cola.size() > 1) {
			return cola.remove(0);
		} else {
			throw new Exception(new ElementBlockedException("No se puede dejar la cola vacía"));
		}
	}

	/**
	 * obtiene el primer elemento de la lista
	 * 
	 * @return primer elemento de la lista
	 * @throws Exception si la lista está vacía
	 */
	public Object element() throws Exception {
		if (cola.isEmpty()) {
			throw new Exception(new ElementBlockedException("la cola está vacía"));
		} else {
			return cola.get(0);
		}
	}

	/**
	 * obtiene el primer elemento de la lista
	 * 
	 * @return primer elemento de la lista o null si la lista está vacía
	 */
	public Object peek() {
		if (cola.isEmpty()) {
			return null;
		} else {
			return cola.get(0);
		}
	}
}
