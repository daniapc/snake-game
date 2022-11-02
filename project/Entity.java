import java.awt.*;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

// Abstract Class that wil 
/* abstract */ class Entity {
    
    protected BufferedImage image;

    public Entity(){

        try {
            // project folder, otherwise you need to provide the file path.
            image = ImageIO.read(new File("./images/snake.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        // resize de image
        image = scale(image, 50, 50);
    }

    public void drawEntity(Graphics g, ImageObserver observer){
        
        g.drawImage(
            image, 
            50, 
            50, 
            observer
        ); 
    }

    // Resizing image method. Source: https://stackoverflow.com/questions/9417356/bufferedimage-resize
    public BufferedImage scale(BufferedImage src, int w, int h)
    {
        // A new image is created and the width and height of the last are stored
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();

        // For each frame of the image is created a new one with the data of the last for the new image
        int[] ys = new int[h];
        for (y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }
}