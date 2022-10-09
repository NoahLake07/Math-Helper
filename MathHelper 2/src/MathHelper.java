import acm.program.GraphicsProgram;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MathHelper extends GraphicsProgram {

    Color background = new Color(183, 211, 211);
    JButton pg1, pg2, pg3;
    JLabel navIndicator;
    private int currentPage = 1;

    // page 1 buttons
    JButton disBetweenTwoPoints, basicTrigCalc;

    @Override
    public void init(){

        customizeWindow();

        addJButtons();

        navIndicator = new JLabel("null");
        updatePage();
        add(navIndicator, getWidth()/40,getHeight() - 30);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        switch(ae.getActionCommand()){
            // Page Navigation
            case "Page 1":
                currentPage = 1;
                updatePage();
                break;

            case "Page 2":
                currentPage = 2;
                updatePage();
                break;

            case "Page 3":
                currentPage = 3;
                updatePage();
                break;

            // page 1
            case "<html>Find the distance and midpoint between two points</html>":
                 new FindTheDistanceBetweenTwoGivenPoints().start();
                break;
            case "<html>Basic Trig Calculator</html>":
                new BasicTrig().start();
                break;

            default:
                System.out.println("Unknown Button Clicked");
        }

    }

    private void addJButtons(){
        // instantiating navigation buttons
        pg1 = new JButton("Page 1");
        pg2 = new JButton("Page 2");
        pg3 = new JButton("Page 3");

        // adding navigation buttons
        add(pg1,SOUTH);
        add(pg2,SOUTH);
        add(pg3,SOUTH);

        // instantiating page 1 options
        disBetweenTwoPoints = new JButton("<html>Find the distance and midpoint between two points</html>");
        basicTrigCalc = new JButton("<html>Basic Trig Calculator</html>");

        // adding page 1 options
        add(disBetweenTwoPoints, getWidth()/30, getHeight()/30);
        add(basicTrigCalc, getWidth()/30, (getHeight()/30)*2);

        // modifying page 1 options
        disBetweenTwoPoints.setBounds(getX(),getY(),150,150);
        basicTrigCalc.setBounds(getX(),getY(),150,150);

        addActionListeners();
    }

    private void customizeWindow(){
        this.getMenuBar().setVisible(false);
        this.setBackground(background);
        this.setTitle("MathHelper");
    }

    private void updatePage(){

        if(currentPage == 1){
            // hide other pages

            // show current page
        }

        if(currentPage == 2){
            // hide other pages

            // show current page
        }

        if(currentPage == 3){
            // hide other pages

            // show current page
        }

        if(currentPage == 4){
            // hide other pages

            // show current page
        }

        navIndicator.setText("Page " + currentPage);
    }

    public static void main(String[] args) {
        new MathHelper().start();
    }

}
