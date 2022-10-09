public class Triangle {

    private Leg lA, lB, lC;

    /**
     * Constructs a triangle with three given legs
     * @param a Leg a
     * @param b Leg b
     * @param c Leg c
     */
    public Triangle(Leg a, Leg b, Leg c){
        lA = a;
        lB = b;
        lC = c;
    }

    /**
     * Constructs a triangle with an existing triangle
     * @param t triangle
     */
    public Triangle(Triangle t){
        lA = t.getLegA();
        lB = t.getLegB();
        lC = t.getLegC();
    }

    public Leg getLegA() {
        return lA;
    }

    public Leg getLegB() {
        return lB;
    }

    public Leg getLegC() {
        return lC;
    }

    public Leg getHypotenuse(){
        if(lC.getLength() > lA.getLength() && lC.getLength() > lB.getLength()){
            return lC;
        } else if (lB.getLength() > lA.getLength() && lB.getLength() > lC.getLength()){
            return lB;
        } else if (lA.getLength() > lB.getLength() && lA.getLength() > lC.getLength()){
            return lA;
        } else {
            return null;
        }
    }

    public double getHypotenuseLength(){
        return getHypotenuse().getLength();
    }

    public Leg getShortLeg(){
        if(lC.getLength() < lA.getLength() && lC.getLength() < lB.getLength()){
            return lC;
        } else if (lB.getLength() < lA.getLength() && lB.getLength() < lC.getLength()){
            return lB;
        } else if (lA.getLength() < lB.getLength() && lA.getLength() < lC.getLength()){
            return lA;
        } else {
            return null;
        }
    }

    public double getShortLegLength(){
        return getShortLeg().getLength();
    }

    public Leg getLongLeg(){
        if(lC.getLength() < getHypotenuse().getLength() && lC.getLength() > lA.getLength()){
            return lC;
        } else if (lA.getLength() < getHypotenuse().getLength() && lA.getLength() > lB.getLength()){
            return lA;
        } else if (lB.getLength() < getHypotenuse().getLength() && lB.getLength() > lC.getLength()){
            return lB;
        } else {
            return null;
        }
    }

}
