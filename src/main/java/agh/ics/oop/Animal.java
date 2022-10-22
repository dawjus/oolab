package agh.ics.oop;

import java.util.Map;
import java.util.Objects;

public class Animal {
    private final Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;
    public void move(MoveDirection direction){
        if (direction==MoveDirection.LEFT){
            orientation = MapDirection.WEST;
        }
        else if (direction ==MoveDirection.RIGHT) {
            orientation = MapDirection.EAST;
        }
        else if (direction==MoveDirection.FORWARD  && position.getY()<4) {
            position.setY(position.getY() +1);
        }
        else if (direction==MoveDirection.BACKWARD && position.getY()>0){
            position.setY(position.getY() -1);
        }
    }


    boolean isAt(Vector2d position){
        return  this.position.equals(position);
    }

    /* Odp na pytanie 10:
        Stworzyłbym tablicę w któej trzymałbym wszytskie zwierzątka i funkcją isAt porównywał bym zwierzatko,
        które chce przesunać (wywołujac funkcje move) z pozostałymi lub tablice dwumiarową o wymiarach planszy dla zwierzaków
        i wypełnił ją wartościami False, gdyby wykonywała sie funkcja move sprawdzłąym czy dane pole jest False czy True
        jak True to nie ide jak False to ide i zmieniam pole na True
     */
    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }


    @Override
    public String toString(){
        return "Position: %s \nDirection: %s".formatted(this.position.toString(), this.orientation.toString());
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
