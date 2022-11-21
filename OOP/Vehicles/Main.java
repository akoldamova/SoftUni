package polymorphism1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] carInfo = scanner.nextLine().split("\\s+");
        VehicleImpl car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        String [] truckInfo = scanner.nextLine().split("\\s+");
        VehicleImpl truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));


        int commandsNum = Integer.parseInt(scanner.nextLine());
        while (commandsNum-- > 0){
            String [] vehicleCommand = scanner.nextLine().split("\\s+");
            String vehicleType = vehicleCommand[1];
            switch (vehicleType){
                case "Car":
                    doCommand(car, vehicleCommand);
                    break;
                case "Truck":
                    doCommand(truck, vehicleCommand);
                    break;
            }
        }

        printVehicles(car, truck);

    }

    private static void printVehicles(VehicleImpl car, VehicleImpl truck) {
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }

    private static void doCommand(VehicleImpl vehicle, String[] vehicleCommand) {
        switch (vehicleCommand[0]){
            case "Drive":
                double km = Double.parseDouble(vehicleCommand[2]);
                System.out.println(vehicle.drive(km));
                break;
            case "Refuel":
                double litres = Double.parseDouble(vehicleCommand[2]);
                vehicle.refuel(litres);
                break;
        }
    }
}
