package pl.put.poznan.buildinginfo.models;

import java.util.List;

public class RoomComposit<Sublocation extends Location> extends Location{

    public RoomComposit(Integer id, String name, Types type, List<Sublocation> locations) {
        super(id, name);
        this.locations = locations;
    }

    private List<Sublocation> locations;

    public void addLocation(Sublocation location) {
        locations.add(location);
    }

    public void removeLocation(Sublocation location) {
        locations.remove(location);
    }

    public List<Sublocation> getLocations() {
        return locations;
    }

    @Override
    public Float getArea() { return this.getLocations().stream().map(Sublocation::getArea).reduce(0f, Float::sum); }

    @Override
    public Float getCube() { return this.getLocations().stream().map(Sublocation::getCube).reduce(0f, Float::sum); }

    @Override
    public Float getTotalHeating() { return this.getLocations().stream().map(Sublocation::getTotalHeating).reduce(0f, Float::sum); }

    @Override
    public Integer getTotalLighting() { return this.getLocations().stream().map(Sublocation::getTotalLighting).reduce(0, Integer::sum); }
}

