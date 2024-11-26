package org.example.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class FileWriter {

	private void createFileIfNotExist(Path pathToFile, String heading) {
		if (!Files.exists(pathToFile)) {
			try {
				Files.createFile(pathToFile);
				Files.writeString(pathToFile, heading + "\n", StandardOpenOption.APPEND);
			} catch (IOException e) {
				throw new IllegalArgumentException("Ошибка создания файла: " + pathToFile, e);
			}
		}
	}

	public void appendNewLine(String pathToFile, String string) {
		Path path = Path.of(pathToFile);
		createFileIfNotExist(path, "");
		try {
			Files.writeString(path, string + "\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new IllegalArgumentException("Ошибка записи в файл: " + pathToFile, e);
		}
	}

	public <T> void writeArrayToFile(String pathToFile, T[] array) {
		Path path = Path.of(pathToFile);
		createFileIfNotExist(path, "");

		if (array.length > 0) {
			appendNewLine(pathToFile, getClassFieldsAsHeaders(array[0]));
		}

		for (T element : array) {
			appendNewLine(pathToFile, getClassFieldsAsString(element));
		}
	}

	private <T> String getClassFieldsAsHeaders(T element) {
		StringBuilder result = new StringBuilder("type");

		Field[] fields = element.getClass().getDeclaredFields();
		for (Field field : fields) {
			result.append(",").append(field.getName());
		}

		return result.toString();
	}

	private <T> String getClassFieldsAsString(T element) {
		StringBuilder result = new StringBuilder(element.getClass().getSimpleName());
		result.append(",");

		Field[] fields = element.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object value = field.get(element);
				result.append(value).append(",");
			} catch (IllegalAccessException e) {
				result.append("ERROR,");
			}
		}

		if (result.length() > 0 && result.charAt(result.length() - 1) == ',') {
			result.setLength(result.length() - 1);
		}

		return result.toString();
	}
}
