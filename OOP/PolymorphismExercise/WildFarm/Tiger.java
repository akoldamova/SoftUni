package WildFarm;

public class Tiger extends Felime{

    public Tiger(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Meat){
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
