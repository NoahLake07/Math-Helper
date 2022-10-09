import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;

/**
 * A header that contains a title and coloration
 */
public class GProgramHeader extends GCompound {

    // global variables
    private String titleS;
    private JLabel title;
    private GRect headerBoundingBox;
    private Color headerColor = new Color(160, 171, 187);
    private int width, height;

    /**
     * Constructs a new program header on the parent program assigned.
     * @param parent the parent program that this belongs to
     * @param t the title string
     */
    public GProgramHeader(GraphicsProgram parent, String t){

        // assign header details
        width = parent.getWidth();
        height = parent.getHeight();
        titleS = t;

        // assign a title
        title = new JLabel(titleS);
        parent.add(title, width/2 - title.getWidth()/2,height/40);
        title.setBounds((width/2-title.getWidth()/2), (int) (height/20),title.getWidth(),title.getHeight());
        title.setVisible(true);

        // create and add the GRect box for the header
        headerBoundingBox = new GRect(width+1,(title.getHeight()) + height/10 + 1);
        add(headerBoundingBox,-1,-1);
        headerBoundingBox.setFilled(true);
        headerBoundingBox.setColor(headerColor);
        headerBoundingBox.sendToBack();

    }

    public void setTitle(String s){
        title.setText(s);
        title.setVisible(true);
    }

    public void setTitleVisible(boolean v){
        title.setVisible(v);
    }

    public void setHeaderColor(Color c){
        headerColor = c;
    }

    public void setSize(int w, int h){
        // update sizes and values
        headerBoundingBox.setBounds(0,0,w,h);
        width = w;
        height = h;

        // set new title bounds
        title.setBounds((width/2-title.getWidth()/2), (int) (height/20),title.getWidth(),title.getHeight());
    }

}
