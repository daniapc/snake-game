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

}