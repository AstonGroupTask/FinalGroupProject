package org.example.strategies.fill;
import org.example.essence.Animal;
import org.example.essence.Barrel;
import org.example.essence.Human;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FillFromFile implements FillsStrategy {

    private String filePath;

    public FillFromFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Comparable<?>[] fill() {
        List<Comparable<?>> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            br.lines().forEach(line -> {
                result.add(parseLine(line));
            });
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return result.toArray(new Comparable<?>[0]);
    }

    public Comparable<?> parseLine(String string){
        String[] fields = string.split(",", -1);
        if (fields.length < 1 || fields[0].isEmpty()) {
            throw new IllegalArgumentException("Попытка интерпретировать строку некорректного формата. Строка:\n" + string);
        }

        return switch (fields[0]) {
            case "Animal" -> new Animal.AnimalBuilder()
                    .species(fields[1])
                    .eyeColor(fields[2])
                    .hasFur(Boolean.parseBoolean(fields[3]))
                    .build();

            case "Barrel" -> new Barrel.BarrelBuilder()
                    .volume(Double.parseDouble(fields[1]))
                    .storedMaterial(fields[2])
                    .materialMadeOf(fields[3])
                    .build();

            case "Human" -> new Human.HumanBuilder()
                    .gender(fields[1])
                    .age(Integer.parseInt(fields[2]))
                    .surname(fields[3])
                    .build();
            default -> throw new IllegalArgumentException("Неверный тип");
        };
    }
}