package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;


public class App extends Application {
    private GrassField map;
    @Override
    public void init() throws Exception {
        Parameters parameters = getParameters();
        System.out.println(parameters.getRaw());
        List<String> argsTemp = parameters.getRaw();
        String[] args = argsTemp.toArray(new String[0]);

        try {
            OptionsParser optionParser = new OptionsParser();
            MoveDirection[] directions = optionParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }
    }

    public void start(Stage primaryStage) throws Exception {
        Label leftCorner = new Label("y/x");
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 400, 400);
        int leftX = this.map.getLowerLeft().getX();
        int leftY = this.map.getLowerLeft().getY();
        int rightX = this.map.getUpperRight().getX();
        int rightY =  this.map.getUpperRight().getY();

        GridPane.setHalignment(leftCorner, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(30));
        gridPane.getRowConstraints().add(new RowConstraints(30));
        gridPane.add(leftCorner, 0, 0, 1, 1);

        for (int i = leftX+1; i <rightX; i++){
            gridPane.add(new Label(Integer.toString(i-1)), i, 0);
            gridPane.getRowConstraints().add(new RowConstraints(20));
            gridPane.add(new Label(Integer.toString(rightY -i-1)), 0, i);
            gridPane.getColumnConstraints().add(new ColumnConstraints(20));
        }
        for (int i = leftX; i <rightX; i++){
            for (int j = leftY; j <rightY; j++) {
                Vector2d position = new Vector2d(i, j);
                if (this.map.isOccupied(position)) {
                    Object worldMapElement = this.map.objectAt(position);
                    Label labelAnimal = new Label(worldMapElement.toString());
                    GridPane.setHalignment(labelAnimal, HPos.CENTER);
                    gridPane.add(labelAnimal, position.getX() + 1,
                            rightY - position.getY() - 1, 1, 1);
                }
            }
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
