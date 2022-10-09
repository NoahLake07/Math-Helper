import acm.graphics.GCompound;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;

public class GInput extends GCompound {

    private double width;
    private int height;
    private Color inputBorderColor = new Color(213, 231, 213);
    private GRect border;
    private JLabel label;
    private JFormattedTextField inputField = new JFormattedTextField("");

    /**
     * Constructs a GInput with default sizes/proportions and colors
     * @param x location x
     * @param y location y
     */
    public GInput(double x, double y, GraphicsProgram GParent, String inputLabel){

        // set object values
        width = GParent.getWidth()*0.8;
        height = GParent.getHeight()/10;

        // create colorized input border
        border = new GRect(getWidth() * 0.8, getHeight()/10);
        GParent.add(border, x,y);
        border.sendToBack();
        border.setFilled(true);
        border.setFillColor(inputBorderColor);

        // create input label
        JLabel label = new JLabel(inputLabel);
        GParent.add(label,x,y);

        // create input field
        GParent.add(inputField,width/4,height/2 - inputField.getHeight()/2);
        inputField.setVisible(true);
        inputField.setText("");

    }



}
