package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.Arrays;
import java.util.Map;

public class World {
    public static void main(String[] args) {
        try{
            Application.launch(App.class, args);
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
}