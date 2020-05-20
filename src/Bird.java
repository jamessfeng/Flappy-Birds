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
        else if (point.y > Game.height -50){
            point = new Point(point.x, Game.height - 50);
//            System.out.println(point.y);
        }
        else{
            falling();
            point = new Point(point.x, point.y - velocity);
        }
    }
    public void jump(){
        velocity = 8;
    }
    public void falling(){
        if (velocity > -10){
            velocity -= 1;
        }
    }
    public boolean collided(){
//        for ()
        Game game = Game.game;
        if (game.pipeList.isEmpty()){
            return false;
        }
        Point pipePoint1 = game.pipeList.get(0).point1;
        if (point.x + Game.xScale == pipePoint1.x && point.y >= pipePoint1.y){
            return true;
        }
        Point pipePoint2 = game.pipeList.get(0).point2;
        if (point.x + Game.xScale == pipePoint2.x && point.y < pipePoint2.y){
            return true;
        }
        return false;
    }

}
