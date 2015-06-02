package master.work.intersection.simulation.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Oleksander.Dushyn on 6/2/2015.
 */
public class MainForm {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Intersection traffic simulation");
        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*for(int i =0; i<2; i++){
            frame.getContentPane().add(new Label("dasdasds " + i));
        }*/
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
