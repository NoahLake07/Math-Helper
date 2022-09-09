import acm.program.GraphicsProgram;
import svu.csc213.Dialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MathHelper extends GraphicsProgram {

    Color background = new Color(183, 211, 211);
    JButton pg1, pg2, pg3;
    JLabel navIndicator;
    private int currentPage = 1;

    // page 1 buttons
    JButton disBetweenTwoPoints;

    @Override
    public void init(){

        customizeWindow();

        addJButtons();

        navIndicator = new JLabel("null");
        updateNavigation();
        add(navIndicator, getWidth()/40,getHeight() - 30);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        switch(ae.getActionCommand()){
            // Page Navigation
            case "Page 1":
                currentPage = 1;
                updateNavigation();
                break;

            case "Page 2":
                currentPage = 2;
                updateNavigation();
                break;

            case "Page 3":
                currentPage = 3;
                updateNavigation();
                break;

            // page 1
            case "<html>Find the distance and midpoint between two points</html>":
                // start the FindDistanceBetweenTwoPoints (FTDBTP) class
                 new FindTheDistanceBetweenTwoGivenPoints().start();
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

        // adding page 1 options
        add(disBetweenTwoPoints, getWidth()/30, getHeight()/30);

        // modifying page 1 options
        disBetweenTwoPoints.setBounds(getX(),getY(),150,150);

        addActionListeners();
    }

    private void customizeWindow(){
        this.getMenuBar().setVisible(false);
        this.setBackground(background);
        this.setTitle("MathHelper");
    }

    private void updateNavigation(){
        navIndicator.setText("Page " + currentPage);
    }

    public static void main(String[] args) {
        new MathHelper().start();
    }

}
