package org.example.util.search;

import java.util.Comparator;

import org.example.essence.Animal;

/**
 * Не работает
 */
public class AnimalComparator<A extends Animal> implements Comparator<A> {
	
	public int compare(A a1, A a2) {
		return a1.compareTo(a2);
	}
	
	public int compareFirstParam(A a1, A a2) {
		return a1.getFirstParam().compareTo(a2.getFirstParam());
	}

	public int compareSecondParam(A a1, A a2) {
		return a1.getSecondParam().compareTo(a2.getSecondParam());
	}

	public int compareThirdParam(A a1, A a2) {
		return a1.getThirdParam().compareTo(a2.getThirdParam());
	}
}
