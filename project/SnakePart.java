import java.awt.*;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.event.KeyEvent;

abstract class SnakePart extends Entity {

    protected Coordinate velocity;

    public SnakePart (){
        super();

        try {
            // project folder, otherwise you need to provide the file path.
            image = ImageIO.read(new File("./images/snake.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        // resize de image
        image = scale(image, Screen.TILE_SIZE, Screen.TILE_SIZE);

        velocity = new Coordinate();

        this.setVelocity(0, 0);
    }

    public void setVelocity(int x, int y){
        velocity.x = x;
        velocity.y = y;
    }

    public void move(){

    }
}