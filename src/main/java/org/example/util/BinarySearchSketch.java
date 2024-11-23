package org.example.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>Базовый поиск, с заполнением коллекции для проверки работы алгоритма</p>
 */
public final class BinarySearchSketch {

	private ArrayList<String> collection = new ArrayList<String>();

	/**
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

	/**
	 * <p>Ищет точное совпадение</p>
	 * <p>Требует уже отсортированную коллекцию</p>
	 * @param collection коллекция
	 * @param collectionSize количество элементов
	 * @param targetString поисковый запрос
	 * @return найденая строка либо "Не найдено"
	 */
	public static String binarySearch(ArrayList<String> collection, int collectionSize, String targetString) {
		int left = 0;
		int right = collectionSize - 1;

		while (left <= right) {
			int middle = (int)Math.floor((left + right) / 2);

			if (collection.get(middle).compareTo(targetString) < 0) {
				left = middle + 1;
			} else if (collection.get(middle).compareTo(targetString) > 0) {
				right = middle - 1;
			} else {
				return collection.get(middle);
			}
		}

		return "Не найдено";
	}

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();

		BinarySearchSketch.populateCollection(names, 100);

		names.sort(null);

		System.out.println(names);

		String foundName = BinarySearchSketch.binarySearch(names, names.size(), "str");

		System.out.println(foundName);
	}
}