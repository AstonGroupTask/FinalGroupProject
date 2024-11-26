package org.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class FileWriter {

    private FileWriter() {

    }

    private static void createFileIfNotExist(Path pathToFile, String heading) {
        if (!Files.exists(pathToFile)) {
            try {
                Files.createFile(pathToFile);
                Files.writeString(pathToFile, heading + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new IllegalArgumentException("Ошибка создания файла: " + pathToFile, e);
            }
        }
    }

    public static void appendNewLine(String pathToFile, String string) {
        Path path = Path.of(pathToFile);
        createFileIfNotExist(path, "");
        try {
            Files.writeString(path, string + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalArgumentException("Ошибка записи в файл: " + pathToFile, e);
        }
    }

    public static <T> void writeArrayToFile(String pathToFile, T[] array) {
        Path path = Path.of(pathToFile);
        createFileIfNotExist(path, "");
        for (T element : array) {
            appendNewLine(pathToFile, element.toString());
        }
    }
}

