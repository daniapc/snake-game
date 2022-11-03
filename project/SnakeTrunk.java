class SnakeTrunk extends SnakePart {

    public SnakeTrunk (){
        super();

        // Trunk Role
        body_role = 2;
    }

    @Override
    public void move(){
        if (front != null){
            if (this.tail == this)
                snake_map[coordinate.y][coordinate.x] = 0;

            Coordinate front_coordinate = front.getCoordinate();

            this.setPosition(front_coordinate.x, front_coordinate.y);  

            snake_map[front_coordinate.y][front_coordinate.x] = 1;
        }

    }
}