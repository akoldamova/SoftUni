package WildFarm;

public class Mouse extends Mammal{

    public Mouse(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");
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

    @Override
    public String toString() {
        return super.toString();
    }
}
