/* Justin Farnsworth
 * April 17, 2016
 * Farnswj1.java
 * 
 * This program will create a "creature tank", which consists of "creatures".
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
        
        // Create the shapes used to represent the creature
        outer = new Rectangle(0, 0, 30, 30);
        middle = new Oval(0, 0, 20, 20);
        inner = new Rectangle(0, 0, 10, 10);
        
        // Colors of the shapes
        outer.setFillColor(255, 0, 0);     // Red
        middle.setFillColor(0, 0, 0);      // Black
        inner.setFillColor(255, 255, 255); // White
        
        // Center the shapes
        outer.setCenter(0, 0);
        middle.setCenter(0, 0);
        inner.setCenter(0, 0);
        
        // Move the creature
        outer.translate(X, Y);
        middle.translate(X, Y);
        inner.translate(X, Y);
    }
    
    // Updates visual appearance of creatures
    @Override
    protected void update(ArrayList<Creature> creatures) {
        // Reset the shapes so they can be redrawn
        outer.reset();
        middle.reset();
        inner.reset();
        
        // Move the creatures
        outer.translate(X, Y);
        middle.translate(X, Y);
        inner.translate(X, Y);
        
        // Default outer square settings
        outer.scale(1);
        outer.setFillColor(255, 0, 0); // Red
        
        // Default circle settings
        middle.scale(1);
        middle.setFillColor(0, 0, 0); // Black
        
        // Default inner square settings
        inner.scale(1);
        inner.setFillColor(255, 255, 255); // White
        
        // Checks the distance between other creatures. Changes creatures' appearance if close
        for (int i = 0; i < creatures.size(); i++) {
            // If the creature is close, change its appearance
            if (this != creatures.get(i) && this.creatureDistance(creatures.get(i)) <= 30) {
                // Change outer square
                outer.scale(1.25);
                outer.setFillColor(255, 255, 0); // Yellow
                outer.rotate(Math.PI/4); // Rotate shape 45 degrees
                
                // Change circle
                middle.scale(1.25);
                middle.setFillColor(255, 255, 255); // White
                
                // Change inner square
                inner.scale(1.25);
                inner.setFillColor(0, 255, 255); // Light blue
                
                // Creature's appearance has changed. Stop checking
                return;
            } 
        }
    }
}