package bugs.bug_6_Polygon_containc_method_does_not_work_correctly;


import java.awt.*;

public class PolygonTest {
    public static void main(String[] args) {
        int[] xPoints = {-2, 2, 2, -2};
        int[] yPoints = {2, 2, -2, -2};

        Polygon polygon = new Polygon(xPoints, yPoints, xPoints.length);
        boolean checkPoint = polygon.contains(1, 1);
        System.out.print(checkPoint);//why false?) -> should be true))
        //нарушен порядок задания координат точек
        //описанная фигура описывала песочные часы, а не квадрат
    }
}
