package shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add (Animal animal){
        if (data.size() < capacity){
            data.add(animal);
        }
    }

    public boolean remove (String name){
        return data.removeIf(a -> a.getName().equals(name));
    }

    public Animal getAnimal (String name, String caretaker){
        return data.stream()
                .filter(a -> a.getName().equals(name) && a.getCaretaker().equals(caretaker))
                .findAny()
                .orElse(null);
    }

    public Animal getOldestAnimal (){
        return Collections.max(data, Comparator.comparing(Animal::getAge));
    }

    public int getCount (){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder("The shelter has the following animals:");
        for (Animal a : data){
            stringBuilder.append(System.lineSeparator())
                    .append(a.getName())
                    .append(" ")
                    .append(a.getCaretaker());
        }
        return stringBuilder.toString();
    }

}
