import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicTrig extends GraphicsProgram {

    JFormattedTextField input = new JFormattedTextField("                           ");

    JLabel answer = new JLabel("<html>  </html>");

    public void init(){
        windowUISetup();
        createInputGRectBorders();
        createInputFields();
        createJButtons();
    }

    private void windowUISetup(){
        // rename the calculator window
        setTitle("MathHelper Calculator Window");

        // resize the window
        Dimension windowBound = new Dimension(300,300);
        this.setSize(windowBound);

        // hide menu bar
        this.getMenuBar().setVisible(false);

        // create header coloration
        GRect headerColor = new GRect(getWidth()+1,getHeight()/5+1);
        add(headerColor,-1,-1);
        headerColor.setFilled(true);
        headerColor.setColor(new Color(160, 171, 187));
        headerColor.sendToBack();

        // create the calculator JLabel
        JLabel calcLabel = new JLabel("<html>Basic Trig Calculator</html>");
        add(calcLabel, getWidth()/2 - calcLabel.getWidth()/2,getHeight()/40);
        calcLabel.setBounds(getWidth()/2-calcLabel.getWidth()/2,getHeight()/20,calcLabel.getWidth(),calcLabel.getHeight());

        // add the answer JLabel
        add(answer,getWidth() * 0.1,getHeight()/2 + getHeight()/4);
        answer.setBounds(answer.getX(),answer.getY(),1000,answer.getHeight());
    }

    private void createInputGRectBorders(){
        // create input GRect border1
        GRect border = new GRect((double) getWidth() * 0.8, getHeight()/10);
        add(border, getWidth()*0.1,(getHeight()/40)*12);
        border.sendToBack();
        border.setFilled(true);
        border.setFillColor(new Color(213, 231, 213));

        // create input GRect border2
        GRect border2 = new GRect((double) getWidth() * 0.8, getHeight()/10);
        add(border2, getWidth()*0.1,(getHeight()/40)*18);
        border2.sendToBack();
        border2.setFilled(true);
        border2.setFillColor(new Color(213, 231, 231));

        // create input GRect border3
        GRect border3 = new GRect((double) getWidth() * 0.8, getHeight()/10);
        add(border3, getWidth()*0.1,(getHeight()/40) * 18);
        border3.sendToBack();
        border3.setFilled(true);
        border3.setFillColor(new Color(213, 231, 231));

        // create answer GRect area 1
        GRect answerBox = new GRect(getWidth()+2,getHeight()/6);
        add(answerBox,-1,(getHeight()/10) * 7.2);
        answerBox.setFilled(true);
        answerBox.setColor(new Color(213, 231, 231));
        answerBox.sendToBack();

        GRect answerBox2 = new GRect(getWidth()+2,getHeight()/6);
        add(answerBox2,-1,(getHeight()/10) * 7.36);
        answerBox2.setFilled(true);
        answerBox2.setColor(new Color(171, 204, 204));
        answerBox2.sendToBack();
    }

    private void createInputFields(){
        // create coor1 (coordinate 1) text field
        add(input, getWidth()/2 - getWidth()/10,(getHeight()/40) * 12);
        input.setVisible(true);
        input.setText("");

        // create input labels
        JLabel coor1Label = new JLabel("Leg A:");
        add(coor1Label,(getWidth() * 0.15), (getHeight()/40) * 13);
        JLabel coor2Label = new JLabel("Leg B:");
        add(coor2Label,(getWidth() * 0.15), (getHeight()/40) * 19);
        JLabel coor3Label = new JLabel("Leg C:");
        add(coor3Label,(getWidth() * 0.15), (getHeight()/40) * 25);

    }

    private void createJButtons(){
        JButton calculate = new JButton("Calculate");
        add(calculate,(getWidth() * 0.085),(getHeight()/40) * 24);

        JButton clear = new JButton("Clear");
        add(clear, getWidth() * 0.4,(getHeight()/40) * 24);

        addActionListeners();
    }

    private void calculate() {
       // calculate

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Calculate":
                calculate();
                break;
            case "Clear":
                clear();
                break;
        }
    }

    private void clear(){
        // clear inputs
        input.setText("");

        // clear answer
        answer.setText("");
    }

}
