package pl.put.poznan.buildinginfo.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    public void testAddLocation() {
        Location fakeLoc1 = mock(Location.class);
        Location fakeLoc2 = mock(Location.class);
        LocationContainer<Location> locationContainer = new LocationContainer<>(1, "container", Types.BUILDING, new ArrayList<>());

        locationContainer.addLocation(fakeLoc1);
        locationContainer.addLocation(fakeLoc2);
        verifyNoInteractions(fakeLoc1, fakeLoc2);
        assertArrayEquals(new Object[]{fakeLoc1, fakeLoc2}, locationContainer.getLocations().toArray());
    }

    @Test
    public void testRemoveLocation() {
        Location fakeLoc1 = mock(Location.class);
        Location fakeLoc2 = mock(Location.class);
        LocationContainer<Location> locationContainer = new LocationContainer<>(
                1, "container", Types.BUILDING,
                new ArrayList<>() {{add(fakeLoc1); add(fakeLoc2);}}
        );

        locationContainer.removeLocation(fakeLoc1);
        verifyNoInteractions(fakeLoc1, fakeLoc2);
        assertArrayEquals(new Object[]{fakeLoc2}, locationContainer.getLocations().toArray());
    }

    @Test
    public void testGetTotalLighting() {
        Location fakeLoc1 = mock(Location.class);
        Location fakeLoc2 = mock(Location.class);
        LocationContainer<Location> container = new LocationContainer<>(
                1, "container", Types.BUILDING,
                new ArrayList<>() {{add(fakeLoc1); add(fakeLoc2);}}
        );

        when(fakeLoc1.getTotalLighting()).thenReturn(1);
        when(fakeLoc2.getTotalLighting()).thenReturn(2);

        Integer res = container.getTotalLighting();
        verify(fakeLoc1).getTotalLighting();
        verify(fakeLoc2).getTotalLighting();
        verifyNoMoreInteractions(fakeLoc1, fakeLoc2);
        assertEquals(3, res);
    }

    @Test
    public void testGetTotalHeating() {
        Location fakeLoc1 = mock(Location.class);
        Location fakeLoc2 = mock(Location.class);
        LocationContainer<Location> container = new LocationContainer<>(
                1, "container", Types.BUILDING,
                new ArrayList<>() {{add(fakeLoc1); add(fakeLoc2);}}
        );

        when(fakeLoc1.getTotalHeating()).thenReturn(1.0f);
        when(fakeLoc2.getTotalHeating()).thenReturn(2.0f);

        Float res = container.getTotalHeating();
        verify(fakeLoc1).getTotalHeating();
        verify(fakeLoc2).getTotalHeating();
        verifyNoMoreInteractions(fakeLoc1, fakeLoc2);
        assertEquals(3, res);
    }
}
