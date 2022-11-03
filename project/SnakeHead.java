import java.awt.*;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.event.KeyEvent;

class SnakeHead extends SnakePart {

    private Coordinate velocity;

    public SnakeHead (){
        super();

        velocity = new Coordinate();
        // Head Role
        body_role = 1;

        this.setVelocity(0, 0);
    }

    public void setVelocity(int x, int y){
        velocity.x = x;
        velocity.y = y;
    }

    @Override
    public void move(){
        if (coordinate.x < Screen.COLUMNS-1 && coordinate.y < Screen.ROWS-1 && 
            coordinate.x > 0 && coordinate.y > 0){
            int move_x = coordinate.x + velocity.x;
            int move_y = coordinate.y + velocity.y;

            if (snake_map[move_y][move_x] == 1)
                Main.close();

            this.setPosition(move_x, move_y);

            snake_map[move_y][move_x] = 2;            
        }
        else {
            Main.close();
        }
    }

    public void keyPressed(KeyEvent e) {
        // every keyboard get has a certain code. get the value of that code from the
        // keyboard event so that we can compare it to KeyEvent constants
        int key = e.getKeyCode();
        
        // depending on which arrow key was pressed, we're going to move the player by
        // one whole tile for this input
        if (key == KeyEvent.VK_UP) {
            if (velocity.y != 1)
                this.setVelocity(0, -1);
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (velocity.x != -1)
                this.setVelocity(1, 0);
        }
        if (key == KeyEvent.VK_DOWN) {
            if (velocity.y != -1)
                this.setVelocity(0, 1);
        }
        if (key == KeyEvent.VK_LEFT) {
            if (velocity.x != 1)
                this.setVelocity(-1, 0);
        }
    }

}