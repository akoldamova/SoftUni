package polymorphism1;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    double fuelQuantity;
    double fuelConsumption;
    double tankCapacity;

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String drive(double distance) {
        double neededFuel = distance * fuelConsumption;
        if (neededFuel <= fuelQuantity){
            setFuelQuantity(fuelQuantity - neededFuel);
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            return String.format("%s travelled %s km",
                    getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            return getClass().getSimpleName() + " needs refueling";

        }
    }

    @Override
    public void refuel(double litres) {
        if (litres > 0) {
            if (tankCapacity < fuelQuantity + litres){
                System.out.println("Cannot fit fuel in tank");
            } else {
                setFuelQuantity(fuelQuantity + litres);
            }
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }


    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public String toString(){
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
