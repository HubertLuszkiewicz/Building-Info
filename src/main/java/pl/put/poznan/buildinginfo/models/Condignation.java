package pl.put.poznan.buildinginfo.models;

import java.util.List;

public class Condignation extends RoomComposit<Room> {
    public Condignation(Integer id, String name, Types type, List<Room> locations) {
        super(id, name, type, locations);
    }
}
