package polymorphism1;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
    }

    @Override
    public String drive(double distance) {
       return super.drive(distance);
    }


    @Override
    public void refuel(double litres) {
        super.refuel(litres);
    }
}
