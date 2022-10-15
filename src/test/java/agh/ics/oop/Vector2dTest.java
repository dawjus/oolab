package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import javax.print.attribute.standard.MediaSize;
import static org.junit.jupiter.api.Assertions.*;


class Vector2dTest {

    private final Vector2d v1 = new Vector2d(5, 3);
    private final Vector2d v2 = new Vector2d(2, 1);
    private final Vector2d v3 = new Vector2d(4,4);

    @Test
    void precedes() {
        assertTrue(v1.precedes(v2));
        assertFalse(v3.precedes(v1));
    }

    @Test
    void follows() {
        assertTrue(v2.follows(v1));
        assertFalse(v1.follows(v3));
    }

    @Test
    void add() {
        assertEquals(new Vector2d(7,4), v1.add(v2));
    }

    @Test
    void substract() {
        assertEquals(new Vector2d(3,2).toString(), v1.substract(v2).toString());
    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(5,4), v1.upperRight(v3));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(4,3), v1.lowerLeft(v3));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(-5,-3), v1.opposite());
    }

    @Test
    void equals(){
        Vector2d v1_copy = new Vector2d(5,3);
        assertTrue(v1.equals(v1_copy));
    }

    @Test
    void testToString() {
        assertEquals("(5, 3)", v1.toString());
    }
}
