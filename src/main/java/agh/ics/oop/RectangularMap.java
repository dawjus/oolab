package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private final int width;
    private final int height;
    public final Vector2d lowerLeft_point;
    public final Vector2d upperRight_point;
    public List<Animal> animals = new ArrayList<>();
 //   private MapVisualizer mapVisualizer;
    public RectangularMap(int width, int height){
      //  this.animals = new ArrayList<>();
        this.width = width;
        this.height = height;
        this.lowerLeft_point = new Vector2d(0, 0);
        this.upperRight_point = new Vector2d(width-1, height -1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(lowerLeft_point) && position.follows(upperRight_point);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition()) && canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals){
            if (animal.isAt(position)){
                return true;
            }
        }
        return false;
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

    @Override
    public String toString() {
        return //this.mapVisualizer.draw(lowerLeft_point, upperRight_point);
                new MapVisualizer(this).draw(lowerLeft_point, upperRight_point);
    }

}
