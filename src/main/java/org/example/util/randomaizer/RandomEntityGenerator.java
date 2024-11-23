package org.example.util.randomaizer;

import org.example.essence.Animal;
import org.example.essence.Barrel;
import org.example.essence.Human;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.*;

public class RandomEntityGenerator {

    private static final Map<String, List<String>> namesByGender = new HashMap<>() {{
        put("Мужчина", List.of(
                "Петров",
                "Иванов",
                "Сидоров",
                "Гаврилов",
                "Семёнов",
                "Гучёк",
                "Назар")
        );
        put("Женщина", List.of(
                "Петрова",
                "Иванова",
                "Сидорова",
                "Гаврилова",
                "Гучёк",
                "Назар")
        );
    }};
    private static final Map<Boolean, List<String>> speciesByHasFur = new HashMap<>() {{
        put(Boolean.TRUE, List.of(
                "Млекопитающее",
                "Птица")
        );
        put(Boolean.FALSE, List.of(
                "Рептилия",
                "Амфибия",
                "Рыба",
                "Безпозвоночное")
        );
    }};
    private static final Map<String, List<String>> storedProductByBarrelMaterial = new HashMap<>() {{
        put("Пластиковая бочка", List.of(
                "Химический продукт",
                "Молоко",
                "Сироп",
                "Спирт")
        );
        put("Деревянная бочка", List.of(
                "Вино",
                "Коньяк",
                "Виски")
        );
        put("Железная бочка", List.of(
                "Спирт",
                "Химический продукт",
                "Нефтепродукт")
        );
    }};
    private static final List<String> eyeColorList = List.of(
            "Коричневый",
            "Зеленый",
            "Голубой",
            "Красный",
            "Белый",
            "Черный",
            "Оранжевый",
            "Синий",
            "Фиолетовый"
    );

    public static Human randomHumanGenerate() {

        var random = new SecureRandom();
        String randomGender = (new ArrayList<>(namesByGender.keySet())).get(random.nextInt(namesByGender.size()));
        List<String> surnames = namesByGender.get(randomGender);
        String randomSurname = surnames.get(random.nextInt(surnames.size()));
        int randomAge = (int) (Math.random() * 101);

        return new Human.HumanBuilder().
                gender(randomGender)
                .age(randomAge)
                .surname(randomSurname)
                .build();
    }

    public static Animal randomAnimalGenerate() {
        var random = new SecureRandom();
        boolean randomFur = new Random().nextBoolean();
        List<String> randomSpeciesList = speciesByHasFur.get(randomFur);
        String randomSpecies = randomSpeciesList.get(random.nextInt(randomSpeciesList.size()));
        String randomEyeColor = eyeColorList.get(random.nextInt(eyeColorList.size()));

        return new Animal.AnimalBuilder()
                .species(randomSpecies)
                .eyeColor(randomEyeColor)
                .hasFur(randomFur)
                .build();
    }

    public static Barrel randomBarrelGenerate() {

        var random = new SecureRandom();
        String randomBarrelMaterial = (new ArrayList<>(storedProductByBarrelMaterial.keySet()))
                .get(random.nextInt(storedProductByBarrelMaterial.size()));
        List<String> storedProductList = storedProductByBarrelMaterial.get(randomBarrelMaterial);
        String randomStoredProduct = storedProductList.get(random.nextInt(storedProductList.size()));
        DecimalFormat df = new DecimalFormat("#.##");
        double randomVolume = Double.parseDouble(df.format(Math.random() * 1000.1));

        return new Barrel.BarrelBuilder()
                .volume(randomVolume)
                .storedMaterial(randomStoredProduct)
                .materialMadeOf(randomBarrelMaterial)
                .build();
    }

}

