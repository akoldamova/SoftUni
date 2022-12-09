package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.Collection;
import java.util.List;

public class ArtificialTurf extends BaseField {
    private static final int CAPACITY = 150;

    public ArtificialTurf(String name) {
        super(name, CAPACITY);
    }
}

