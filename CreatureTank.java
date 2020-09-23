/* Justin Farnsworth
 * April 17, 2016
 * CreatureTank.java
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
import java.util.Timer;

public class CreatureTank extends Pad {
    // Array holds the creatures
    private ArrayList<Creature> creatures;
    
    // Constructor
    public CreatureTank(int width, int height, int numCreatures) {
        super(width, height);
        setBackground(0, 0, 150);
        
        // Create creatures
        creatures = new ArrayList<>();
        for (int i = 0; i < numCreatures; i++) {
            creatures.add(i, new Farnswj1(width, height));
        }
        
        // Handle tick event and start time
        setTickRate(30);
        startTimer();
    }
    
    public void onTick(long when) {
        for (int i = 0; i < creatures.size(); i++) {
            Creature c = creatures.get(i);
            //reset();
            c.advance(creatures);
        }
    }
    
    // Executes program
    public static void main(String[] args) {
        new CreatureTank(1000, 600, 26);
    }
}
