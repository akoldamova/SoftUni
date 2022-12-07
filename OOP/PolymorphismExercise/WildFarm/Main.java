package WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("End")){

            String [] animalInfo = command.split("\\s+");
            Mammal mammal = setAnimal(animalInfo);
            String [] foodInfo = scanner.nextLine().split("\\s+");

            Food food = setFood(foodInfo);

            mammal.makeSound();
            mammal.eat(food);
            System.out.println(mammal.toString());

            command = scanner.nextLine();
        }

    }

    private static Food setFood(String [] foodInfo) {

        String foodType = foodInfo[0];
        int foodQuantity = Integer.parseInt(foodInfo[1]);

        switch (foodType){
            case "Vegetable":
                return new Vegetable(foodQuantity);
            case "Meat":
                return new Meat(foodQuantity);
        }
        return null;
    }

    private static Mammal setAnimal(String [] animalInfo) {
        String animalType = animalInfo[0];
        String animalName = animalInfo[1];
        Double animalWeight = Double.parseDouble(animalInfo[2]);
        String animalLivingRegion = animalInfo[3];
        String catBreed = "";
        if (animalInfo.length == 5){
            catBreed = animalInfo[4];
        }

        switch (animalType){
            case "Cat":
               return new Cat
                        (animalName, animalType, animalWeight, 0, animalLivingRegion, catBreed);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, 0, animalLivingRegion);
            case "Mouse":
               return new Mouse(animalName, animalType, animalWeight, 0, animalLivingRegion);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, 0, animalLivingRegion);
        }
        return null;
    }
}
