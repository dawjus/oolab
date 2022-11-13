package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class GrassField extends AbstractWorldMap {
    private int countGrass;
    private final int maxSize;
    protected List<Grass> grasses = new ArrayList<>();
    private Vector2d  lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private Vector2d  upperRight = new Vector2d(0,0);
    private MapVisualizer map = new MapVisualizer(this);
    public GrassField(int count) {
        this.countGrass = count;
        this.maxSize = (int) Math.sqrt(10 * count);
        for (int i =0; i<count; i++) {
            int randX = (int) (Math.random() * maxSize);
            int randY = (int) (Math.random() * maxSize);
            Vector2d position = new Vector2d(randX, randY);
            Grass grass = new Grass(position);
            if (!isOccupied(position)) {
                grasses.add(grass);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) {
            return object;
        }
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    public Vector2d getLowerLeft() {
        for (Animal animal : animals) {
            lowerLeft = lowerLeft.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grasses) {
            lowerLeft = lowerLeft.lowerLeft(grass.getPosition());
        }
        return lowerLeft;
    }

    @Override
    public Vector2d getUpperRight() {
        for (Animal animal : animals) {
            upperRight = upperRight.upperRight(animal.getPosition());
        }
        for (Grass grass : grasses) {
            upperRight = upperRight.upperRight(grass.getPosition());
        }
        return upperRight;
    }

    public String toString(){
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }

}