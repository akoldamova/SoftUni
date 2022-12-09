package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.Collection;
import java.util.List;

public class NaturalGrass extends BaseField {
    private static final int CAPACITY = 250;

    public NaturalGrass(String name) {
        super(name, CAPACITY);
    }
}