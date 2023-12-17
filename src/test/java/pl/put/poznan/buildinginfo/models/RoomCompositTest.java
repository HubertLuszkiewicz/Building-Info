package java.pl.put.poznan.buildinginfo.models;

import org.junit.jupiter.api.Test;
import pl.put.poznan.buildinginfo.models.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomCompositTest {
    @Test
    public void getAreaForFloorTest() {
        Room room = new Room(1, "Room", 7.0f, 0.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 42.0f, 0.0f, 0.0f, 0);
        RoomComposit condignation = new RoomComposit(3, "Condignation", Types.CONDIGNATION, List.of(room, room2));
        assertEquals(condignation.getArea(), 49.0f);
    }

    @Test
    public void testGetAreaForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 0.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 10.0f, 0.0f, 0.0f, 0);
        Room room3 = new Room(3, "Room3", 20.0f, 0.0f, 0.0f, 0);
        Room room4 = new Room(4, "Room4", 20.0f, 0.0f, 0.0f, 0);
        RoomComposit condignation = new RoomComposit(5, "Condignation", Types.CONDIGNATION, List.of(room, room2));
        RoomComposit condignation2 = new RoomComposit(6, "Condignation2", Types.CONDIGNATION, List.of(room3, room4));
        RoomComposit building = new RoomComposit(7, "Building", Types.BUILDING, List.of(condignation, condignation2));
        assertEquals(building.getArea(), 60.0f);
    }

    @Test
    public void testGetCubeForFloor() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0);
        RoomComposit condignation = new RoomComposit(3, "Floor", Types.CONDIGNATION, List.of(room, room2));
        assertEquals(condignation.getCube(), 70.0f);
    }

    @Test
    public void testGetCubeForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 40.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0);
        Room room3 = new Room(3, "Room3", 30.0f, 40.0f, 0.0f, 0);
        Room room4 = new Room(4, "Room4", 40.0f, 30.0f, 0.0f, 0);
        RoomComposit condignation = new RoomComposit(5, "Floor", Types.CONDIGNATION, List.of(room, room2));
        RoomComposit condignation2 = new RoomComposit(6, "Floor2", Types.CONDIGNATION, List.of(room3, room4));
        RoomComposit building = new RoomComposit(7, "Building", Types.BUILDING, List.of(condignation, condignation2));
        assertEquals(building.getCube(), 150.0f);
    }
}