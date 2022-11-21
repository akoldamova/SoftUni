package polymorphism1;

public class Bus extends VehicleImpl{

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        setFuelConsumption(fuelConsumption + 1.4);
        String result = super.drive(distance);
        setFuelConsumption(fuelConsumption - 1.4);
        return result;
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres);
    }

    public String driveEmpty(double distance){
        return super.drive(distance);
    }
}
