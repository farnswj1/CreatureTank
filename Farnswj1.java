/* Justin Farnsworth
 * April 17, 2016
 * Project 03
 * Farnswj1.java
 * 
 * This program will create a "creature tank", which consists of 26 "creatures".
 * The creatures roam freely in the tank, but when close to each other,
 * they will double in size and turn from red and white to yellow and white.
 * 
 * Java Compile & Run Commands:
 * javac -cp +libs/doodlepad.jar Creature.java Farnswj1.java CreatureTank.java
 * java -cp .;+libs/doodlepad.jar CreatureTank
 */

import doodlepad.*;
import java.util.ArrayList;

public class Farnswj1 extends Creature {
    // Instance variables
    private Rectangle outer;
    private Oval middle;
    private Rectangle inner;
    
    // Constructor will create necessary shapes and colors for the "creature".
    public Farnswj1(double width, double height) {
        super(width, height);
        
        this.X = X;
        this.Y = Y;
        
        outer = new Rectangle(0, 0, 30, 30);
        middle = new Oval(0, 0, 20, 20);
        inner = new Rectangle(0, 0, 10, 10);
        
        outer.setFillColor(255, 0, 0);
        middle.setFillColor(0, 0, 0);
        
        outer.setCenter(0, 0);
        middle.setCenter(0, 0);
        inner.setCenter(0, 0);
        
        outer.translate(X, Y);
        middle.translate(X, Y);
        inner.translate(X, Y);
    }
    
    // Updates visual appearance of creatures
    @Override
    protected void update(ArrayList<Creature> creatures) {
        outer.reset();
        middle.reset();
        inner.reset();
        
        outer.translate(X, Y);
        middle.translate(X, Y);
        inner.translate(X, Y);
        
        
        outer.scale(1);
        outer.setFillColor(255, 0, 0);
        
        middle.scale(1);
        middle.setFillColor(0, 0, 0);
        
        inner.scale(1);
        inner.setFillColor(255, 255, 255);
        
        // Tests for distance between other creatures. Changes creatures' appearance if close
        for (int i = 0; i < creatures.size(); i++) {
            if (this == creatures.get(i)) {
                continue;
            } else if (this.creatureDistance(creatures.get(i)) <= 30) {
                outer.scale(1.25);
                outer.setFillColor(255, 255, 0);
                outer.rotate(Math.PI/4);
                
                middle.scale(1.25);
                middle.setFillColor(255, 255, 255);
                
                inner.scale(1.25);
                inner.setFillColor(0, 255, 255);
                
                break;
            } 
        }
    }
}