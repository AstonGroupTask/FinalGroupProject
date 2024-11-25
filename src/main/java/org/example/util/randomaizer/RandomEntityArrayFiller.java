package org.example.util.randomaizer;

public class RandomEntityArrayFiller {
    public static Object[] fillArray(String typeOfEntity, int arraySize) {
        Object[] array = new Object[arraySize];
        switch (typeOfEntity) {
	        case ("Animal"):
	            for (int i = 0; i < arraySize; i++) {
	                array[i] = RandomEntityGenerator.randomAnimalGenerate();
	            }
	            break;
	        case ("Barrel"):
	            for (int i = 0; i < arraySize; i++) {
	                array[i] = RandomEntityGenerator.randomBarrelGenerate();
	            }
	            break;
            case ("Human"):
                for (int i = 0; i < arraySize; i++) {
                    array[i] = RandomEntityGenerator.randomHumanGenerate();
                }
                break;
            default:
        }
        return array;
    }
}
