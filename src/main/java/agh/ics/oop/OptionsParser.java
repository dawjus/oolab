package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] directions) {
        int counter = 0;
        for (String direction : directions) {
            if (direction.equals("f") || direction.equals("forward") || direction.equals("b") ||
                    direction.equals("backward") || direction.equals("l") || direction.equals("left") ||
                    direction.equals("right") || direction.equals("r")) {
                counter += 1;
            }
            else{
                throw new IllegalArgumentException(direction + " is not legal move specification");
            }
        }
        MoveDirection[] movements = new MoveDirection[counter];
        int k = 0;
        for (String direction : directions) {
            switch (direction) {
                case "f", "forward" -> movements[k] = MoveDirection.FORWARD;
                case "b", "backward" -> movements[k] = MoveDirection.BACKWARD;
                case "l", "left" -> movements[k] = MoveDirection.LEFT;
                case "r", "right" -> movements[k] = MoveDirection.RIGHT;
                default -> k -= 1;
            }
            k += 1;
        }
        return movements;
    }


}
