package agh.ics.oop;

import java.util.Arrays;
import java.util.Map;

public class World {
    public static Direction[] change(String[] directions){
        Direction[] tab = new Direction[directions.length];
        for(int i = 0; i < directions.length; i++) {
            switch(directions[i]){
                case "f" ->tab[i]= Direction.FORWARD;
                case "b" ->tab[i]= Direction.BACKWARD;
                case "l" -> tab[i]=Direction.LEFT;
                case "r" ->tab[i]= Direction.RIGHT;
            }
            }
        return tab;
    }
    public static void run(Direction[] directions){
        for(Direction direction: directions){
            if (direction!= null) {
                String message = switch (direction) {
                    case LEFT -> "Zwierzak skreca w lewo";
                    case RIGHT -> "Zwierzak skreca w prawo";
                    case BACKWARD -> "Zwierzak idzie do tylu";
                    case FORWARD -> "Zwierzak idzie prosto";
                };
                System.out.println(message);
            }
            else {
                System.out.println("Nieznana komenda");
            }
        }
    }

    public static void main(String[] args) {
     //   System.out.println("Start");
     //   Direction[] tab = World.change(args);
     //   World.run(Arrays.copyOfRange(tab, 0, tab.length));
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(MapDirection.EAST.next());
        //System.out.println(vector.toString());
    //    System.out.println("Stop");
    }
}
