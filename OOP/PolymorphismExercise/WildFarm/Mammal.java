package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(), animalName, decimalFormat.format(animalWeight), livingRegion, foodEaten);
    }
}
