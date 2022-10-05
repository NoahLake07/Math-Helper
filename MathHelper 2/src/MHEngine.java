import java.util.Arrays;
import java.util.List;

public class MHEngine {

    /**
     * Takes a String and converts it into an array, putting each character into its own array
     * @param stringIn The value that will be converted
     * @param separators The characters that separate the characters into array places
     * @return The converted value
     */
    public static String[] convertStringToArray(String stringIn, String separators){

        // String for separating strings: "( ) , [ ] * "

        // separate string into list depending on separators
        List<String> tempList = Arrays.asList(stringIn.split(separators));

        // create a new pre-populated array based on the size of the list
        String[] array = tempList.stream().toArray(String[]::new);

        return array;
    }

    /**
     * Finds the distance of two given points
     * @param v1 start point
     * @param v2 end point
     * @return a String[] containing the numerical answer, and an answer in radical form
     */
    public static String[] findDistanceOfTwoPoints(Point v1, Point v2){
        // find the differences in x and y
        double difX = (v2.getX()-v1.getX()) * (v2.getX()-v1.getX());
        double difY = (v2.getY()-v1.getY()) * (v2.getY()-v1.getY());

        double d = difX + difY;
        double dSquared = Math.sqrt(d);
        double mX = ((v1.getX()+v2.getX())/2);
        double mY = ((v1.getY()+v2.getY())/2);

        // create the answer strings to be returned
        String mS = mX + ", " + mY + ")";
        String sDiff = "√" + d + " = " + dSquared;

        // return answers
        return new String[]{
                sDiff, mS
        };
    }

    public static void calculateTrig(){

    }

}
