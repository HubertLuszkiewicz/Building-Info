package pl.put.poznan.buildinginfo.models;

import java.util.List;

public class Floor extends LocationContainer<Room> {
    public Floor(Integer id, String name, Types type, List<Room> locations) {
        super(id, name, type, locations);
    }
}
