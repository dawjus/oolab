package agh.ics.oop;

import java.util.Map;
import java.util.Objects;

public class Animal{
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;

    public Animal(){
        this.orientation =  MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this.orientation =  MapDirection.NORTH;

    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.orientation =  MapDirection.NORTH;
    }


    public void move(MoveDirection direction){
        Vector2d orientationVector = this.orientation.toUnitVector();
        Vector2d new_position = position;
        switch(direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> new_position = this.position.add(orientationVector);
            case BACKWARD -> new_position = this.position.substract(orientationVector);
        }
     //   if (map.canMoveTo(new_position)){
      //      this.position = new_position;
       // }
    }


    public boolean isAt(Vector2d position_check){
        //return  this.position.equals(position);
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
        //return "Position: %s \nDirection: %s".formatted(this.position.toString(), this.orientation.toString());
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

}
