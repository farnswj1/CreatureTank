/* Justin Farnsworth
 * April 17, 2016
 * Project 03
 * Creature.java
 * 
 * This program will create a "creature tank", which consists of 26 "creatures".
 * The creatures roam freely in the tank, but when close to each other,
 * they will double in size and turn from red and white to yellow and white.
 * 
 * Java Compile & Run Commands:
 * javac -cp +libs/doodlepad.jar Creature.java Farnswj1.java CreatureTank.java
 * java -cp .;+libs/doodlepad.jar CreatureTank
 */

import java.util.Random;
import java.util.ArrayList;

public abstract class Creature {
    // Creature translation distance
    protected double X;
    protected double Y;
    
    // Target coordinates
    protected double targetX;
    protected double targetY;
    
    // Tank dimensions
    protected double width;
    protected double height;
    
    public Creature(double width, double height) {
        // Save tank size
        this.width = width;
        this.height = height;
        
        // Start at a random location
        Random rnd = new Random();
        X = width*rnd.nextDouble();
        Y = height*rnd.nextDouble();

        // Compute new target location
        setNewTarget();
    }
    
    // Advance the creature animation
    public void advance(ArrayList<Creature> creatures) {
        // Move closer to target
        stepTowardTarget();
        
        // Update visual appearance of creature
        update(creatures);
        
        // If near target, reset target location
        if (targetDistance() < 100) {
            setNewTarget();
        }
    }

    // Move incremently to the target
    protected void stepTowardTarget() {
        // Translate Creature closer to target
        double dX = targetX - X;
        double dY = targetY - Y;
        
        X = X + 0.01*dX;
        Y = Y + 0.01*dY;
    }
    
    // Compute the distance to the target
    private double targetDistance() {
        double dX = targetX - X;
        double dY = targetY - Y;
        double dist = Math.sqrt(dX*dX + dY*dY);
        return dist;
    }
    
    // Randomly choose a new target location
    private void setNewTarget() {
        Random rnd = new Random();
        targetX = width*rnd.nextDouble();
        targetY = height*rnd.nextDouble();
    }
    
    // Compute the distance to another creature
    public double creatureDistance(Creature other) {
        double dX = this.X - other.X;
        double dY = this.Y - other.Y;
        double dist = Math.sqrt(dX*dX + dY*dY);
        return dist;
    }

    // Update visual appearance of creature
    protected abstract void update(ArrayList<Creature> creatures);
}
