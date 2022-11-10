package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    public List<Animal> animals = new ArrayList<>();
    public IWorldMap map;
    public MoveDirection[] directions;
    public Vector2d[] startPositions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] startPositions) {
        this.map = map;
        this.directions = directions;
    //    this.animals = new ArrayList<>();
        this.startPositions = startPositions;
        for (Vector2d position : startPositions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animals.add(animal);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < this.directions.length; i++) {
            System.out.println(animals);
            animals.get(i % animals.size()).move(directions[i]);
            System.out.println(map);
        }
    }
}
