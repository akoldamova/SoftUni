package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fieldType = scanner.nextLine();
		Class<harvestingFields.RichSoilLand> richSoilLandClass = harvestingFields.RichSoilLand.class;
		Field[] declaredFields = richSoilLandClass.getDeclaredFields();

		while ((!fieldType.equals("HARVEST"))){
			switch (fieldType){
				case "private":
					Arrays.stream(declaredFields)
							.filter(field -> Modifier.isPrivate(field.getModifiers()))
							.forEach(field -> System.out.println(Modifier.toString(field.getModifiers()) + " "
									+ field.getType().getSimpleName()+ " "
									+ field.getName()));
					break;
				case "protected":
					Arrays.stream(declaredFields)
							.filter(field -> Modifier.isProtected(field.getModifiers()))
							.forEach(field -> System.out.println(Modifier.toString(field.getModifiers()) + " "
									+ field.getType().getSimpleName()+ " "
									+ field.getName()));
					break;
				case "public":
					Arrays.stream(declaredFields)
							.filter(field -> Modifier.isPublic(field.getModifiers()))
							.forEach(field -> System.out.println(Modifier.toString(field.getModifiers()) + " "
									+ field.getType().getSimpleName()+ " "
									+ field.getName()));
					break;
				case "all":
					Arrays.stream(declaredFields)
							.forEach(field -> System.out.println(Modifier.toString(field.getModifiers()) + " "
									+ field.getType().getSimpleName()+ " "
									+ field.getName()));
					break;
			}

			fieldType = scanner.nextLine();
		}

	}
}
