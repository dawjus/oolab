package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    public List<Animal> animals = new ArrayList<>();
    public IWorldMap map;
    public MoveDirection[] directions;
    public Vector2d[] start_positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] start_positions) {
        this.map = map;
        this.directions = directions;
    //    this.animals = new ArrayList<>();
        this.start_positions = start_positions;
        for (Vector2d position : start_positions) {
            Animal animal = new Animal(map, position);
            animals.add(animal);
            //if (map.canMoveTo(position) && map.isOccupied(position)) {
              //  map.place(animal);
               // this.animals.add(animal);
                // }
            //}
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < this.directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);
        }
        System.out.println(map);
    }
}
