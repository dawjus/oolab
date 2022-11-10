package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    public final Vector2d lowerLeftPoint;
    public final Vector2d upperRight_point;
    public List<Animal> animals = new ArrayList<>();
    private MapVisualizer mapVisualizer;
    public RectangularMap(int width, int height){
      //  this.animals = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
        this.lowerLeftPoint = new Vector2d(0, 0);
        this.upperRight_point = new Vector2d(width-1, height -1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(lowerLeftPoint)
                && position.follows(upperRight_point)
                && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!= null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }
/*
    @Override
    public Object objectAt(Vector2d position) {
        return animals.stream()
                   .filter(animal -> animal.isAt(position))
                   .findFirst()
                   .orElse(null);
    }
    */

    @Override
    public String toString() {
        return this.mapVisualizer.draw(lowerLeftPoint, upperRight_point);
        //new MapVisualizer(this).draw(lowerLeftPoint, upperRight_point);
    }

}
