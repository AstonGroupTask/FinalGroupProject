package org.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriter {


    private Path path;

    public FileWriter(String pathToFile) {
        this(Path.of(pathToFile), "");
    }

    public FileWriter(Path pathToFile, String heading) {
        this.path = pathToFile;
        createFileIfNotExist(pathToFile, heading);
    }

    private void createFileIfNotExist(Path pathToFile, String heading) {
        if (!Files.exists(pathToFile)) {
            try {
                Files.createFile(path);
                Files.writeString(path, heading + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new IllegalArgumentException("Ошибка создания файла: " + pathToFile, e);
            }
        }
    }

    public void appendNewLine(String string) {
        try {
            Files.writeString(path, string + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalArgumentException("Ошибка записи в файл", e);
        }
    }

    public <T> void writeArrayToFile(T[] array) {
        for (T element : array) {
            appendNewLine(element.toString());
        }
    }
}
