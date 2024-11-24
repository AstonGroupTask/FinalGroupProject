package org.example.util.randomaizer;

public class RandomEntityArrayFiller {
    public static Object[] fillArray(String numberOfEssence, int arraySize) {
        Object[] array = new Object[arraySize];
        switch (numberOfEssence) {
            case ("1"):
                for (int i = 0; i < arraySize; i++) {
                    array[i] = RandomEntityGenerator.randomHumanGenerate();
                }
                break;
            case ("2"):
                for (int i = 0; i < arraySize; i++) {
                    array[i] = RandomEntityGenerator.randomAnimalGenerate();
                }
                break;
            case ("3"):
                for (int i = 0; i < arraySize; i++) {
                    array[i] = RandomEntityGenerator.randomBarrelGenerate();
                }
                break;
            case ("q"):
                for (int i = 0; i < arraySize; i++) {
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Нет указанного варианта! Попробуйте снова: ");
                fillArray(numberOfEssence, arraySize);
                break;
        }
        return array;
    }
}
