import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    private SnakeHead snake_head;
    private SnakeTrunk snake_first_trunk;
    private SnakeTrunk snake_second_trunk;

    private FruitIncrease fruit_increase;

    public static Coordinate[][] board;

    public Game(){

        board = new Coordinate[Screen.ROWS][Screen.COLUMNS];
        initBoard();

    }

    public void initGame(){
        initSnake();

        fruit_increase = new FruitIncrease();     
    }

    public void updateGame(){

        SnakePart cursor = SnakePart.getTail();
        while (cursor != null){
            cursor.move();
            cursor = cursor.getFront();
        }
        

        if (snake_head.getCoordinate().x == fruit_increase.getCoordinate().x &&
            snake_head.getCoordinate().y == fruit_increase.getCoordinate().y)
            fruit_increase.eat();
    }

    public void drawGame(Graphics g, Screen s){
        
        fruit_increase.drawEntity(g, s);
        
        SnakePart cursor = SnakePart.getTail();
        while (cursor != null){
            cursor.drawEntity(g, s);
            cursor = cursor.getFront();
        }
    }

    public void keyPressed(KeyEvent e){
        snake_head.keyPressed(e);
    }

    // For each position in the multidimentional array is assigned a coordinate
    private static void initBoard(){
        for (int i = 0; i < Screen.ROWS; i++){
            for (int j = 0; j < Screen.COLUMNS; j++){
                board[i][j] = new Coordinate();
                board[i][j].y = i*Screen.TILE_SIZE;
                board[i][j].x = j*Screen.TILE_SIZE; 
            }
        }
    }

    private void initSnake(){
        SnakePart.initSnakeMap();
        SnakePart.snake_map[Screen.ROWS/2][Screen.COLUMNS/2] = 1;
        SnakePart.snake_map[Screen.ROWS/2][Screen.COLUMNS/2-1] = 1;
        SnakePart.snake_map[Screen.ROWS/2][Screen.COLUMNS/2-2] = 1;
        
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
}