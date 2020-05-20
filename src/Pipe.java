import java.awt.*;

public class Pipe{
//    int height1, height2;
    Point point1, point2;
    public Pipe(int x, int y1, int y2){
        // y1 is the bound to get over, and y2 is the bound to get under
        // so y1 < y2 and bird's y must be in the middle
        point1 = new Point(x, y1);
        point2 = new Point(x, y2);
    }
    public void movement(){
        point1 = new Point(point1.x - 1, point1.y);
        point2 = new Point(point2.x - 1, point2.y);
    }
}
