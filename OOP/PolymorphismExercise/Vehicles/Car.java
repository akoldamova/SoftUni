package polymorphism1;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
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
