package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;

public class DiscovererRepository implements Repository<Discoverer>{
    private Collection<Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new ArrayList<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return discoverers;
    }

    @Override
    public void add(Discoverer discoverer) {
        discoverers.add(discoverer);
    }

    @Override
    public boolean remove(Discoverer discoverer) {
        return discoverers.remove(discoverer);
    }

    @Override
    public Discoverer byName(String name) {
        return discoverers.stream()
                .filter(discoverer -> discoverer.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
