package agh.ics.oop;
import java.security.KeyStore;
import java.util.Objects;

public class Vector2d {
    private int x;
    private int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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


    /*
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d other_2d = (Vector2d) other;
        return this.x == other_2d.x && this.y == other_2d.y;
        //return this.x ==((Vector2d other).x && this.y == ((Vector2d) other).y);
    }
    @Override
    public int hashCode(){return Objects.hash(x,y);}
 */

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


