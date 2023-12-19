package pl.put.poznan.buildinginfo.models;

import java.util.List;

/**
 * Generic class representing a location that can hold sublocations,
 * that holds no other information on its own. (i.e. Building contains Floors)
 * @param <Sublocation> Sublocation type
 */
public class LocationContainer<Sublocation extends Location> extends Location{
    /**
     * Default constructor
     * @param id Location ID
     * @param name Location name
     * @param type Location type (unused)
     * @param locations Sublocations list
     */
    public LocationContainer(Integer id, String name, Types type, List<Sublocation> locations) {
        super(id, name);
        this.locations = locations;
    }

    /** Container holding sublocation references */
    private final List<Sublocation> locations;

    /**
     * Add a sublocation to the container
     * @param location Sublocation to be added
     */
    public void addLocation(Sublocation location) {
        locations.add(location);
    }

    /**
     * Remove location from the container
     * @param location Sublocation to be removed
     */
    public void removeLocation(Sublocation location) {
        locations.remove(location);
    }

    /**
     * Get all direct sublocations of this container
     * @return Sublocation list
     */
    public List<Sublocation> getLocations() {
        return locations;
    }

    /**
     * @return Area sum of its sublocations
     */
    @Override
    public Float getArea() { return this.getLocations().stream().map(Sublocation::getArea).reduce(0f, Float::sum); }

    /**
     * @return Volume sum of its sublocations
     */
    @Override
    public Float getVolume() { return this.getLocations().stream().map(Sublocation::getVolume).reduce(0f, Float::sum); }

    /**
     * @return Total heating power usage in all sublocations
     */
    @Override
    public Float getTotalHeating() { return this.getLocations().stream().map(Sublocation::getTotalHeating).reduce(0f, Float::sum); }

    /**
     * @return Total lighting intensity in all sublocations
     */
    @Override
    public Integer getTotalLighting() { return this.getLocations().stream().map(Sublocation::getTotalLighting).reduce(0, Integer::sum); }
}

