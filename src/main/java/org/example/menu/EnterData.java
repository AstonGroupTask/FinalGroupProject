package org.example.menu;

import org.example.essence.Animal;
import org.example.essence.Barrel;
import org.example.essence.Human;
import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.TypeValidation;

public final class EnterData extends BaseVariant {

	SingletoneArray array = SingletoneArray.getInstance();

	@Override
	public void menu() {
		System.out.println("Data input mode selected");

		int validVariant = 0;

		while (true) {
			System.out.println("Please, select type of input:");
			System.out.println(" 1 - Manual data entry");
			System.out.println(" 2 - Random data");
			System.out.println(" 3 - Read data from file");
			System.out.println(" 4 - Exit");

			System.out.print("Please, enter your chosen action: ");
			validVariant = (int) scannerValidate.getValidValue(TypeValidation.VARIANTS_4);

			switch (validVariant) {
			case (1):
				manualEntry();
				break;
			case (2):
				// Код2;
				break;
			case (3):

				break;
			default:
			}
			if (validVariant == 4) {
				System.out.println("Return to main menu");
				break;
			}
		}
	}

	private void manualEntry() {
		int validVariant = 0;

		if (array.isEmpty()) {
			while (true) {
				System.out.println("Please, select type of entity:");
				System.out.println(" 1 - Animal");
				System.out.println(" 2 - Barrel");
				System.out.println(" 3 - Human");
				System.out.println(" 4 - Exit");

				System.out.print("Please, enter your chosen action: ");
				validVariant = (int) scannerValidate.getValidValue(TypeValidation.VARIANTS_4);

				switch (validVariant) {
				case (1):
					handleEntityEntry(this::createAnimalEntry);
					break;
				case (2):
					handleEntityEntry(this::createBarrelEntry);
					break;
				case (3):
					handleEntityEntry(this::createHumanEntry);
					break;
				default:
				}
				if (validVariant == 4) {
					System.out.println("Returning to data input menu.");
					break;
				}
			}
		} else {
			Object firstEntity = array.get(0);
			if (firstEntity instanceof Animal) {
				System.out.println("The array already contains Animals. You can add more Animals.");
				handleEntityEntry(this::createAnimalEntry);
			} else if (firstEntity instanceof Barrel) {
				System.out.println("The array already contains Barrels. You can add more Barrels.");
				handleEntityEntry(this::createBarrelEntry);
			} else if (firstEntity instanceof Human) {
				System.out.println("The array already contains Humans. You can add more Humans.");
				handleEntityEntry(this::createHumanEntry);
			}
		}
	}

	private void handleEntityEntry(Runnable entityEntryMethod) {
		while (true) {
			entityEntryMethod.run();

			System.out.print(
					"Do you want to add another entity of the same type? (Type 'No' to stop or 'Yes' to continue): ");
			String input = scannerValidate.getValidValue(TypeValidation.STRING).toString().trim().toLowerCase();

			if (input.equals("No")) {
				System.out.println("Exiting entity creation.");
				break;
			}
		}
	}

	private void createAnimalEntry() {
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

	private void createBarrelEntry() {
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

	private void createHumanEntry() {
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
