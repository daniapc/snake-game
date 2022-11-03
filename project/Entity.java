import java.awt.*;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

// Abstract Class that wil 
abstract class Entity {
    
    protected BufferedImage image;
    protected Coordinate position;
    protected Coordinate coordinate;

    protected int id;

    public Entity(){
        this.position = new Coordinate();
        this.coordinate = new Coordinate();
    }

    public void setPosition(int x, int y){
        this.position = Game.board[y][x];
        this.coordinate.x = x;
        this.coordinate.y = y;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    } 

    public void drawEntity(Graphics g, ImageObserver observer){
        g.drawImage(
            image, 
            position.x, 
            position.y, 
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