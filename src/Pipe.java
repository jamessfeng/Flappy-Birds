import java.awt.*;

public class Pipe{
//    int height1, height2;
    Point point1, point2;
    public Pipe(int x, int y){
        point1 = new Point(x, y);
    }
    public void movement(){
        point1 = new Point(point1.x - 1, point1.y);
    }
}
