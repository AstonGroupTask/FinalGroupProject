package org.example.strategies.fill;
import org.example.essence.Animal;
import org.example.essence.Barrel;
import org.example.essence.Human;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FillFromFile<T> implements FillsStrategy<T> {

    @Override
    public T[] fill(int size) {
        throw new UnsupportedOperationException("Метод fill не поддерживается для этой стратегии");
    }

    @Override
    public Object[] fillFromFile(int size, String filePath) {
        List<Animal> animals = new ArrayList<>();
        List<Barrel> barrels = new ArrayList<>();
        List<Human> humans = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            br.lines().forEach(line -> {
                String[] fields = line.split(",", -1);
                if (fields.length < 1 || fields[0].isEmpty()) {
                    System.err.println("Пропущена пустая или некорректная строка: " + line);
                    return;
                }

                switch (fields[0]) {
                    case "Animal" -> parseAnimal(fields, animals, line);
                    case "Barrel" -> parseBarrel(fields, barrels, line);
                    case "Human" -> parseHuman(fields, humans, line);
                    default -> System.err.println("Неизвестный тип объекта: " + fields[0]);
                }
            });
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return new Object[]{
                animals.toArray(new Animal[0]),
                barrels.toArray(new Barrel[0]),
                humans.toArray(new Human[0])
        };
    }

    private void parseAnimal(String[] fields, List<Animal> animals, String line) {
        if (fields.length >= 4) {
            try {
                animals.add(new Animal.AnimalBuilder()
                        .species(fields[1])
                        .eyeColor(fields[2])
                        .hasFur(Boolean.parseBoolean(fields[3]))
                        .build());
            } catch (Exception e) {
                System.err.println("Ошибка при создании Animal: " + line);
            }
        } else {
            System.err.println("Недостаточно данных для Animal: " + line);
        }
    }

    private void parseBarrel(String[] fields, List<Barrel> barrels, String line) {
        if (fields.length >= 4) {
            try {
                barrels.add(new Barrel.BarrelBuilder()
                        .volume(Double.parseDouble(fields[1]))
                        .storedMaterial(fields[2])
                        .materialMadeOf(fields[3])
                        .build());
            } catch (NumberFormatException e) {
                System.err.println("Ошибка преобразования числа в Barrel: " + line);
            }
        } else {
            System.err.println("Недостаточно данных для Barrel: " + line);
        }
    }

    private void parseHuman(String[] fields, List<Human> humans, String line) {
        if (fields.length >= 4) {
            try {
                humans.add(new Human.HumanBuilder()
                        .gender(fields[1])
                        .age(Integer.parseInt(fields[2]))
                        .surname(fields[3])
                        .build());
            } catch (NumberFormatException e) {
                System.err.println("Ошибка преобразования числа в Human: " + line);
            }
        } else {
            System.err.println("Недостаточно данных для Human: " + line);
        }
    }
}