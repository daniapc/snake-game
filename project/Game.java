import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    private SnakeHead snake_head;
    private SnakeTrunk snake_first_trunk;
    private SnakeTrunk snake_second_trunk;

    public Game(){

    }

    public void initGame(){
        snake_head = new SnakeHead();
        snake_first_trunk = new SnakeTrunk();
        snake_second_trunk = new SnakeTrunk();

        snake_head.setPosition(Screen.COLUMNS/2, Screen.ROWS/2);
        snake_head.setVelocity(1, 0);
        snake_head.setBack(snake_first_trunk);
        snake_head.setTail(snake_second_trunk);

        snake_first_trunk.setPosition(Screen.COLUMNS/2-1, Screen.ROWS/2);
        snake_first_trunk.setFront(snake_head);
        snake_first_trunk.setBack(snake_second_trunk);

        snake_second_trunk.setPosition(Screen.COLUMNS/2-2, Screen.ROWS/2);
        snake_second_trunk.setFront(snake_first_trunk);

    }

    public void updateGame(){
        snake_second_trunk.move();
        snake_first_trunk.move();
        snake_head.move();
    }

    public void drawGame(Graphics g, Screen s){
        snake_head.drawEntity(g, s);
        snake_first_trunk.drawEntity(g, s);
        snake_second_trunk.drawEntity(g, s);
    }

    public void keyPressed(KeyEvent e){
        snake_head.keyPressed(e);
    }
}