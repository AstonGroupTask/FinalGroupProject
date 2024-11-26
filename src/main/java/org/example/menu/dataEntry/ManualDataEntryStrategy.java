package org.example.menu.dataEntry;

import org.example.essence.Animal;
import org.example.essence.Barrel;
import org.example.essence.Human;
import org.example.util.validate.ScannerValidate;
import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.TypeValidation;

public class ManualDataEntryStrategy implements DataEntryStrategy {
	@Override
	public void execute(SingletoneArray array, ScannerValidate scannerValidate) {
		System.out.println("Manual data entry mode");

		if (array.isEmpty()) {
			selectEntityType(scannerValidate, array);
		} else {
			System.out.println("The type of existing entity is: " + array.getStoredTypeSimple());
			
			Object firstElement = array.get(0);
			createEntityOfSameType(scannerValidate, array, firstElement);
		}
	}

	private void selectEntityType(ScannerValidate scannerValidate, SingletoneArray array) {
		int validVariant = 0;
		while (true) {
			System.out.println("Please, select type of entity:");
			System.out.println(" 1 - Animal");
			System.out.println(" 2 - Barrel");
			System.out.println(" 3 - Human");
			System.out.println(" 4 - Exit");

			System.out.print("Please, enter your chosen action: ");
			validVariant = (int) scannerValidate.getValidValue(TypeValidation.VARIANTS_4);
			
			if (validVariant == 4) {
				System.out.println("Returning to data input menu.");
				break;
			}
			
			if (validVariant == 1) {
				createAnimalEntry(scannerValidate, array);
				break;
			}
			else if (validVariant == 2) {
				createBarrelEntry(scannerValidate, array);
				break;
			}
			else if (validVariant == 3) {
				createHumanEntry(scannerValidate, array);
				break;
			} 
			else if (validVariant == 4) {
				System.out.println("Returning to data input menu.");
				break;
			}
		}
	}

	private void createEntityOfSameType(ScannerValidate scannerValidate, SingletoneArray array, Object firstElement) {
		if (firstElement instanceof Animal) {
			createAnimalEntry(scannerValidate, array);
		} else if (firstElement instanceof Barrel) {
			createBarrelEntry(scannerValidate, array);
		} else if (firstElement instanceof Human) {
			createHumanEntry(scannerValidate, array);
		}
	}

	private void createAnimalEntry(ScannerValidate scannerValidate, SingletoneArray array) {
		System.out.print("Enter animal species: ");
		String species = (String) scannerValidate.getValidValue(TypeValidation.STRING);

		System.out.print("Enter animal eye color: ");
		String eyeColor = (String) scannerValidate.getValidValue(TypeValidation.STRING);

		System.out.print("Does the animal have fur? (true/false): ");
		boolean hasFur = (boolean) scannerValidate.getValidValue(TypeValidation.BOOLEAN);

		Animal animal = new Animal.AnimalBuilder().species(species).eyeColor(eyeColor).hasFur(hasFur).build();
		array.add(animal);
		System.out.println("Animal created: " + animal);
	}

	private void createBarrelEntry(ScannerValidate scannerValidate, SingletoneArray array) {
		System.out.print("Enter barrel volume: ");
		double volume = (float) scannerValidate.getValidValue(TypeValidation.FLOAT);

		System.out.print("Enter stored material: ");
		String storedMaterial = (String) scannerValidate.getValidValue(TypeValidation.STRING);

		System.out.print("Enter material the barrel is made of: ");
		String materialMadeOf = (String) scannerValidate.getValidValue(TypeValidation.STRING);

		Barrel barrel = new Barrel.BarrelBuilder().volume(volume).storedMaterial(storedMaterial)
				.materialMadeOf(materialMadeOf).build();

		array.add(barrel);
		System.out.println("Barrel created: " + barrel);
	}

	private void createHumanEntry(ScannerValidate scannerValidate, SingletoneArray array) {
		System.out.print("Enter human gender: ");
		String gender = (String) scannerValidate.getValidValue(TypeValidation.STRING);

		System.out.print("Enter human age: ");
		int age = (int) scannerValidate.getValidValue(TypeValidation.INT);

		System.out.print("Enter human surname: ");
		String surname = (String) scannerValidate.getValidValue(TypeValidation.STRING);

		Human human = new Human.HumanBuilder().gender(gender).age(age).surname(surname).build();

		array.add(human);
		System.out.println("Human created: " + human);
	}
}
