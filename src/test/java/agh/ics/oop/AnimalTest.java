package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {
    Animal animal1 = new Animal();
    Animal animal2 = new Animal();
    Animal animal3 = new Animal();
    Animal animal4 = new Animal();

/*
    @Test
    void move_orientation() {
        animal1.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST,animal1.getOrientation());
        assertEquals(MapDirection.WEST,animal2.getOrientation());
    }
    @Test
    void move_vector() {
        animal1.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,3),animal1.getPosition());
        assertEquals(new Vector2d(2,0),animal2.getPosition());
    }

    @Test
    void move_border() {
        animal3.move(MoveDirection.FORWARD);
        animal3.move(MoveDirection.FORWARD);
        animal3.move(MoveDirection.FORWARD);
        animal3.move(MoveDirection.FORWARD);
        animal4.move(MoveDirection.BACKWARD);
        animal4.move(MoveDirection.BACKWARD);
        animal4.move(MoveDirection.BACKWARD);
        animal4.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,4),animal3.getPosition());
        assertEquals(new Vector2d(2,0),animal4.getPosition());
    }
/*
    String[] correct_data = new String[] {"f","b","forward", "backward", "right", "r", "left", "l"};
    String[] correct_and_fail_data = new String[] {"f", "dawid", "123", "right"};
    MoveDirection[] excepted_correct_data= new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD
            , MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT,
            MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT};
    MoveDirection[] check_correct_and_fail_data= new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD};
    String[] data1 = new String[] {"f"};
    @Test
    void input_data() {
        assertEquals(new MoveDirection[] {MoveDirection.FORWARD} ,OptionsParser.parse(data1));
        assertEquals(excepted_correct_data, OptionsParser.parse(correct_data));
    }
*/

}