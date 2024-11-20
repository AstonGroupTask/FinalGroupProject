package org.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileWriterTest {
    private FileWriter fileWriter;
    private final String testFilePath = "testFile.txt";


    @BeforeEach
    public void setUp() {
        fileWriter = new FileWriter(testFilePath);
    }

    @Test
    public void testFileCreation() {
        assertTrue(Files.exists(Paths.get(testFilePath)));
    }

    @Test
    public void testCreateFileWhichNotExist() {
        String path = "C:\\Users\\citru\\IdeaProjects\\AstonGroupProject\\src\\main\\java\\org\\example\\util\\TestFile";
        Path pathToFile = Path.of(path);
        if (Files.exists(pathToFile)) {
            try {
                Files.delete(pathToFile);
                System.out.println("Файл уже был создан со страрыми значениями - удален");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter fileWriter2 = new FileWriter(path);
        assertTrue(Files.exists(pathToFile));
        System.out.println("Файл создан");
    }

}
