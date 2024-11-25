package org.example;

import org.example.essence.Animal;
import org.example.essence.Barrel;
import org.example.essence.Human;
//import org.example.sorting.BubbleSort;
//import org.example.sorting.SortingUtil;
import org.example.strategies.fill.FillFromFile;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Animal.AnimalBuilder().species("ЯГУАР").eyeColor("ПЯТНИСТЫЙ").hasFur(true).build(),
                new Animal.AnimalBuilder().species("ПТИЦА").eyeColor("ГОЛУБАЯ").hasFur(true).build(),
                new Animal.AnimalBuilder().species("СОБАКА").eyeColor("БЕЛАЯ").hasFur(false).build()
        };

        Barrel[] barrels = {
                new Barrel.BarrelBuilder().volume(100).storedMaterial("водка").materialMadeOf("дерево").build(),
                new Barrel.BarrelBuilder().volume(50).storedMaterial("пиво").materialMadeOf("пластик").build()
        };

        Human[] people = {
                new Human.HumanBuilder().gender("Male").age(30).surname("Петр").build(),
                new Human.HumanBuilder().gender("Female").age(25).surname("Анна").build()
        };
        // SortingUtil.sortAndPrint(animals, new BubbleSort<>(), "Животные");
        // SortingUtil.sortAndPrint(barrels, new BubbleSort<>(), "Бочки");
        //SortingUtil.sortAndPrint(people, new BubbleSort<>(), "ЛЮДИ");

        String filePath = "C:\\Users\\citru\\IdeaProjects\\AstonGroupProject\\src\\main\\resources\\data.csv";

        FillFromFile<Object> fillStrategy = new FillFromFile<>();
        Object[] result = fillStrategy.fillFromFile(0, filePath);

        System.out.println("Animals:");
        for (Object animal : (Object[]) result[0]) {
            System.out.println(animal);
        }

        System.out.println("\nBarrels:");
        for (Object barrel : (Object[]) result[1]) {
            System.out.println(barrel);
        }

        System.out.println("\nHumans:");
        for (Object human : (Object[]) result[2]) {
            System.out.println(human);
        }
    }
}

