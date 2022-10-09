import javax.swing.text.html.MinimalHTMLWriter;

/**
 * Stores two points as a leg
 */
public class Leg {

    private Point lA, lB;

    /**
     * Constructs a leg using two custom points
     * @param a Point a for leg
     * @param b Point b for leg
     */
    public Leg(Point a, Point b){
        lA = a;
        lB = b;
    }

    /**
     * Constructs a leg using an existing leg
     * @param leg
     */
    public Leg(Leg leg){
        lA = leg.getPointA();
        lB = leg.getPointB();
    }

    public Point getPointA(){
        return lA;
    }

    public Point getPointB(){
        return lB;
    }

    public double getLength(){
        return Double.valueOf(MHEngine.findDistanceOfTwoPoints(lA,lB)[0]);
    }
}
