package master.work.intersection.simulation.main;

import master.work.intersection.simulation.controller.PretimedController;
import master.work.intersection.simulation.detector.util.RandomDistribution;
import master.work.intersection.simulation.intersec.FourWayIntersection;
import master.work.intersection.simulation.statistics.Statistics;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Intersection intersection = new FourWayIntersection(new RandomDistribution(), 4, 12);

        Controller controller = new PretimedController(intersection, new Statistics(intersection));

        controller.launch();

    }
}
