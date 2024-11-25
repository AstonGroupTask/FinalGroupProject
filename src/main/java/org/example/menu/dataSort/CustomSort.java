package org.example.menu.dataSort;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CustomSort implements SortingStrategy<Comparable> {

	private String sortBy;

	public void setSortBy(String SortBy) {
		sortBy = SortBy;
	}

	@Override
	public void sort(Object[] array) {
		Arrays.sort(array, (o1, o2) -> {
			try {
				Field field1 = o1.getClass().getDeclaredField(sortBy);
				Field field2 = o2.getClass().getDeclaredField(sortBy);
				field1.setAccessible(true);
				field2.setAccessible(true);

				Comparable value1 = (Comparable) field1.get(o1);
				Comparable value2 = (Comparable) field2.get(o2);

				return value1.compareTo(value2);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				throw new RuntimeException("Error accessing field: " + sortBy, e);
			}
		});
	}
}
