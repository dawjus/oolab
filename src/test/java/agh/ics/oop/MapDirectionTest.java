package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        MapDirection next_south = MapDirection.SOUTH.next();
        MapDirection next_west = MapDirection.WEST.next();
        MapDirection next_north = MapDirection.NORTH.next();
        MapDirection next_east = MapDirection.EAST.next();

        assertEquals(MapDirection.WEST, next_south);
        assertEquals(MapDirection.NORTH, next_west);
        assertEquals(MapDirection.EAST, next_north);
        assertEquals(MapDirection.SOUTH, next_east);
    }
    @Test
    void previous() {
        MapDirection previous_south = MapDirection.SOUTH.previous();
        MapDirection previous_west = MapDirection.WEST.previous();
        MapDirection previous_north = MapDirection.NORTH.previous();
        MapDirection previous_east = MapDirection.EAST.previous();
        assertEquals(MapDirection.EAST, previous_south);
        assertEquals(MapDirection.SOUTH, previous_west);
        assertEquals(MapDirection.WEST, previous_north);
        assertEquals(MapDirection.NORTH, previous_east);
    }
}