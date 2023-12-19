package pl.put.poznan.buildinginfo.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationContainerTest {
    @Test
    public void getAreaForFloorTest() {
        Room room = new Room(1, "Room", 7.0f, 0.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 42.0f, 0.0f, 0.0f, 0);
        Floor floor = new Floor(3, "Floor", Types.FLOOR, List.of(room, room2));
        assertEquals(floor.getArea(), 49.0f);
    }

    @Test
    public void testGetAreaForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 0.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 10.0f, 0.0f, 0.0f, 0);
        Room room3 = new Room(3, "Room3", 20.0f, 0.0f, 0.0f, 0);
        Room room4 = new Room(4, "Room4", 20.0f, 0.0f, 0.0f, 0);
        Floor floor = new Floor(5, "Floor", Types.FLOOR, List.of(room, room2));
        Floor floor2 = new Floor(6, "Floor2", Types.FLOOR, List.of(room3, room4));
        Building building = new Building(7, "Building", Types.BUILDING, List.of(floor, floor2));
        assertEquals(building.getArea(), 60.0f);
    }

    @Test
    public void testGetCubeForFloor() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0);
        Floor floor = new Floor(3, "Floor", Types.FLOOR, List.of(room, room2));
        assertEquals(floor.getVolume(), 70.0f);
    }

    @Test
    public void testGetCubeForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 40.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0);
        Room room3 = new Room(3, "Room3", 30.0f, 40.0f, 0.0f, 0);
        Room room4 = new Room(4, "Room4", 40.0f, 30.0f, 0.0f, 0);
        Floor floor = new Floor(5, "Floor", Types.FLOOR, List.of(room, room2));
        Floor floor2 = new Floor(6, "Floor2", Types.FLOOR, List.of(room3, room4));
        Building building = new Building(7, "Building", Types.BUILDING, List.of(floor, floor2));
        assertEquals(building.getVolume(), 150.0f);
    }
}
