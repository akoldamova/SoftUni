package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.Collection;
import java.util.List;

public interface Field {
    int sumEnergy();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void addSupplement(Supplement supplement);

    void drag();

    String getInfo();

    List<Player> getPlayers();

    List<Supplement> getSupplements();

    String getName();
}
