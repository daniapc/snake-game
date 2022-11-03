
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

class FruitIncrease extends Fruit {

    public FruitIncrease (){
        super();

        try {
            // project folder, otherwise you need to provide the file path.
            image = ImageIO.read(new File("./images/fruit-increase.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        // resize de image
        image = scale(image, Screen.TILE_SIZE, Screen.TILE_SIZE);
    }

    @Override
    public void eat(){
 
             
    }

}