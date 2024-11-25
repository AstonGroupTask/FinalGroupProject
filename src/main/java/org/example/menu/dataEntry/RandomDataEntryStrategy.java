package org.example.menu.dataEntry;

import org.example.util.randomaizer.RandomEntityGenerator;
import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.ScannerValidate;
import org.example.util.validate.TypeValidation;

public class RandomDataEntryStrategy implements DataEntryStrategy {
    @Override
    public void execute(SingletoneArray array, ScannerValidate scannerValidate) {
        System.out.println("Random data entry mode");

        int validVariant = 0;
        int numberOfEntities = 0;

        System.out.println("Please, select type of entity:");
        System.out.println(" 1 - Animal");
        System.out.println(" 2 - Barrel");
        System.out.println(" 3 - Human");
        System.out.println(" 4 - Exit");
        
        System.out.print("Please, enter your chosen action: ");
        validVariant = (int) scannerValidate.getValidValue(TypeValidation.VARIANTS_4);

        if (validVariant == 4) {
            System.out.println("Returning to data input menu.");
            return;
        }

        System.out.print("Please, enter the number of entities to add: ");
        numberOfEntities = (int) scannerValidate.getValidValue(TypeValidation.INT);

        switch (validVariant) {
            case 1:
                for (int i = 0; i < numberOfEntities; i++)
                    array.add(RandomEntityGenerator.randomAnimalGenerate());
                break;
            case 2:
                for (int i = 0; i < numberOfEntities; i++)
                    array.add(RandomEntityGenerator.randomBarrelGenerate());
                break;
            case 3:
                for (int i = 0; i < numberOfEntities; i++)
                    array.add(RandomEntityGenerator.randomHumanGenerate());
                break;
            default:
                break;
        }
        System.out.println("Addition complete");
    }
}