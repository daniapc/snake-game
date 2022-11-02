import java.awt.*;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.event.KeyEvent;

class SnakeHead extends SnakePart {

    public SnakeHead (){
        super();
    }

    @Override
    public void move(){
        if (coordinate.x < Screen.COLUMNS-1 && coordinate.y < Screen.ROWS-1 && 
            coordinate.x > 0 && coordinate.y > 0){
            int move_x = coordinate.x + velocity.x;
            int move_y = coordinate.y + velocity.y;
            this.setPosition(move_x, move_y);  
        }      
    }

    public void keyPressed(KeyEvent e) {
        // every keyboard get has a certain code. get the value of that code from the
        // keyboard event so that we can compare it to KeyEvent constants
        int key = e.getKeyCode();
        
        // depending on which arrow key was pressed, we're going to move the player by
        // one whole tile for this input
        if (key == KeyEvent.VK_UP) {
            this.setVelocity(0, -1);
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.setVelocity(1, 0);
        }
        if (key == KeyEvent.VK_DOWN) {
            this.setVelocity(0, 1);
        }
        if (key == KeyEvent.VK_LEFT) {
            this.setVelocity(-1, 0);
        }
    }

}