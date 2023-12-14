package pl.put.poznan.buildinginfo.models;

import java.util.List;

public class RoomComponent extends Location{

    public RoomComponent(Integer id, String name, Types type, List<Location> locations) {
        super(id, name);
        this.locations = locations;
    }

    private List<Location> locations;

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void removeLocation(Location location) {
        locations.remove(location);
    }

    public List<Location> getLocations() {
        return locations;
    }

    @Override
    public Float getArea() {
        return this.getLocations().stream().map(Location::getArea).reduce(0f, Float::sum);
    }

    @Override
    public Float getCube() {
        return this.getLocations().stream().map(Location::getCube).reduce(0f, Float::sum);
    }
}

