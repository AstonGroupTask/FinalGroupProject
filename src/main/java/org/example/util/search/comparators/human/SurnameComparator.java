package org.example.util.search.comparators.human;

import java.util.Comparator;

import org.example.essence.Human;

public class SurnameComparator<H extends Human> implements Comparator<H> {
	
	public int compare(H h1, H h2) {
		return h1.getThirdParam().compareTo(h2.getThirdParam());
	}
}