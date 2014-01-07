package sokoban1;
 
import java.awt.event.KeyEvent;
 
import acm.graphics.GImage;
import acm.program.GraphicsProgram;
 
public class SampleGraphicsProgram extends GraphicsProgram {
    // This example is useful for task 2, alternative 2, but not required for any other parts of the exercise
    
    @Override
    public void init() {
        addKeyListeners(); // This is required for listening to key events
        exampleWall = new GImage("sokoban/wall16x16.png"); // Using the wall image as a part of this example
        exampleBlank = new GImage("sokoban/blank16x16.png"); // Using the blank image as a part of this example
    }
   
    GImage exampleWall;
    GImage exampleBlank;
   
    @Override
    public void run() {
        // Not much happening in this example
    }
   
    @Override
    public void keyPressed(KeyEvent event) {
        int key;
        if (Character.isLetter(event.getKeyChar())) // If the KeyEvent is a character, retrieve it
            key = event.getKeyChar();
        else // If not, get the code for the key (examples: arrow right, arrow up...)
            key = event.getKeyCode();
       
        switch (key) { // Handle the various keys pressed
       
        case 'w': // If 'w' was pressed...
            add(exampleWall, 0, 0); // Draw a wall at coordinates [0,0]
            break;
        case KeyEvent.VK_UP: // If the arrow up was pressed...
            add(exampleBlank, 0, 0); // Draw a blank square at coordinates [0,0]
            break;
           
            // For this example all other key presses are not considered at all
            // For Sokoban you would normally consider W, A, S, D or arrows up, left, down, right.
        }
    }
}