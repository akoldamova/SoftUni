package WildFarm;

public class Zebra extends Mammal{

    public Zebra(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Vegetable){
            setFoodEaten(food.quantity);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName())
                    .append("s")
                    .append(" are not eating that type of food!");
            System.out.println(stringBuilder.toString());
        }
    }


}
