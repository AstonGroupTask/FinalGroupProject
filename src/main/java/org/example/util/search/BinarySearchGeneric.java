package org.example.util.search;

import java.util.ArrayList;

/**
 * <p>Поиск с использованием generics</p>
 */
public final class BinarySearchGeneric <E> {
	
	/**
	 * <p>Ищет точное совпадение</p>
	 * <p>Требует уже отсортированную коллекцию</p>
	 * @param collection коллекция
	 * @param collectionSize количество элементов
	 * @param searchTarget поисковый запрос
	 * @return найденая строка либо null
	 */
	public static <E> E binarySearch(ArrayList<E> collection, Integer collectionSize, E searchTarget) {
		int leftSearchBound = 0;
		int rightSearchBound = collectionSize - 1;

		while (leftSearchBound <= rightSearchBound) {
			int middleIndex = (int)Math.floor((leftSearchBound + rightSearchBound) / 2);

			if (collection.get(middleIndex).compareTo(searchTarget) < 0) {
				leftSearchBound = middleIndex + 1;
			} else if (collection.get(middleIndex).compareTo(searchTarget) > 0) {
				rightSearchBound = middleIndex - 1;
			} else {
				return collection.get(middleIndex);
			}
		}

		return null;
	}
}