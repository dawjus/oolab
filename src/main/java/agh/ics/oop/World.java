package agh.ics.oop;

import java.util.Arrays;
import java.util.Map;

public class World {
    public static void main(String[] args) {
        Animal animalek = new Animal();
        MoveDirection[] movements = OptionsParser.parse(args);
        for(MoveDirection movement: movements) {
           animalek.move(movement);
        }
        System.out.println(animalek);
    }
}
