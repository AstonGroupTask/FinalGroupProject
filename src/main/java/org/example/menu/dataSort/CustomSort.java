package org.example.menu.dataSort;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomSort implements SortingStrategy<Comparable> {

	private String sortBy;

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	@Override
	public void sort(Object[] array) {
		Object[] nonNullArray = Arrays.stream(array).filter(o -> o != null).toArray();

		Arrays.sort(nonNullArray, (o1, o2) -> {
			try {
				Field field1 = o1.getClass().getDeclaredField(sortBy);
				Field field2 = o2.getClass().getDeclaredField(sortBy);
				field1.setAccessible(true);
				field2.setAccessible(true);

				Comparable value1 = (Comparable) field1.get(o1);
				Comparable value2 = (Comparable) field2.get(o2);

				if (value1 == null && value2 == null) {
					return 0;
				}
				if (value1 == null) {
					return -1;
				}
				if (value2 == null) {
					return 1;
				}

				return value1.compareTo(value2);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				throw new RuntimeException("Error accessing field: " + sortBy, e);
			}
		});

		System.arraycopy(nonNullArray, 0, array, 0, nonNullArray.length);
	}
}
