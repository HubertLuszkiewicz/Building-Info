package pl.put.poznan.buildinginfo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
    @Test
    public void testGetCube() {
        Room room = new Room(1, "Room", 10.0f, 15.0f, 0.0f, 0);
        assertEquals(room.getVolume(), 15.0f);
    }

    @Test
    public void testGetArea() {
        Room room = new Room(1, "Room", 10.0f, 15.0f, 0.0f, 0);
        assertEquals(room.getArea(), 10.0f);
    }

    @Test
    public void testGetTotalHeating() {
        Room room = new Room(1, "Room", 10.0f, 15.0f, 15.0f, 0);
        assertEquals(room.getTotalHeating(), 15.0f);
    }

    @Test
    public void testGetTotalLighting() {
        Room room = new Room(1, "Room", 10.0f, 15.0f, 15.0f, 10.0f);
        assertEquals(room.getTotalLighting(), 10.0f);
}
