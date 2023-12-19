package pl.put.poznan.buildinginfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.put.poznan.buildinginfo.models.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BuildingInfoControllerTest {

    @Autowired
    private BuildingInfoController buildingInfoController;

    @Test
    public void testGetBuildingInfo() {
        Room room = new Room(1, "Room", 10.0f, 0.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 10.0f, 0.0f, 0.0f, 0);
        Room room3 = new Room(3, "Room3", 150.0f, 0.0f, 0.0f, 0);

        Floor floor = new Floor(4, "Floor", Types.FLOOR, List.of(room, room2));
        Floor floor2 = new Floor(5, "Floor2", Types.FLOOR, List.of(room3));
        Building building = new Building(6, "Building", Types.BUILDING, List.of(floor, floor2));
        assertEquals(buildingInfoController.getArea((Location)building), 170.0f);
    }
}
