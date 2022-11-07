package models;

import java.util.Comparator;

public class ComparadorAnimales implements Comparator<Animales>{

	@Override
	/**
	 * comparamos el peso de dos animales
	 */
	public int compare(Animales o1, Animales o2) {
		return Double.valueOf(o1.getPeso()).compareTo(o2.getPeso());
	}

}
