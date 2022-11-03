import java.awt.*;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.event.KeyEvent;

abstract class SnakePart extends Entity {

    protected static int body_size;

    protected int body_role;

    protected SnakePart front;
    protected SnakePart back;
    protected static SnakePart tail;

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

        body_role = 0;
        front = null;
        back = null;

    }

    // Virtual method
    public void move(){

    }

    // Pointer to front part
    public void setFront(SnakePart f){
        front = f;
    }
    // Pointer to back part
    public void setBack(SnakePart b){
        back = b;
    }

    // Pointer to static tail
    public static void setTail(SnakePart t){
        tail = t;
    }
}