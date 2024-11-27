package org.example.util.search;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

import org.example.essence.Animal;

/**
 * <p>
 * Поиск с использованием generics
 * </p>
 */
public final class BinarySearchGeneric<E extends Comparable<E>, T extends Comparable<T>> {

	/**
	 * <p>
	 * Ищет точное совпадение
	 * </p>
	 * <p>
	 * Требует уже отсортированный массив
	 * </p>
	 * 
	 * @param collection    массив
	 * @param fieldToSearch название параметра, по которому искать
	 * @param searchParam   поисковый запрос
	 * @return индекс в массиве, по которому найден объект либо -1, если объект не
	 *         найден
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <E, T> int binarySearch(E[] collection, String fieldToSearch, T searchParam) {
		int leftSearchBound = 0;
		int rightSearchBound = collection.length - 1;

		String searchParamStr = String.valueOf(searchParam);

		while (leftSearchBound <= rightSearchBound) {
			int middleIndex = (leftSearchBound + rightSearchBound) / 2;
			E middleValue = collection[middleIndex];
			int comparison = 0;

			try {
				Field field = middleValue.getClass().getDeclaredField(fieldToSearch);
				field.setAccessible(true);
				String fieldValueStr = String.valueOf(field.get(middleValue));
				comparison = fieldValueStr.compareTo(searchParamStr);
			} catch (NoSuchFieldException e) {
				System.out.println("Ошибка! У класса отсутствует поле " + fieldToSearch + " .");
				e.printStackTrace();
			} catch (SecurityException e) {
				System.out.println("Ошибка! Ошибка доступа к полю " + fieldToSearch + " .");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println("Ошибка! Объект " + middleValue.toString() + " не является экземпляром класса "
						+ middleValue.getClass().toString() + " .");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("Ошибка! Поле в классе " + middleValue.getClass().toString() + " недоступно.");
				e.printStackTrace();
			}

			if (comparison < 0) {
				leftSearchBound = middleIndex + 1;
			} else if (comparison > 0) {
				rightSearchBound = middleIndex - 1;
			} else {
				return middleIndex;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Animal[] animals = { new Animal.AnimalBuilder().species("СЛОН").eyeColor("КАРИЙ").hasFur(false).build(),
				new Animal.AnimalBuilder().species("ЖИРАФ").eyeColor("КРАСНЫЙ").hasFur(true).build(),
				new Animal.AnimalBuilder().species("ЛЕВ").eyeColor("ЗЕЛЁНЫЙ").hasFur(true).build(),
				new Animal.AnimalBuilder().species("ШИМПАНЗЕ").eyeColor("СИНИЙ").hasFur(true).build() };

		Arrays.sort(animals, Comparator.comparing(Animal::getSpecies));

		int locatedAtIndex = BinarySearchGeneric.binarySearch(animals, "species", "ЛЕВ");

		if (locatedAtIndex == -1) {
			System.out.println("Запрос не найден");
		} else {
			System.out.println("Найдено");
			System.out.println(animals[locatedAtIndex]);
		}
	}
}
