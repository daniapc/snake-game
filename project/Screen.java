import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

// Screen class that inherits from a built-in class in Java
public class Screen extends JPanel implements ActionListener, KeyListener {

    // controls the delay between each tick in ms
    private final int DELAY = 500;
    // controls the size of the board
    public static final int TILE_SIZE = 50;
    public static final int ROWS = 12;
    public static final int COLUMNS = 12;
    // suppress serialization warning
    private static final long serialVersionUID = 490905409104883233L;

    // keep a reference to the timer object that triggers actionPerformed() in
    // case we need access to it in another method
    private Timer timer;
    // objects that appear on the game board
    /* private Player player;
       private ArrayList coins; */

    private int state;
    
    private Game game;
    private Menu menu;

    public static Coordinate[][] board;

    public Screen() {
        // set the game board size
        setPreferredSize(new Dimension(TILE_SIZE * COLUMNS, TILE_SIZE * ROWS));
        // set the game board background color
        setBackground(new Color(232, 232, 232));

        board = new Coordinate[ROWS][COLUMNS];
        initBoard();

        game = new Game();
        game.initGame();

        menu = new Menu();

         // this timer will call the actionPerformed() method every DELAY ms
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // this method is called by the timer every DELAY ms.
        // use this space to update the state of your game or animation
        // before the graphics are redrawn.

        game.updateGame();

        // calling repaint() will trigger paintComponent() to run again,
        // which will refresh/redraw the graphics.
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // when calling g.drawImage() we can use "this" for the ImageObserver 
        // because Component implements the ImageObserver interface, and JPanel 
        // extends from Component. So "this" Board instance, as a Component, can 
        // react to imageUpdate() events triggered by g.drawImage()

        // draw our graphics.
        drawBackground(g);

        game.drawGame(g, this);

        // this smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // this is not used but must be defined as part of the KeyListener interface
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // react to key down events
        game.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // react to key up events
    }
    
    private void drawBackground(Graphics g) {
        // draw a checkered background
        g.setColor(new Color(255, 255, 255));
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                g.fillRect(
                    col * TILE_SIZE, 
                    row * TILE_SIZE, 
                    TILE_SIZE, 
                    TILE_SIZE
                );

            }    
        }
    }

    public static void initBoard(){
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                board[i][j] = new Coordinate();
                board[i][j].y = i*TILE_SIZE;
                board[i][j].x = j*TILE_SIZE; 
            }
        }
    }
}