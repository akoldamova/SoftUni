package football.entities.supplement;

public class Powdered extends BaseSupplement{

    private static final int ENERGY = 120;
    private static final double PRICE = 15;

    public Powdered() {
        super(ENERGY, PRICE);
    }

    @Override
    public int getEnergy() {
        return ENERGY;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
