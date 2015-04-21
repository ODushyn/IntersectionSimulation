package master.work.intersection.simulation.main;

import master.work.intersection.simulation.controller.PretimedController;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Controller controller = new PretimedController();
        controller.launch();

    }
}
