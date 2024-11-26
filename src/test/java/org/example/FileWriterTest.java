package org.example;

import org.example.util.FileWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileWriterTest {

    private final String testFilePath = "testFile.txt";


    @BeforeEach
    public void setUp() throws IOException {
        Path path = Paths.get(testFilePath);
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }

    @Test
    public void testFileCreation() {
        FileWriter.appendNewLine(testFilePath, "Test line");
        assertTrue(Files.exists(Paths.get(testFilePath)));
    }

    @Test
    public void testCreateFileWhichNotExist() {
        String path = "C:\\Users\\citru\\IdeaProjects\\AstonGroupProject\\src\\main\\java\\org\\example\\util\\TestFile.txt";
        Path pathToFile = Path.of(path);

        if (Files.exists(pathToFile)) {
            try {
                Files.delete(pathToFile);
                System.out.println("Файл уже был создан со старыми значениями — удалён");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FileWriter.appendNewLine(path, "Тест файла");
        assertTrue(Files.exists(pathToFile));
        System.out.println("Файл создан");
    }
}