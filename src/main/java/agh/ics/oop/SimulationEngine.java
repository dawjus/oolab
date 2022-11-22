package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    public IWorldMap map;
    public MoveDirection[] directions;
    public Vector2d[] startPositions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] startPositions) {
        this.map = map;
        this.directions = directions;
        this.startPositions = startPositions;
        for (Vector2d position : startPositions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animal.addObserver((IPositionChangeObserver) map);
        }
    }

    @Override
    public void run() {
        int i =0;
        while (i < directions.length) {
            for (Animal a : ((AbstractWorldMap) map).getAnimals()) {
                if (i == directions.length) break;
                a.move(directions[i]);
                i++;
            }
        }
        System.out.println(map);
    }
}
