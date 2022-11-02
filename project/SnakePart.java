abstract class SnakePart extends Entity {

    protected Coordinate velocity;

    public SnakePart (){
        super();

        velocity = new Coordinate();

        this.setVelocity(0, -1);
    }

    public void setVelocity(int x, int y){
        velocity.x = x;
        velocity.y = y;
    }

    public void move(){

    }
}