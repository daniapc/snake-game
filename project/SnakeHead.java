import java.awt.*;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

class SnakeHead extends SnakePart {

    public SnakeHead (){
        super();

        try {
            // project folder, otherwise you need to provide the file path.
            image = ImageIO.read(new File("./images/snake.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        // resize de image
        image = scale(image, 50, 50);
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

}