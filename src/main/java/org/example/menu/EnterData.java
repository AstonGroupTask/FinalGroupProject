package org.example.menu;

import org.example.essence.Animal;
import org.example.essence.Barrel;
import org.example.essence.Human;
import org.example.singletoneArray.SingletoneArray;
import org.example.strategies.fill.FillFromFile;
import org.example.util.randomaizer.RandomEntityArrayFiller;
import org.example.util.randomaizer.RandomEntityGenerator;
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
				randomEntry();
				break;
			case (3):
				fileEntry();
				break;
			default:
			}
			if (validVariant == 4) {
				System.out.println("Return to main menu");
				break;
			}
		}
	}

	private void fileEntry() {
		System.out.print("Please, enter your file path: ");
		String filePath = (String)scannerValidate.getValidValue(TypeValidation.STRING_FILE_PATH);

		FillFromFile<Object> fillStrategy = new FillFromFile<>();
		Object[] result = fillStrategy.fillFromFile(0, filePath);

		if (result == null)
		{
			System.out.print("File reading error");
			return;
		}
		
		for (Object entity : (Object[]) result[0]) {
			array.add(entity);
		}
		System.out.print("File reading complete");
	}

	private void randomEntry() {
		int validVariant = 0;
		int numberOfEntities = 0;
		if (array.isEmpty()) {
			while (validVariant != 4) {
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

				System.out.print("Please, enter the number of entities to add: ");
				numberOfEntities = (int) scannerValidate.getValidValue(TypeValidation.INT);

				if (validVariant == 1) {
					for (int i = 0; i < numberOfEntities; i++)
						array.add(RandomEntityGenerator.randomAnimalGenerate());

					break;
				} else if (validVariant == 2) {
					for (int i = 0; i < numberOfEntities; i++)
						array.add(RandomEntityGenerator.randomBarrelGenerate());

					break;
				} else if (validVariant == 3) {
					for (int i = 0; i < numberOfEntities; i++)
						array.add(RandomEntityGenerator.randomHumanGenerate());

					break;
				}
			}
		} else {
			System.out.println("The array already contains " + array.getStoredType() + ". You can only add more "
					+ array.getStoredType() + ".");

			System.out.print("Please, enter the number of entities to add: ");
			numberOfEntities = (int) scannerValidate.getValidValue(TypeValidation.INT);

			Object firstEntity = array.get(0);
			if (firstEntity instanceof Animal) {
				for (int i = 0; i < numberOfEntities; i++)
					array.add(RandomEntityGenerator.randomAnimalGenerate());

			} else if (firstEntity instanceof Barrel) {
				for (int i = 0; i < numberOfEntities; i++)
					array.add(RandomEntityGenerator.randomBarrelGenerate());

			} else if (firstEntity instanceof Human) {
				for (int i = 0; i < numberOfEntities; i++)
					array.add(RandomEntityGenerator.randomHumanGenerate());

			}
		}
		System.out.println("Addition complete");
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
			System.out.println("The array already contains " + array.getStoredType() + ". You can only add more "
					+ array.getStoredType() + ".");

			if (firstEntity instanceof Animal) {
				handleEntityEntry(this::createAnimalEntry);
			} else if (firstEntity instanceof Barrel) {
				handleEntityEntry(this::createBarrelEntry);
			} else if (firstEntity instanceof Human) {
				handleEntityEntry(this::createHumanEntry);
			}
		}
	}

	private void handleEntityEntry(Runnable entityEntryMethod) {
		while (true) {
			entityEntryMethod.run();

			System.out.print(
					"Do you want to add another entity of the same type? (Type 'Exit' to stop or press Enter to continue): ");
			String input = (String) scannerValidate.getValidValue(TypeValidation.STRING_EMPTY).toString().trim()
					.toLowerCase();

			if (input.equals("exit")) {
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
