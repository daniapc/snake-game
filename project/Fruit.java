import java.util.Random;


abstract class Fruit extends Entity {
    
    public static int[][] fruit_map;
    
    public Fruit(){
        super();

        initFruitMap();
        this.born();
    }

    public void initFruitMap(){
        fruit_map = new int[Screen.ROWS][Screen.COLUMNS];
        for (int i = 0; i < Screen.ROWS; i++)
            for (int j = 0; j < Screen.COLUMNS; j++)
                fruit_map[i][j] = 0;
    }

    public void eat(){
        
    }

    public void born(){
        Random rand = new Random(); //instance of random class
        int upperbound = Screen.COLUMNS - 2;
        //generate random values from 0-11
        Coordinate born_coord = new Coordinate();

        while (isNotValid(born_coord)){
            born_coord.x = rand.nextInt(upperbound) + 1;
            born_coord.y = rand.nextInt(upperbound) + 1;
        }

        fruit_map[born_coord.y][born_coord.x] = 1;

        /* 
        for (int i = 0; i < Screen.ROWS; i++){
            for (int j = 0; j < Screen.COLUMNS; j++)
                System.out.print(fruit_map[i][j] + " ");
            System.out.print("\n");
        }

        System.out.print("\n\n");
        */
        
        this.setPosition(born_coord.x, born_coord.y);
    }

    public boolean isNotValid(Coordinate bc){
        if (bc.x == -1)
            return true;
        else if (SnakePart.snake_map[bc.y][bc.x] != 0){
            return true;
        }
        else if (SnakePart.snake_map[bc.y+1][bc.x] == 2 ||
                    SnakePart.snake_map[bc.y-1][bc.x] == 2 ||
                    SnakePart.snake_map[bc.y][bc.x+1] == 2 ||
                    SnakePart.snake_map[bc.y][bc.x-1] == 2){
            return true;
        }
            
        return false;
    }
}