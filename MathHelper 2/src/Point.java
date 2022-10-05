/**
 * Stores an x and y position in a single object, while containing helpful methods
 * to help calculating certain equations
 */
public class Point {

    double x, y;

    /**
     * Create a point using values of x and y
     * @param pX
     * @param pY
     */
    public Point(double pX, double pY){
        x = pX;
        y = pY;
    }

    /**
     * Create a new point using an existing point
     * @param point
     */
    public Point(Point point){
        x = point.getX();
        y = point.getY();
    }

    /**
     * Takes a point and dilates (scales) the points
     * @param d the dilation amount
     */
    public void dilate(double d){
        x = x * d;
        y = y * d;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}
