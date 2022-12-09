package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpotRepository implements Repository<Spot>{
    private Map<Spot, String> spots;

    public SpotRepository() {
        this.spots = new HashMap<Spot, String>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return spots.keySet();
    }

    @Override
    public void add(Spot spot) {
        spots.put(spot, "");
    }

    @Override
    public boolean remove(Spot spot) {
        boolean isRemoved = false;

        if (spots.containsKey(spot)){
            spots.remove(spot);
            isRemoved = true;
        }

        return isRemoved;
    }

    @Override
    public Spot byName(String name) {
        return spots.keySet().stream()
                .filter(spot -> spot.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
