package WildFarm;

public abstract class Animal {
    String animalName;
    String animalType;
    Double animalWeight;
    Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight, Integer foodEaten) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = foodEaten;
    }

    protected abstract void makeSound();
    protected abstract void eat(Food food);

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

}
