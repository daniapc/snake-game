import javax.swing.*;

// Class that allows creating a window and a screen for it. 
// Source: https://learncodebygaming.com/blog/how-to-make-a-video-game-in-java-2d-basics
class Main {

    private static Screen screen;
    private static JFrame window;

    public Main(){

    }

    private static void initWindow() {
        // create a window frame and set the title in the toolbar
        window = new JFrame("Snake Game");
        // when we close the window, stop the app
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the jpanel to draw on.
        // this also initializes the game loop
        screen = new Screen();
        // add the jpanel to the window
        window.add(screen);
        // pass keyboard inputs to the jpanel
        window.addKeyListener(screen);
        
        // don't allow the user to resize the window
        window.setResizable(true);
        // fit the window size around the components (just our jpanel).
        // pack() should be called after setResizable() to avoid issues on some platforms
        window.pack();
        // open window in the center of the screen
        window.setLocationRelativeTo(null);
        // display the window
        window.setVisible(true);
    }

    public static void main(String[] args) {
        // invokeLater() is used here to prevent our graphics processing from
        // blocking the GUI. https://stackoverflow.com/a/22534931/4655368
        // this is a lot of boilerplate code that you shouldn't be too concerned about.
        // just know that when main runs it will call initWindow() once.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initWindow();
            }
        });
    }

    public static void close(){
        window.dispose();
        System.exit(0);
    }
}