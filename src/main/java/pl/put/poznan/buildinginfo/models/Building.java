package pl.put.poznan.buildinginfo.models;

import java.util.List;

public class Building extends RoomComposit<Condignation> {
    public Building(Integer id, String name, Types type, List<Condignation> locations) {
        super(id, name, type, locations);
    }
}
