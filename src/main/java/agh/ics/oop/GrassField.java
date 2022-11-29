package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    private final int maxSize;
  //  protected List<Grass> grasses = new ArrayList<>();
    protected Map<Vector2d, Grass> grasses = new HashMap<Vector2d, Grass>();
    private MapVisualizer map = new MapVisualizer(this);

    protected List<Grass> getGrasses() {
        return new ArrayList<>(grasses.values());
    }
    public GrassField(int count) {
        this.maxSize = (int) Math.sqrt(10 * count);
        for (int i =0; i<count; i++) {
            int randX = (int) (Math.random() * maxSize);
            int randY = (int) (Math.random() * maxSize);
            Vector2d position = new Vector2d(randX, randY);
            Grass grass = new Grass(position);
            if (!isOccupied(position)) {
                grasses.put(position, grass);
            }
        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) {
            return object;
        }
        for (Grass grass : getGrasses()) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return grasses.containsKey(position) || super.isOccupied(position);
    }
    @Override
    public Vector2d getLowerLeft() {
        Vector2d  lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal : animals.values()) {
            lowerLeft = lowerLeft.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grasses.values()) {
            lowerLeft = lowerLeft.lowerLeft(grass.getPosition());
        }
        return lowerLeft;
    }

    @Override
    public Vector2d getUpperRight() {
        Vector2d  upperRight = new Vector2d(0,0);
        for (Vector2d position : animals.keySet()) {
            upperRight = upperRight.upperRight(position);
        }
        for (Grass grass : getGrasses()) {
            upperRight = upperRight.upperRight(grass.getPosition());
        }
        return upperRight;
    }

    public String toString(){
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }

}