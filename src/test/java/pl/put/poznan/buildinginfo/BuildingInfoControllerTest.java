package java.pl.put.poznan.buildinginfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.put.poznan.buildinginfo.BuildingInfoController;
import pl.put.poznan.buildinginfo.models.Room;
import pl.put.poznan.buildinginfo.models.RoomComposit;
import pl.put.poznan.buildinginfo.models.Types;

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

        RoomComposit condignation = new RoomComposit(4, "Condignation", Types.CONDIGNATION, List.of(room, room2));
        RoomComposit condignation2 = new RoomComposit(5, "Condignation", Types.CONDIGNATION, List.of(room3));
        RoomComposit building = new RoomComposit(6, "Building", Types.BUILDING, List.of(condignation, condignation2));
        assertEquals(buildingInfoController.getArea(building), 170.0f);
    }
}