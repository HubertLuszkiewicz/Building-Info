package java.pl.put.poznan.buildinginfo.models;

import org.junit.jupiter.api.Test;
import pl.put.poznan.buildinginfo.models.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
    @Test
    public void testGetCube() {
        Room room = new Room(1, "Room", 10.0f, 15.0f, 0.0f, 0);
        assertEquals(room.getCube(), 15.0f);
    }

    @Test
    public void testGetArea() {
        Room room = new Room(1, "Room", 10.0f, 15.0f, 0.0f, 0);
        assertEquals(room.getArea(), 10.0f);
    }
}