import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    public SnakeHead snake_head;

    public Game(){

    }

    public void initGame(){
        snake_head = new SnakeHead();

        snake_head.setPosition(Screen.COLUMNS/2, Screen.ROWS/2);
        snake_head.setVelocity(1, 0);
    }

    public void updateGame(){
        snake_head.move();
    }

    public void drawGame(Graphics g, Screen s){
        snake_head.drawEntity(g, s);
    }

    public void keyPressed(KeyEvent e){
        snake_head.keyPressed(e);
    }
}