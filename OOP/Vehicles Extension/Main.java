package polymorphism1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", readCarInfo(scanner));
        vehicles.put("Truck", readTruckInfo(scanner));
        vehicles.put("Bus", readBussInfo(scanner));

        int commandsNum = Integer.parseInt(scanner.nextLine());
        while (commandsNum-- > 0){
            String [] vehicleCommands = scanner.nextLine().split("\\s+");
            double argument = Double.parseDouble(vehicleCommands[2]);
            String vehicleType = vehicleCommands[1];
            String vehicleCommand = vehicleCommands[0];
            switch (vehicleCommand){
                case "Drive":
                    System.out.println(vehicles.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    vehicles.get(vehicleType).refuel(argument);
                    break;
                case "DriveEmpty":
                    Bus bus = (Bus) vehicles.get(vehicleType);
                    System.out.println(bus.driveEmpty(argument));
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);

    }

    private static VehicleImpl readCarInfo(Scanner scanner) {
        String [] vehicleInfo = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumption = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);
        return new Car(fuelQuantity, fuelConsumption, tankCapacity);
    }

    private static VehicleImpl readTruckInfo(Scanner scanner) {
        String [] vehicleInfo = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumption = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);
        return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
    }

    private static VehicleImpl readBussInfo(Scanner scanner) {
        String [] vehicleInfo = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumption = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);
        return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
    }


    }
