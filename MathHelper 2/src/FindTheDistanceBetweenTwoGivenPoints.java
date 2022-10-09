import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class FindTheDistanceBetweenTwoGivenPoints extends GraphicsProgram {

    JFormattedTextField coor1 = new JFormattedTextField("                           ");
    JFormattedTextField coor2 = new JFormattedTextField("                           ");

    JLabel answer = new JLabel("<html>  </html>");
    JLabel answer2 = new JLabel("<html>  </html>");

    private static final Pattern listAsString = Pattern.compile("^\\[?([^\\[\\]]*)\\]?$");

    private List<String> getList(String value) {
        Matcher matcher = listAsString.matcher((String) value);
        if (matcher.matches()) {
            String[] split = matcher.group(matcher.groupCount()).split("\\s*,\\s*");
            return new ArrayList<>(Arrays.asList(split));
        }
        return Collections.emptyList();
    }

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
        GProgramHeader programHeader = new GProgramHeader(this,"<html>Find the distance and midpoint<p>between two given points</html>");
        add(programHeader,0,0);

        // add the answer label
        add(answer,getWidth() * 0.1,getHeight()/2 + getHeight()/4);
        answer.setBounds(answer.getX(),answer.getY(),1000,answer.getHeight());

        add(answer2,getWidth() * 0.1,getHeight()/2 + getHeight()/4 + answer.getHeight());
        answer2.setBounds(answer2.getX(),answer2.getY(),1000,answer.getHeight());
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
        add(coor1, getWidth()/2 - getWidth()/10,(getHeight()/40) * 12);
        coor1.setVisible(true);
        coor1.setText("");

        // create coor2 (coordinate 2) text field
        add(coor2, getWidth()/2 - getWidth()/10,(getHeight()/40) * 18);
        coor2.setVisible(true);
        coor2.setText("");

        // create input labels
        JLabel coor1Label = new JLabel("Point A:");
        add(coor1Label,(getWidth() * 0.15), (getHeight()/40) * 13);
        JLabel coor2Label = new JLabel("Point B:");
        add(coor2Label,(getWidth() * 0.15), (getHeight()/40) * 19);

    }

    private void createJButtons(){
        JButton calculate = new JButton("Calculate");
        add(calculate,(getWidth() * 0.085),(getHeight()/40) * 24);

        JButton clear = new JButton("Clear");
        add(clear, getWidth() * 0.4,(getHeight()/40) * 24);

        addActionListeners();
    }

    private void calculate() {

        // clear answer box
        answer.setText("");

        // convert the Strings to an array
        String[] point1Arr = MHEngine.convertStringToArray(coor1.getText(),"(),[ ]*");
        String[] point2Arr = MHEngine.convertStringToArray(coor2.getText(),"(),[ ]*");

        // assigning points to the values given
        Point p1 = new Point(Double.parseDouble(point1Arr[0]),Double.parseDouble(point1Arr[1]));
        Point p2 = new Point(Double.parseDouble(point2Arr[0]),Double.parseDouble(point2Arr[1]));

        // telling the MathHelperEngine to calculate
        String[] answers = MHEngine.findDistanceOfTwoPoints(p1,p2);

        // displaying the answers
        answer.setText(answers[0]);
        answer2.setText(answers[1]);

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
        coor1.setText("");
        coor2.setText("");
        answer.setText("");
        answer2.setText("");
    }

}
