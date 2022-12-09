package football.entities.player;

import static football.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player{

    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, double kg, int strength) {
        this.setName(name);
        this.setNationality(nationality);
        this.kg = kg;
        this.setStrength(strength);
    }

    public void setName(String name){
        if (name == null || name.trim().isBlank()){
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    private void setNationality(String nationality) {
        if (nationality == null || nationality.trim().isBlank()){
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;
    }

    protected void setStrength(int strength) {
        if (strength <= 0){
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public abstract void stimulation();

    @Override
    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public int getStrength() {
        return strength;
    }
}
