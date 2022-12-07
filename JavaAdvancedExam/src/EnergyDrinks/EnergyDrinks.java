package EnergyDrinks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] n = Arrays.stream(scanner.nextLine().split(",\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> miligrams = new ArrayDeque<>(); //stack

        for (int i = 0; i < n.length; i++) {
            miligrams.push(n[i]);
        }

        int [] m = Arrays.stream(scanner.nextLine().split(",\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> drink = new ArrayDeque<>(); //queue

        for (int i = 0; i < m.length; i++) {
            drink.offer(m[i]);
        }

        int caffeineLimit = 300;
        int takenCaffeine = 0;

        while (!drink.isEmpty() && !miligrams.isEmpty()){
            if (miligrams.peek() * drink.peek() <= caffeineLimit - takenCaffeine){
                takenCaffeine += miligrams.pop() * drink.poll();
            } else {
                if (takenCaffeine - 30 > 0){
                    takenCaffeine -= 30;
                }
                miligrams.poll();
                drink.offer(drink.poll());
            }
        }

        if (drink.isEmpty()){
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.print("Drinks left: ");
            System.out.println(drink.toString().replace("[","").replace("]",""));
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", takenCaffeine);
    }
}

