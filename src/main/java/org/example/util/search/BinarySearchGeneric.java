package org.example.util.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.example.essence.Animal;
import org.example.util.RandomStringGenerator;

/**
 * <p>Поиск с использованием generics</p>
 */
public final class BinarySearchGeneric {
	
	/**
	 * <p>Ищет точное совпадение</p>
	 * <p>Требует уже отсортированную коллекцию</p>
	 * @param collection коллекция
	 * @param collectionSize количество элементов
	 * @param searchTarget поисковый запрос
	 * @return найденая строка либо null
	 */
	public static <E extends Comparable<E>> int binarySearch(E[] collection, Integer collectionSize, E searchTarget) {
		int leftSearchBound = 0;
		int rightSearchBound = collectionSize - 1;

		while (leftSearchBound <= rightSearchBound) {
			int middleIndex = (int)Math.floor((leftSearchBound + rightSearchBound) / 2);
			E middleValue = collection[middleIndex];
			int comparison = searchTarget.compareTo(middleValue);

			if (comparison > 0) {
				leftSearchBound = middleIndex + 1;
			} else if (comparison < 0) {
				rightSearchBound = middleIndex - 1;
			} else {
				return middleIndex;
			}
		}

		return -1;
	}

	/**
	 * <p>Для теста поиска</p>
	 * <p>Заполняет коллекцию рандомными строками</p>
	 * @param collection коллекция
	 * @param size количество элементов в коллекции
	 */
	public static void populateCollection(ArrayList<String> collection, int size) {
		Random rng = new Random();

		for (int i = 0; i < size; i++) {
			collection.add(RandomStringGenerator.generateNewString(rng.nextInt(3, 11)));
		}
	}

	// Тест поиска
	public static void main(String[] args) {
		Animal[] animals = {
			new Animal.AnimalBuilder().species("СЛОН").eyeColor("КАРИЙ").hasFur(false).build(),
			new Animal.AnimalBuilder().species("ЖИРАФ").eyeColor("КРАСНЫЙ").hasFur(true).build(),
			new Animal.AnimalBuilder().species("ЛЕВ").eyeColor("ЗЕЛЁНЫЙ").hasFur(true).build()
		};

		Arrays.sort(animals);
		
		Animal animalToSearch = new Animal.AnimalBuilder().species("ЖИРАФ").eyeColor("КРАСНЫЙ").hasFur(true).build();

		int indexFound = binarySearch(animals, animals.length, animalToSearch);
		System.out.println(indexFound);
	}
}