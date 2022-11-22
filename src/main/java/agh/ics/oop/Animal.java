package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Animal{
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;
    protected List<IPositionChangeObserver> observers = new ArrayList<IPositionChangeObserver>();

    public Animal(){
        this(null);
    }

    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.orientation =  MapDirection.NORTH;
        this.map = map;
    }


    public void move(MoveDirection direction){
        Vector2d orientationVector = this.orientation.toUnitVector();
        Vector2d newPosition = position;
        switch(direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> newPosition = this.position.add(orientationVector);
            case BACKWARD -> newPosition = this.position.substract(orientationVector);
        }
        if (map.canMoveTo(newPosition)){
            this.position = newPosition;
        }
    }


    public boolean isAt(Vector2d position_check){
        return Objects.equals(this.position, position_check);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }


    @Override
    public String toString(){
        return switch (this.orientation){
            case NORTH -> "N";
            case WEST -> "W";
            case EAST -> "E";
            case SOUTH -> "S";
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(position, animal.position) && orientation == animal.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }


    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
