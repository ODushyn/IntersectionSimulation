package master.work.intersection.simulation.gui;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Oleksander.Dushyn on 6/2/2015.
 */
public class IntersectionSimulationFrame extends JFrame {
    private JPanel basePanel = new JPanel();
    private JPanel intersectionPanel = new JPanel();
    private JPanel phasePanel = new JPanel();
    private JPanel controlPanel = new JPanel();

    public void createAndShowGUI() {
        basePanel.setLayout(null);
        //basePanel.setSize(800, 1000);

        controlPanel.setSize(100,100);
        controlPanel.setLayout(new GridLayout(1,3));
        controlPanel.add(new Button("Start"));
        controlPanel.add(new Button("Stop"));
        controlPanel.add(new Button("Start"));
        intersectionPanel.setLayout(new GridLayout(15,1));
        intersectionPanel.setSize(200,200);
        for(int i =0; i<11; i++){
            intersectionPanel.add(new Label("Phase " + i));
        }

        basePanel.add(intersectionPanel);
        basePanel.add(controlPanel);

        this.setContentPane(basePanel);
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                IntersectionSimulationFrame mf = new IntersectionSimulationFrame();
                mf.createAndShowGUI();
            }
        });
    }
}
