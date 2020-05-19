import java.awt.*;

public class Bird {
    public Point point;
    public int velocity = 0;
    public Bird(int x, int y){
        point = new Point(x,y);
    }
    public void movement(){
//        System.out.println(velocity);
        if (point.y < 0){
            point = new Point(point.x, 0);
        }
        else if (point.y > 300){
            point = new Point(point.x, 300);
        }
        else{
            falling();
            point = new Point(point.x, point.y - velocity);
        }
    }
    public void jump(){
        velocity = 10;
    }
    public void falling(){
        if (velocity > -10){
            velocity -= 1;
        }
    }
    public boolean collided(){
//        for ()
        Game game = Game.game;
        Point pipePoint = game.pipe.point1;
        if (point.x + Game.xScale == pipePoint.x && point.y >= pipePoint.y){
            return true;
        }
        return false;
    }

}
