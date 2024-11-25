package org.example.util.search;

import java.util.Arrays;
import java.util.Comparator;

import org.example.essence.Animal;
import org.example.util.search.comparators.animal.*;

/**
 * <p>Поиск с использованием generics</p>
 */
public final class BinarySearchGeneric <E extends Comparable<E>, C extends Comparator<E>> {
	
	/**
	 * <p>Ищет точное совпадение</p>
	 * <p>Требует уже отсортированную коллекцию</p>
	 * <p>Сортировку проводить с тем же компаратором, что и поиск</p>
	 * @param collection коллекция
	 * @param collectionSize количество элементов
	 * @param searchTarget поисковый запрос
	 * @param c компаратор, через него указывается, какой параметр искать
	 * @return индекс, по которому найден объект либо -1
	 */

	public static <E> int binarySearch(E[] collection, E searchTarget, Comparator<? super E> c) {
		int leftSearchBound = 0;
		int rightSearchBound = collection.length - 1;  

		while (leftSearchBound <= rightSearchBound) {
			int middleIndex = (int)Math.floor((leftSearchBound + rightSearchBound) / 2);
			E middleValue = collection[middleIndex];
			int comparison = c.compare(searchTarget, middleValue);

			if (comparison > 0) {
				leftSearchBound = middleIndex + 1;
			} else if (comparison < 0) {
				rightSearchBound = middleIndex - 1;
			} else {
				return middleIndex;
			}
		}

		System.out.println("Не найдено");
		return -1;
	}

	// Тест поиска
	public static void main(String[] args) {
		Animal[] animals = {
			new Animal.AnimalBuilder().species("СЛОН").eyeColor("КАРИЙ").hasFur(false).build(),
			new Animal.AnimalBuilder().species("ЖИРАФ").eyeColor("КРАСНЫЙ").hasFur(true).build(),
			new Animal.AnimalBuilder().species("ЛЕВ").eyeColor("ЗЕЛЁНЫЙ").hasFur(true).build(),
			new Animal.AnimalBuilder().species("ШИМПАНЗЕ").eyeColor("СИНИЙ").hasFur(true).build()
		};
		
		Animal animalToSearch = new Animal.AnimalBuilder().species("ЖИРАФ").eyeColor("СИНИЙ").hasFur(true).build();

		EyeColorComparator<Animal> comp = new EyeColorComparator<Animal>();

		System.out.println("Unsorted animals");

		for (int i = 0; i < animals.length; i++) {
			System.out.println(animals[i].toString());
		}

		Arrays.sort(animals, comp);

		System.out.println("Sorted animals");

		for (int i = 0; i < animals.length; i++) {
			System.out.println(animals[i].toString());
		}

		int indexFound = BinarySearchGeneric.binarySearch(animals, animalToSearch, comp);
		System.out.println("Найдено в индексе: " + indexFound);
	}
}