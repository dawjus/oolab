package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public abstract Vector2d getLowerLeft();

    public abstract Vector2d getUpperRight();

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (canMoveTo(animalPosition)) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
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

    public String toString() {
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}