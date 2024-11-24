package org.example.util;

import java.util.Random;

/**
 * <p>Генератор рандомных строк</p>
 * <p>Вдруг пригодится</p>
 */
public final class RandomStringGenerator {

	/**
	 * Генерирует новую строку с заданным количеством символов
	 * @param length количество символов в новой строке
	 * @return готовая строка
	 */
	public static String generateNewString(int length) {
		Random rng = new Random();
		String str = "";
		
		for (int i = 0; i < length; i++) {
			str += (char)rng.nextInt(97, 123);
		}

		str.substring(0, 1).toUpperCase();

		return str;
	}
}