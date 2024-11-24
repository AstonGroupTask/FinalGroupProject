package org.example.sorting;

import org.example.essence.Animal;
import org.example.essence.Barrel;
import org.example.essence.Human;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSort<T extends Comparable<T>> implements SortStrategy<T> {

    private final String sortBy;

    public CustomSort(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public void sort(T[] array) {
        if (array.length == 0) return;

        // Проверяем, какой тип объекта и сортируем в зависимости от типа и параметра сортировки
        if (array[0] instanceof Animal) {
            sortAnimals((Animal[]) array);
        } else if (array[0] instanceof Barrel) {
            sortBarrels((Barrel[]) array);
        } else if (array[0] instanceof Human) {
            sortHumans((Human[]) array);
        } else {
            throw new IllegalArgumentException("Такого поля нет");
        }
    }

    private void sortAnimals(Animal[] array) {
        switch (sortBy) {
            case "species":
                Arrays.sort(array, Comparator.comparing(Animal::getSpecies));
                break;
            case "eyeColor":
                Arrays.sort(array, Comparator.comparing(Animal::getEyeColor));
                break;
            case "hasFur":
                Arrays.sort(array, Comparator.comparing(Animal::isHasFur));
                break;
            default:
                throw new IllegalArgumentException("Такого поля нет");
        }
    }

    private void sortBarrels(Barrel[] array) {
        switch (sortBy) {
            case "volume":
                Arrays.sort(array, Comparator.comparingDouble(Barrel::getVolume));
                break;
            case "storedMaterial":
                Arrays.sort(array, Comparator.comparing(Barrel::getStoredMaterial));
                break;
            case "materialMadeOf":
                Arrays.sort(array, Comparator.comparing(Barrel::getMaterialMadeOf));
                break;
            default:
                throw new IllegalArgumentException("Такого поля нет");
        }
    }

    private void sortHumans(Human[] array) {
        switch (sortBy) {
            case "age":
                Arrays.sort(array, Comparator.comparingInt(Human::getAge));
                break;
            case "gender":
                Arrays.sort(array, Comparator.comparing(Human::getGender));
                break;
            case "surname":
                Arrays.sort(array, Comparator.comparing(Human::getSurname));
                break;
            default:
                throw new IllegalArgumentException("Такого поля нет");
        }
    }
}