class SnakeTrunk extends SnakePart {

    public SnakeTrunk (){
        super();

        // Trunk Role
        body_role = 2;
    }

    @Override
    public void move(){
        if (front != null){
            Coordinate front_coordinate = front.getCoordinate();
            this.setPosition(front_coordinate.x, front_coordinate.y);  
        }      
    }
}