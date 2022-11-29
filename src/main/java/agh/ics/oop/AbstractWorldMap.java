package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }
    protected List<IPositionChangeObserver> observers = new ArrayList<>();
    protected abstract Vector2d getLowerLeft();

    protected abstract Vector2d getUpperRight();

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : getAnimals()) {
            if (animal.isAt(position)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }
    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (canMoveTo(animalPosition)) {
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }



    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (!newPosition.equals(oldPosition)) {
            Animal animal = animals.remove(oldPosition);
            animals.put(newPosition, animal);
        }
    }
    public String toString() {
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}