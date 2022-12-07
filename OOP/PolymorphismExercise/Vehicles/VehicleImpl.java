package polymorphism1;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    double fuelQuantity;
    double fuelConsumption;

    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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
        setFuelQuantity(fuelQuantity + litres);
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
