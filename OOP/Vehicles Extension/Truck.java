package polymorphism1;

public class Truck extends VehicleImpl{

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        return super.drive(distance);
    }

    @Override
    public void refuel(double litres) {
       super.refuel(litres * 0.95);
    }

}
