package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fieldType = scanner.nextLine();
		Class<harvestingFields.RichSoilLand> richSoilLandClass = harvestingFields.RichSoilLand.class;
		Field[] declaredFields = richSoilLandClass.getDeclaredFields();

		Consumer<Field> printer = field -> System.out.printf(
				"%s %s %s\n",
				Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(),
				field.getName());

		while ((!fieldType.equals("HARVEST"))){

			switch (fieldType) {
				case "private" -> Arrays.stream(declaredFields)
						.filter(field -> Modifier.isPrivate(field.getModifiers()))
						.forEach(printer);
				case "protected" -> Arrays.stream(declaredFields)
						.filter(field -> Modifier.isProtected(field.getModifiers()))
						.forEach(printer);
				case "public" -> Arrays.stream(declaredFields)
						.filter(field -> Modifier.isPublic(field.getModifiers()))
						.forEach(printer);
				case "all" -> Arrays.stream(declaredFields)
						.forEach(printer);
			}

			fieldType = scanner.nextLine();
		}

	}
}
