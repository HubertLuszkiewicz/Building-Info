package pl.put.poznan.buildinginfo.models;

import java.util.List;

/**
 * Class representing floor in a building
 */
public class Floor extends LocationContainer<Room> {
    /**
     * Default constructor for initializing all properties
     * @param id Location ID
     * @param name Location name
     * @param type Location type (unused)
     * @param locations Rooms list
     */
    public Floor(Integer id, String name, Types type, List<Room> locations) {
        super(id, name, type, locations);
    }
}
