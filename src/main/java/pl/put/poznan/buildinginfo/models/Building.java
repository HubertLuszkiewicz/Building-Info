package pl.put.poznan.buildinginfo.models;

import java.util.List;

/**
 * Class representing the whole building
 */
public class Building extends LocationContainer<Floor> {
    /**
     * Default constructor for initializing all properties
     * @param id Location ID
     * @param name Location name
     * @param type Location type (unused)
     * @param locations Floors list
     */
    public Building(Integer id, String name, Types type, List<Floor> locations) {
        super(id, name, type, locations);
    }
}
