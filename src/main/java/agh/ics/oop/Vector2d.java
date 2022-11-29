package agh.ics.oop;
import java.security.KeyStore;
import java.util.Objects;

public class Vector2d {
    protected int x;
    protected int y;



    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean precedes(Vector2d other) {
        return other.x <= x && other.y <= y;
    }

    public boolean follows(Vector2d other) {
        return other.x >= x && other.y >= y;
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }

    public Vector2d substract(Vector2d other) {
        return new Vector2d(x - other.x, y - other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(other.x, x), Math.max(other.y, y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(other.x, x), Math.min(other.y, y));
    }

    public Vector2d opposite() {
        return new Vector2d(-x, -y);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Vector2d vector2d = (Vector2d) other;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(%d, %d)".formatted(x, y);
    }

}


