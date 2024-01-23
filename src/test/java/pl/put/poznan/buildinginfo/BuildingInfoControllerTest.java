package pl.put.poznan.buildinginfo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.put.poznan.buildinginfo.models.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.Collections;
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

    @Test
    public void testGetArea() {
        Location fakeLoc = mock(Location.class);
        when(fakeLoc.getArea()).thenReturn(1.0f);

        Float res = this.buildingInfoController.getArea(fakeLoc);
        verify(fakeLoc).getArea();
        assertEquals(1.0f, res);
    }

    @Test
    public void testGetVolume() {
        Location fakeLoc = mock(Location.class);
        when(fakeLoc.getVolume()).thenReturn(1.0f);

        Float res = this.buildingInfoController.getVolume(fakeLoc);
        verify(fakeLoc).getVolume();
        assertEquals(1.0f, res);
    }

    @Test
    public void testGetLightingPerArea() {
        Location fakeLoc = mock(Location.class);
        when(fakeLoc.getTotalLighting()).thenReturn(5);
        when(fakeLoc.getArea()).thenReturn(2.0f);

        Float res = this.buildingInfoController.getLightingPerArea(fakeLoc);
        verify(fakeLoc).getTotalLighting();
        verify(fakeLoc).getArea();
        verifyNoMoreInteractions(fakeLoc);
        assertEquals(2.5f, res);
    }

    @Test
    public void testGetHeatingPerVolume() {
        Location fakeLoc = mock(Location.class);
        when(fakeLoc.getTotalHeating()).thenReturn(5.0f);
        when(fakeLoc.getVolume()).thenReturn(2.0f);

        Float res = this.buildingInfoController.getHeatingPerVolume(fakeLoc);
        verify(fakeLoc).getTotalHeating();
        verify(fakeLoc).getVolume();
        verifyNoMoreInteractions(fakeLoc);
        assertEquals(2.5f, res);
    }

    @Test
    public void testGetOverheatedRooms() {
        Room room1 = mock(Room.class);
        room1.id = 1;
        when(room1.getTotalHeating()).thenReturn(5.0f);
        when(room1.getVolume()).thenReturn(2.0f);

        Room room2 = mock(Room.class);
        room2.id = 2;
        when(room2.getTotalHeating()).thenReturn(10.0f);
        when(room2.getVolume()).thenReturn(2.0f);

        Floor floor = mock(Floor.class);
        when(floor.getLocations()).thenReturn(List.of(room1, room2));

        Building building = mock(Building.class);
        when(building.getLocations()).thenReturn(List.of(floor));

        List<Integer> res = this.buildingInfoController.getOverheatedRooms(building, 3.0f);
        verify(building).getLocations();
        verify(floor).getLocations();
        verify(room1).getTotalHeating();
        verify(room1).getVolume();
        verify(room2).getTotalHeating();
        verify(room2).getVolume();
        verifyNoMoreInteractions(building, floor, room1, room2);
        assertArrayEquals(res.toArray(), new Integer[]{ 2 });
    }

    @Test
    public void testGetOverheatedRooms_NoRooms() {
        Floor floor = mock(Floor.class);
        when(floor.getLocations()).thenReturn(Collections.emptyList());

        Building building = mock(Building.class);
        when(building.getLocations()).thenReturn(List.of(floor));

        List<Integer> res = this.buildingInfoController.getOverheatedRooms(building, 3.0f);
        verify(building).getLocations();
        verify(floor).getLocations();
        verifyNoMoreInteractions(building, floor);
        assertArrayEquals(res.toArray(), new Integer[]{});
    }

    @Test
    public void testGetLightingLowest() {
        Room room1 = mock(Room.class, "1");
        room1.name = "1";
        when(room1.getTotalLighting()).thenReturn(5);

        Room room2 = mock(Room.class, "2");
        room2.name = "2";
        when(room2.getTotalLighting()).thenReturn(10);

        Room room3 = mock(Room.class, "3");
        room3.name = "3";
        when(room3.getTotalLighting()).thenReturn(5);

        Floor floor = mock(Floor.class);
        when(floor.getLocations()).thenReturn(List.of(room1, room2, room3));

        Building building = mock(Building.class);
        when(building.getLocations()).thenReturn(List.of(floor));

        List<String> res = this.buildingInfoController.getLightingLowest(building);
        verify(building).getLocations();
        verify(floor).getLocations();
        verify(room1).getTotalLighting();
        verify(room2).getTotalLighting();
        verify(room3).getTotalLighting();
        verifyNoMoreInteractions(building, floor, room1, room2, room3);
        assertArrayEquals(new String[]{ room1.name, room3.name }, res.toArray());
    }
}
