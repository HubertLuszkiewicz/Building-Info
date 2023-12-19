package pl.put.poznan.buildinginfo.models;

import java.util.List;

public class Building extends LocationContainer<Floor> {
    public Building(Integer id, String name, Types type, List<Floor> locations) {
        super(id, name, type, locations);
    }
}
