package master.work.intersection.simulation.main;

import master.work.intersection.simulation.controller.PretimedController;

import master.work.intersection.simulation.detector.util.RandomDistribution;
import master.work.intersection.simulation.intersec.FourWayIntersection;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        //TODO: consider what parameters should be passed into Intersection
        Intersection intersection = new FourWayIntersection(new RandomDistribution(), 4, 12);

        Controller controller = new PretimedController(intersection);

        controller.launch();

    }
}
