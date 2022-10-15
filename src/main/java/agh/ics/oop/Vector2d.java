package agh.ics.oop;

import java.security.KeyStore;

public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean precedes(Vector2d other){
        return other.x <= x && other.y <= y;
    }

    public boolean follows(Vector2d other){
        return other.x >= x && other.y >= y;
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(x+other.x,y +other.y);
    }

    public Vector2d substract(Vector2d other){
        return new Vector2d(x-other.x,y -other.y);
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(other.x, x), Math.max(other.y, y));
    }
    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(other.x, x), Math.min(other.y, y));
    }

    public Vector2d opposite(){
        return new Vector2d(-x, -y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d other_2d = (Vector2d) other;
        return this.x == other_2d.x && this.y == other_2d.y;
    }
    @Override
    public String toString(){
        return "(%d, %d)".formatted(x,y);
    }
}

