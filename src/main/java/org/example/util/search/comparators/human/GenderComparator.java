package org.example.util.search.comparators.human;

import java.util.Comparator;

import org.example.essence.Human;

public class GenderComparator<H extends Human> implements Comparator<H> {
	
	public int compare(H h1, H h2) {
		return h1.getFirstParam().compareTo(h2.getFirstParam());
	}
}
